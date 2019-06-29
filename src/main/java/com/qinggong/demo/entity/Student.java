package com.qinggong.demo.entity;

import javax.persistence.*;
/*
学生基本信息

 */
@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;// 学生编码

    @Column(name="cid")
    private int cid;// 班级编码

    @Column(name="username")
    private String username;// 学生登录名

    @Column(name="password")
    private String password;// 登录密码

    @Column(name="nickname")

    private String nickname;// 昵称

    @Column(name="gender")
    private int gender;// 性别

    @Column(name="avater")
    private String  avatar;

//
//    @OneToOne(cascade = CascadeType.REMOVE )
//    private ClassTable classTable;//课表



    public  Student(){}
    public Student(int cid, String username, String password, String nickname, int gender, String avatar) {
        this.cid = cid;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.gender = gender;
        this.avatar = avatar;
    }

    public Student(String username, String password, String nickname) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


}
