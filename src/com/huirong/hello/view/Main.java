package com.huirong.hello.view;

import com.huirong.hello.domain.Employee;
import com.huirong.hello.utils.MySessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
//        insert(100);
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
            session = factory.openSession();
            transaction = null;
            for (int i = 0; i < number; i++){
                transaction = session.beginTransaction();
                Employee employee = new Employee();
                employee.setName("huirong" + i);
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
            double num = 10 / 0;
            employee.setEmail("nanhuirong@gmail123.com");
            transaction.commit();
        }catch (Exception e){
            if (transaction != null)
                //事务回滚功能
                transaction.rollback();
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
