package com.huirong.hello.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by huirong on 17-5-11.
 */
public class Course implements Serializable{
    private static final long serialVersionUID = 4121808010040337738L;
    private Long id;
    private String name;
    private Long credit;
    private Set stuCourse = new HashSet();

    public Course() {
    }

    public Course(String name, Long credit) {
        this.name = name;
        this.credit = credit;
    }

    public Course(String name, Long credit, Set stuCourses) {
        this.name = name;
        this.credit = credit;
        this.stuCourse = stuCourses;
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

    public Long getCredit() {
        return credit;
    }

    public void setCredit(Long credit) {
        this.credit = credit;
    }

    public Set getStuCourse() {
        return stuCourse;
    }

    public void setStuCourse(Set stuCourses) {
        this.stuCourse = stuCourses;
    }
}
