package com.huirong.hello.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by huirong on 17-5-10.
 * 一般应该被序列化
 * 可以被称为domain object  java bean  pojo
 */
public class Employee  implements Serializable{
    private static final long serialVersionUID = 4960663657289319701L;
    private Integer id;
    private String name;
    private String email;
    private Date time;

    public Employee() {
    }

    public Employee(String name, String email, Date time) {
        this.name = name;
        this.email = email;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", time=" + time +
                '}';
    }
}
