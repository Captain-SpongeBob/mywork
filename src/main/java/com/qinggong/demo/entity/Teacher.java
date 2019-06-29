package com.qinggong.demo.entity;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * 教师实体类
 * 
 */
@Entity
@Table(name="teacher")
public class Teacher implements Serializable, RowMapper<Teacher> {
	private static final long serialVersionUID = -7349758660714907784L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;// 教师编码

    @Column(name="cid")
	private int cid;// 班级编码

    @Column(name="username")
	private String username;// 教师登录名

    @Column(name="password")
	private String password;// 登录密码

    @Column(name="nickname")
	private String nickname;// 昵称

    @Column(name="gender")
    private int gender;// 性别

	@Column(name="avater")
    private String  avatar;


	@Override
	public Teacher mapRow(ResultSet result, int arg1) throws SQLException {
		Teacher teacher = new Teacher();

		teacher.setId(result.getInt("id"));
		teacher.setCid(result.getInt("cid"));
		teacher.setUsername(result.getString("username"));
		teacher.setPassword(result.getString("password"));
		teacher.setNickname(result.getString("nickname"));
		teacher.setGender(result.getInt("gender"));
		teacher.setAvatar(result.getString("avatar"));

		return teacher;
	}

	@Override
	public String toString() {
		return String.format("{\"id\":%d, \"cid\":%d, \"username\":\"%s\", \"password\":\"%s\", \"nickname\":\"%s\", \"gender\":%d, \"avatar\":\"%s\"}", 
				id, cid, username, password, nickname, gender, avatar);
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
