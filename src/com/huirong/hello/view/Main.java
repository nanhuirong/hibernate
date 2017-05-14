package com.huirong.hello.view;

import com.huirong.hello.domain.Employee;
import com.huirong.hello.utils.MySessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.lang.annotation.ElementType;
import java.util.Date;
import java.util.List;

/**
 * Created by huirong on 17-5-10.
 */
public class Main {
    private static SessionFactory factory = MySessionFactory.getSessionFactory();

    public static void main(String[] args) {
        insert(1);
        update();
//        delete();
        search();

        factory.close();
    }

    //插入数据
    public static void insert( int number){
        Session session = null;
        Transaction transaction = null;
        try{
            /**
             * 线程不安全，持久话接口
             * 1.单线程，短生命周期对象
             * 2.封装JDBC的链接对象
             * 3.作为一个事务的工厂，维护domain对象的持久化内容（一级缓存）
             */
            session = factory.openSession();
            transaction = null;
            for (int i = 0; i < number; i++){
                transaction = session.beginTransaction();
                Employee employee = new Employee();
                employee.setName("南慧" + i);
                employee.setEmail("nanhuirong@163.com");
                employee.setTime(new Date());
                //保存数据
                session.save(employee);
                transaction.commit();
            }
        }catch (Exception e){
            if (transaction != null){
                //事务回滚
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }finally {
            if (session != null && session.isOpen())
                session.close();
        }

    }

    //查询,一般采用HQL实现数据库的解偶
    public static void search(){
        Session session = null;
        Transaction transaction = null;
        try{
            session = factory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Employee where id = 180");
            List<Employee> list = query.list();
            for (Employee employee : list){
                System.out.println(employee);
            }
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

    //修改，增加事务回滚的功能
    public static void update(){
        Session session = MySessionFactory.getSessionFactory().openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            Employee employee = (Employee) session.load(Employee.class, 150);
//            double num = 10 / 0;
            employee.setEmail("nanhuirong@gmail123.com");
            transaction.commit();
        }catch (Exception e){
            if (transaction != null)
                //事务回滚功能
                transaction.rollback();
            throw new RuntimeException(e);
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }

    //删除
    public static void delete(){
        Session session = null;
        Transaction transaction = null;
        try{
            session = factory.openSession();
            transaction = session.beginTransaction();
            Employee employee = session.load(Employee.class, 150);
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
}
