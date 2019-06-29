package com.qinggong.demo.dao;

import com.qinggong.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao extends JpaRepository<Student,Integer> {
    Student findAllByUsername(String name);

    //验证用户是否存在
    boolean existsByUsernameAndPassword(String username, String password);

    Student findById(int id);

    //按用户昵称查找
    List<Student> findAllByNickname(String nickname);

    List<Student> findAll();

    //按班级查看学生
    List<Student> findAllByCid(String cid);


}
