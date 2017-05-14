package com.huirong.hello.view;

import com.huirong.hello.domain.Course;
import com.huirong.hello.domain.Student;
import com.huirong.hello.domain.StudentCourse;
import com.huirong.hello.utils.MySessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by huirong on 17-5-11.
 */
public class StudentMain {
    private static SessionFactory factory = MySessionFactory.getSessionFactory();

    public static void main(String[] args) {
//        initDatabase();
        getHQL();
        factory.close();
    }

    public static void initDatabase(){
        //插入学生表
        Session session = null;
        Transaction transaction = null;
        try{
            session = factory.getCurrentSession();
            transaction = session.beginTransaction();
            Student student = null;
            Course course = null;
            //插入学生表
//            Student student = new Student("林青霞", "F", "计算机系", 22L, "上海");
//            session.save(student);
//            student = new Student("刘德华", "M", "外语系", 23L, "南京");
//            session.save(student);
//            student = new Student("成龙", "M", "化学系", 21L, "山东");
//            session.save(student);
//            student = new Student("林可欣", "F", "计算机系", 22L, "北京");
//            session.save(student);
//            student = new Student("周华健", "M", "生物系", 24L, "山东");
//            session.save(student);
//            student = new Student("周润发", "M", "数学系", 20L, "湖北");
//            session.save(student);
//
//            Course course = new Course("java", 6L);
//            session.save(course);
//            course = new Course("c++", 4L);
//            session.save(course);
//            course = new Course("oracle", 3L);
//            session.save(course);
//            course = new Course("javaEE", 5L);
//            session.save(course);
//            course = new Course("linux", 10L);
//            session.save(course);

            student = session.load(Student.class, 1L);
            course = session.load(Course.class, 1L);
            StudentCourse stuCourse = new StudentCourse(student, course, 90L);
            session.save(stuCourse);
            course = session.load(Course.class, 3L);
            stuCourse = new StudentCourse(student, course, 19L);
            session.save(stuCourse);

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

    //测试HQL语句
    public static void getHQL(){
        Session session = null;
        Transaction transaction = null;
        try{
            session = factory.getCurrentSession();
            transaction = session.beginTransaction();
            //查询数据库的所有学生
//            Query query = session.createQuery("from Student");
//            List<Student> student = query.list();
//            for (Student stu : student){
//                System.out.println(stu.getName() + "\t" + stu.getStuCourse().size());
//            }
            //查询表的部分属性
//            Query query = session.createQuery("select name,sex from Student");
//            List list = query.list();
//            for (int i = 0; i < list.size(); i++){
//                Object[] obj = (Object[]) list.get(i);
//                System.out.println(obj[0] + "\t" + obj[1]);
//            }
//            Query query = session.createQuery("from Student where id = '1'");
////           //如果查询结果至多只有一个，就采用该方法
//            Student student = (Student)query.uniqueResult();

            //过滤重复记录
//            Query query = session.createQuery(
//                    "select distinct age,sex from Student where age between 20 and 22");
            //in
            Query query = session.createQuery(
                    "select name, age, sex from Student where dept in ('计算机系', '外语系')");
            query = session.createQuery("from Student where dept not in ('计算机系', '外语系')");
            //分组
            query = session.createQuery("select avg(age), dept from Student group by dept");

            query = session.createQuery(
                    "select count(*), dept from Student group by dept having count(*) > 3");
            query = session.createQuery(
                    "select coun(*), dept where sex = 'F' group by dept having count(*) > 3"
            );
            //查询计算机系学生的人数
            query = session.createQuery(
                    "select count(*) where dept = '计算机系'");
            query = session.createQuery("select sum(grade) from StudentCourse");

            query = session.createQuery(
                    "select min(grade),max(grade) from StudentCourse where course.id = 11");

            //数据库分页,从第10行开始取出100条
            query.setFirstResult(10);
            query.setMaxResults(100);

            //参数绑定，：按照名字设定，？按照位置进行设定
            query = session.createQuery("select count(*) where dept = :dept");
            query.setParameter("dept", "计算机系");
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
