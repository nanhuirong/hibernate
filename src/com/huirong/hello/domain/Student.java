package com.huirong.hello.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by huirong on 17-5-11.
 */
public class Student implements Serializable{
    private static final long serialVersionUID = -158534077301878825L;
    private Long id;
    private String name;
    private String sex;
    private String dept;
    private Long age;
    private String address;
    //表述1对多关系
    private Set stuCourse = new HashSet();

    public Student() {
    }

    public Student(String name, String sex, String dept, Long age, String address) {
        this.name = name;
        this.sex = sex;
        this.dept = dept;
        this.age = age;
        this.address = address;
    }

    public Student(String name, String sex, String dept, Long age, String address, Set stuCourse) {
        this.name = name;
        this.sex = sex;
        this.dept = dept;
        this.age = age;
        this.address = address;
        this.stuCourse = stuCourse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set getStuCourse() {
        return stuCourse;
    }

    public void setStuCourse(Set stuCourse) {
        this.stuCourse = stuCourse;
    }
}
