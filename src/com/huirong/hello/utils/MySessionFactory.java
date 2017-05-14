package com.huirong.hello.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by huirong on 17-5-10.
 * 保证只有一个SessionFactory
 */
final public class MySessionFactory {
    /**
     *单个数据库映射关系的内存镜像，是线程安全的，是生成session的工厂。
     * 1.一级缓存（Session级别缓存），缓存SQL缓存和数据
     * 2.保证一个应用程序中有一个SessionFactory对象（单列对象），一般一个数据库对象一个对象
     * 3.获取session实例，
     *      openSession()   获取一个新的session，需要手动提交
     *      getCurrentSession() 获取和当前线程绑定的session对象，利于事务的控制
     *                          需要事先进行配置，自动进行关闭，并且需要事务绑定
     */
    private static SessionFactory factory = null;
    /**
     * 1.负责管理hibernate配置信息
     * 2.读取hibernate.cfg.xml
     * 3.管理对象映射文件
     * 4.加载hibernate的驱动
     */
    private static Configuration configuration = null;
    //只会被调用一次
    static {
        configuration = new Configuration().configure("com/huirong/conf/hibernate.cfg.xml");
        factory = configuration.buildSessionFactory();
    }

    public MySessionFactory() {
    }
    public static SessionFactory getSessionFactory(){
        return factory;
    }
}
