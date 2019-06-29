package com.qinggong.demo.dao;

import com.qinggong.demo.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ScoreDao extends JpaRepository<Score,String> {
    //学生按名字查找分数
    Score findByUsername(String username);

    //查看所有学生分数
    List<Score> findAll();

    //查询全体单科分数
}
