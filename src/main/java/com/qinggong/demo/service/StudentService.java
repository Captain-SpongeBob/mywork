package com.qinggong.demo.service;

import com.qinggong.demo.entity.Score;
import com.qinggong.demo.entity.Student;
import java.util.List;
    /**
     * 学生接口
     *
     * */
     public interface StudentService {
        // 注册
        public int register(String username, String password, String nickname);

        // 登录
        public boolean login(String username, String password);

        // 查询单个教师
        public Student queryById(int id);

        // 教师列表
        public List<Student> queryList();

        // 依据姓名获得教师列表
        public List<Student> queryByNickname(String nickname);

        //依据cid查找学生
        public List<Student> queryByCid(String cid);

        //查看个人分数
       public Score querySelfScore(String username);

        // 从redis中获取数据
        public Object getObject(String key);

        // 保存数据到redis
        public void saveObject(String key, Object value, Long expire);

}
