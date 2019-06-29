package com.qinggong.demo.dao;

import com.qinggong.demo.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherDao extends JpaRepository<Teacher,Integer> {

    Teacher findAllByUsername(String name);

    //验证用户是否存在
    boolean existsByUsernameAndPassword(String username, String password);

    Teacher findById(int id);

    //按用户昵称查找
    List<Teacher> findAllByNickname(String nickname);

    List<Teacher> findAll();


}
