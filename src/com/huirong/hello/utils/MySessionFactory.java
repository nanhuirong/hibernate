package com.huirong.hello.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by huirong on 17-5-10.
 * 保证只有一个SessionFactory
 */
final public class MySessionFactory {
    private static SessionFactory factory = null;
    private static Configuration configuration = null;
    //只会被调用一次
    static {
        configuration = new Configuration().configure();
        factory = configuration.buildSessionFactory();
    }

    public MySessionFactory() {
    }
    public static SessionFactory getSessionFactory(){
        return factory;
    }
}
