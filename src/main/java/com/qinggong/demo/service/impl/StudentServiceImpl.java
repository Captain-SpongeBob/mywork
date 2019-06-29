package com.qinggong.demo.service.impl;

import com.qinggong.demo.dao.ScoreDao;
import com.qinggong.demo.dao.StudentDao;
import com.qinggong.demo.entity.Score;
import com.qinggong.demo.entity.Student;

import com.qinggong.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("unchecked")
@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private ScoreDao scoreDao;

    public int register(String username, String password, String nickname) {
        studentDao.save(new Student(username,password,nickname));
        return 0;
    }

    //验证用户是否存在
    public boolean login(String username, String password) {
        return studentDao.existsByUsernameAndPassword(username,password);
    }

    //按ID查找
    public Student queryById(int id) {
            return studentDao.findById(id);
    }


    public List<Student> queryList() {
        List<Student> list = studentDao.findAll();
        while(list.size() != 0 )
            return list;

        return null;
    }

    @Override
    public List<Student> queryByNickname(String nickname) {
        List<Student> student = studentDao.findAllByNickname(nickname);
        if(student.size() != 0)
            return student;
        return null;
    }

    @Override
    public List<Student> queryByCid(String cid) {
       List<Student> students = studentDao.findAllByCid(cid);
       if (students.size() != 0)
           return students;
        return null;
    }

    @Override
    public Score querySelfScore(String username) {
        Score score = scoreDao.findByUsername(username);
        if (score != null)
            return score;
        return null;
    }

    @Override
    public Object getObject(String key) {


        return null;
    }

    @Override
    public void saveObject(String key, Object value, Long expire) {

    }
}
