package com.qinggong.demo.entity;

import javax.persistence.*;


/**
 *
 * 学生课程表
 */
@Entity
@Table(name = "ClassTable")
public class ClassTable {
    @Id
    private String username;

    @Column(name = "subject")
    private String subject;

    @Column(name = "teacher_name")
    private String teacher_name;

    @Column(name = "classroom")
    private String classroom;

    @Column(name = "time")
    private String time;

//    @OneToOne(mappedBy = "classTable")
//    private Student student;



    public ClassTable() {
    }

    public ClassTable(String username, String subject, String teacher_name, String classroom, String time) {
       this.username = username;
        this.subject = subject;
        this.teacher_name = teacher_name;
        this.classroom = classroom;
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
