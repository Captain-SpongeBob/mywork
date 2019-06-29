package com.qinggong.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qinggong.demo.dao.ScoreDao;
import com.qinggong.demo.entity.ClassTable;
import com.qinggong.demo.entity.Score;
import com.qinggong.demo.entity.Student;
import com.qinggong.demo.service.StudentService;
import com.qinggong.demo.service.impl.StudentServiceImpl;
import com.qinggong.demo.service.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
/**
 * 学生控制器
 *
 */

@RestController
public class StudentController {
        private final Logger logger = LoggerFactory.getLogger(this.getClass());

        @Autowired
        private StudentService studentService;

        @Autowired
        private ScoreDao scoreDao;


        // 发送验证码
//        @PostMapping(value = "/smscode")
//        public JSONObject smscode(String username) {
//            StringBuilder loginfo = new StringBuilder();
//            loginfo.append("/smscode - ").append("username=").append(username);
//            logger.warn(loginfo.toString());
//
//            int code = new Random().nextInt(999999);
//            if (code < 100000) {
//                code = code + 100000;
//            }
//            studentService.saveObject(username, String.valueOf(code), 30000L);
//
//            return ResultUtils.jsonResult(new JSONArray(), new JSONObject(), String.valueOf(code));
//        }
//
//        // 校验验证码
//        @PostMapping(value = "/checkcode")
//        public JSONObject checkcode(String username, String smscode) {
//            StringBuilder loginfo = new StringBuilder();
//            loginfo.append("/checkcode - ").append("username=").append(username).append("&smscode=").append(smscode);
//            logger.warn(loginfo.toString());
//
//            Object object = studentService.getObject(username);
//            if (null == object) {
//                return ResultUtils.failure(10003, "resource not found");
//            }
//
//            String code = (String) object;
//            if (!code.equalsIgnoreCase(smscode)) {
//                return ResultUtils.failure(10004, "validate code error");
//            }
//
//            return ResultUtils.success();
//        }

    // 学生注册
    @PostMapping(value = "/stu_register")
    public JSONObject register(String username, String password, String nickname) {
        StringBuilder loginfo = new StringBuilder();
        loginfo.append("/register - ").append("username=").append(username).append("&password=").append(password).append("&nickname=").append(nickname);
        logger.warn(loginfo.toString());

        if (null == username || null == password) {
            return ResultUtils.failure(10002, "params required");
        }
        if (null == nickname) {
            nickname = "dogegg";
        }

        System.out.println(username +"  " + nickname);
        int flag = studentService.register(username, password, nickname);
        System.out.println(flag);

        return ResultUtils.success();
    }

    @RequestMapping(value = "/index")
    public String index(){
        return "you success";
    }

    // 学生登录
    @GetMapping(value = "/stu_login")
    public JSONObject login(String username, String password) {
        StringBuilder loginfo = new StringBuilder();
        loginfo.append("/login - ").append("username=").append(username).append("&password=").append(password);
        logger.warn(loginfo.toString());

        if (null == username || null == password) {
            return ResultUtils.failure(10002, "params required");
        }

        boolean flag = studentService.login(username, password);
        System.out.println(flag);

        return ResultUtils.success();
    }

    // 依据编码查询学生
    @GetMapping(value = "/stu_get")
    public JSONObject get(int id) {
        StringBuilder loginfo = new StringBuilder();
        loginfo.append("/get - ").append("id=").append(id);
        logger.warn(loginfo.toString());

        if (0 == id || -1 == id) {
            return ResultUtils.failure(10002, "params required");
        }

        Student student = studentService.queryById(id);
        if (null == student) {
            return ResultUtils.failure(10003, "resource not found");
        }

        return ResultUtils.jsonResult(new JSONArray(), JSONObject.parseObject(student.toString()), "");
    }


    // 查询全部学生
    @GetMapping(value = "/stu_list")
    public JSONObject list() {

        StringBuilder loginfo = new StringBuilder();
        loginfo.append("/list - ");
        logger.warn(loginfo.toString());

        List<Student> list = studentService.queryList();
        if (null == list || 0 == list.size()) {
            return ResultUtils.failure(10003, "resource not found");
        }

        JSONArray items = new JSONArray();
        for(Student student: list) {
            items.add(student);
        }
        return ResultUtils.jsonResult(items, new JSONObject(), "");
    }

    // 依据昵称查询学生
    @GetMapping(value = "/stu_list2")
    public JSONObject list2(String nickname) {
        StringBuilder loginfo = new StringBuilder();
        loginfo.append("/list2 - ").append("nickname=").append(nickname);
        logger.warn(loginfo.toString());

        List<Student> list = studentService.queryByNickname(nickname);
        if (null == list || 0 == list.size()) {
            return ResultUtils.failure(10003, "resource not found");
        }

        JSONArray items = new JSONArray();
        for(Student student : list) {
            items.add(student);


        }
        return ResultUtils.jsonResult(items, new JSONObject(), "");
    }


//    //查看学生课表
//    @GetMapping(value = "/stu_table")
//    public JSONObject stuTable(String username){
////        StringBuilder loginfo = new StringBuilder();
////        loginfo.append("/stu_table - ").append("username=").append(username);
////        logger.warn(loginfo.toString());
////
////        List<Student> list = studentService.queryByNickname(username);
////        if (null == list || 0 == list.size()) {
////            return ResultUtils.failure(10003, "resource not found");
////        }
////
////        JSONArray items = new JSONArray();
////        for(ClassTable classTable : list) {
////            items.add(classTable);
////        }
//        return ResultUtils.jsonResult(items, new JSONObject(), "");
//    }

    //查看个人分数
    @GetMapping(value = "/stu_score")
    public JSONObject score(String username){
        StringBuilder loginfo = new StringBuilder();
        loginfo.append("/stu_score - ").append("username=").append(username);
        logger.warn(loginfo.toString());

       Score score = studentService.querySelfScore(username);
        if (null == score) {
            return ResultUtils.failure(10003, "resource not found");
        }

        JSONArray items = new JSONArray();
            items.add(score);
        return ResultUtils.jsonResult(items, new JSONObject(), "");
    }




}
