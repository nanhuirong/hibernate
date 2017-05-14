package com.huirong.hello.domain;

import java.io.Serializable;

/**
 * Created by huirong on 17-5-11.
 */
public class StudentCourse implements Serializable{
    private static final long serialVersionUID = -7713325615340692734L;
    private Long id;
    private Student student;
    private Course course;
    private  Long grade;

    public StudentCourse() {
    }

    public StudentCourse(Student student, Course course, Long grade) {
        this.student = student;
        this.course = course;
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Long getGrade() {
        return grade;
    }

    public void setGrade(Long grade) {
        this.grade = grade;
    }
}
