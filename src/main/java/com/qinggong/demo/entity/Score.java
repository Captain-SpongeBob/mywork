package com.qinggong.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "score")
public class Score {

    @Id
    private int username;

    @Column(name = "math")
    private int math;

    @Column(name = "chinese")
    private int chinese;

    @Column(name = "english")
    private int english;

    @Column(name = "physics")
    private int physics;

    @Column(name = "design_pattern")
    private int design_pattern;


    public Score(int username, int math, int chinese, int english, int physics, int design_pattern) {
        this.username = username;
        this.math = math;
        this.chinese = chinese;
        this.english = english;
        this.physics = physics;
        this.design_pattern = design_pattern;
    }

    public int getSingleScore(String subject){
        if(subject.equals("math"))
            return getMath();
        if(subject.equals("chinese"))
            return getMath();
        if(subject.equals("english"))
            return getMath();
        if(subject.equals("physics"))
            return getMath();
        if(subject.equals("design_pattern"))
            return getMath();

        return -1;
    }


    public int getUsername() {
        return username;
    }

    public void setUsername(int username) {
        this.username = username;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getChinese() {
        return chinese;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getPhysics() {
        return physics;
    }

    public void setPhysics(int physics) {
        this.physics = physics;
    }

    public int getDesign_pattern() {
        return design_pattern;
    }

    public void setDesign_pattern(int design_pattern) {
        this.design_pattern = design_pattern;
    }


}
