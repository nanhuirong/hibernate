package com.huirong.hello.utils;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by huirong on 17-5-11.
 */
final public class HibernateUtil {
    private static ThreadLocal<Session> threadLocal = new ThreadLocal<>();
    private static Configuration configuration = null;
    private static SessionFactory factory = null;
    static {
        configuration = new Configuration().configure("com/huirong/conf/hibernate.cfg.xml");
        factory = configuration.buildSessionFactory();
    }

    public static Session openSession(){
        return factory.openSession();
    }

    public static Session getCurrentSession(){
        Session session = threadLocal.get();
        if (session == null){
            session = openSession();
            threadLocal.set(session);
        }
        return session;
    }

    //统一的更新或删除
    public static void executeUpdate(String hql, String[] param){
        Session session = null;
        Transaction transaction = null;
        List list = null;
        try {
            session = getCurrentSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery(hql);
            if(param != null && param.length > 0){
                for (int i = 0; i < param.length; i++){
                    query.setParameter(i, param[i]);
                }
            }

            query.executeUpdate();
//            list = query.list();
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }

    //统一的添加方法
    public static void save(Object obj){
        Session session = null;
        Transaction transaction = null;
        try{
            session = getCurrentSession();
            transaction = session.beginTransaction();
            session.save(obj);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }

    //统一的HQL执行
    public static List executeHQL(String hql, String[] param){
        Session session = null;
        Transaction transaction = null;
        List list = null;
        try {
            session = getCurrentSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery(hql);
            if(param != null && param.length > 0){
                for (int i = 0; i < param.length; i++){
                    query.setParameter(i, param[i]);
                }
            }
            list = query.list();
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return list;
    }

    public static List executeHQLByPage(String hql, String[] param, int pageSize, int pageNow){
        Session session = null;
        Transaction transaction = null;
        List list = null;
        try {
            session = getCurrentSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery(hql);
            if(param != null && param.length > 0){
                for (int i = 0; i < param.length; i++){
                    query.setParameter(i, param[i]);
                }
            }
            query.setFirstResult((pageNow - 1) * pageSize);
            query.setMaxResults(pageSize);
            list = query.list();
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return list;
    }
}
