package com.qinggong.demo.controller;

import java.util.List;
import java.util.Random;

import com.qinggong.demo.entity.Score;
import com.qinggong.demo.entity.Student;
import com.qinggong.demo.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qinggong.demo.entity.Teacher;
import com.qinggong.demo.service.TeacherService;
import com.qinggong.demo.service.utils.ResultUtils;

/**
 * 教师控制器
 * 
 */
@RestController
public class TeacherController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private TeacherService teacherService;
	@Autowired
	private StudentService studentService;

	// 发送验证码
//	@PostMapping(value = "/smscode")
//	public JSONObject smscode(String username) {
//		StringBuilder loginfo = new StringBuilder();
//		loginfo.append("/smscode - ").append("username=").append(username);
//		logger.warn(loginfo.toString());
//
//		int code = new Random().nextInt(999999);
//		if (code < 100000) {
//			code = code + 100000;
//		}
//		teacherService.saveObject(username, String.valueOf(code), 30000L);
//
//		return ResultUtils.jsonResult(new JSONArray(), new JSONObject(), String.valueOf(code));
//	}

//	// 校验验证码
//	@PostMapping(value = "/checkcode")
//	public JSONObject checkcode(String username, String smscode) {
//		StringBuilder loginfo = new StringBuilder();
//		loginfo.append("/checkcode - ").append("username=").append(username).append("&smscode=").append(smscode);
//		logger.warn(loginfo.toString());
//
//		Object object = teacherService.getObject(username);
//		if (null == object) {
//			return ResultUtils.failure(10003, "resource not found");
//		}
//
//		String code = (String) object;
//		if (!code.equalsIgnoreCase(smscode)) {
//			return ResultUtils.failure(10004, "validate code error");
//		}
//
//		return ResultUtils.success();
//	}

    // 教师注册
    @PostMapping(value = "/register")
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

        int flag = teacherService.register(username, password, nickname);
        System.out.println(flag);

        return ResultUtils.success();
    }

    // 教师登录
    @GetMapping(value = "/login")
    public JSONObject login(String username, String password) {
        StringBuilder loginfo = new StringBuilder();
        loginfo.append("/login - ").append("username=").append(username).append("&password=").append(password);
        logger.warn(loginfo.toString());

        if (null == username || null == password) {
            return ResultUtils.failure(10002, "params required");
        }

        boolean flag = teacherService.login(username, password);
        System.out.println(flag);

        return ResultUtils.success();
    }

    // 依据编码查询教师
    @GetMapping(value = "/get")
    public JSONObject get(int id) {
        StringBuilder loginfo = new StringBuilder();
        loginfo.append("/get - ").append("id=").append(id);
        logger.warn(loginfo.toString());

        if (0 == id || -1 == id) {
            return ResultUtils.failure(10002, "params required");
        }

        Teacher teacher = teacherService.queryById(id);
        if (null == teacher) {
            return ResultUtils.failure(10003, "resource not found");
        }

        return ResultUtils.jsonResult(new JSONArray(), JSONObject.parseObject(teacher.toString()), "");
    }

    // 查询全部教师
    @GetMapping(value = "/list")
    public JSONObject list() {
        StringBuilder loginfo = new StringBuilder();
        loginfo.append("/list - ");
        logger.warn(loginfo.toString());

        List<Teacher> list = teacherService.queryList();
        if (null == list || 0 == list.size()) {
            return ResultUtils.failure(10003, "resource not found");
        }

        JSONArray items = new JSONArray();
        for(Teacher teacher : list) {
            items.add(teacher);
        }
        return ResultUtils.jsonResult(items, new JSONObject(), "");
    }

    // 依据昵称查询教师
    @GetMapping(value = "/list2")
    public JSONObject list2(String nickname) {
        StringBuilder loginfo = new StringBuilder();
        loginfo.append("/list2 - ").append("nickname=").append(nickname);
        logger.warn(loginfo.toString());

        List<Teacher> list = teacherService.queryByNickname(nickname);
        if (null == list || 0 == list.size()) {
            return ResultUtils.failure(10003, "resource not found");
        }

        JSONArray items = new JSONArray();
        for(Teacher teacher : list) {
            items.add(teacher);
        }
        return ResultUtils.jsonResult(items, new JSONObject(), "");
    }

    // 按班级查看学生
    @GetMapping(value = "/stu_class")
    public JSONObject cid(String cid) {
        StringBuilder loginfo = new StringBuilder();
        loginfo.append("/stu_class - ").append("cid=").append(cid);
        logger.warn(loginfo.toString());

        List<Student> list = studentService.queryByCid(cid);
        if (null == list || 0 == list.size()) {
            return ResultUtils.failure(10003, "resource not found");
        }

        JSONArray items = new JSONArray();
        for(Student student : list) {
            items.add(student);
        }
        return ResultUtils.jsonResult(items, new JSONObject(), "");
    }

    // 查询全部学生分数
    @GetMapping(value = "/scores")
    public JSONObject scores() {

        StringBuilder loginfo = new StringBuilder();
        loginfo.append("/scores - ");;
        logger.warn(loginfo.toString());

        List<Score> list = teacherService.queryAllScore();
        if (null == list || 0 == list.size()) {
            return ResultUtils.failure(10003, "resource not found");
        }

        JSONArray items = new JSONArray();
        for(Score score: list) {
            items.add(score);
        }
        return ResultUtils.jsonResult(items, new JSONObject(), "");
    }

    //查看单科平局分
    @GetMapping(value = "/single_score")
    public JSONObject sinleAverge(String subject){
        StringBuilder loginfo = new StringBuilder();
        loginfo.append("/single_score - ");
        logger.warn(loginfo.toString());

        List<Score> list = teacherService.queryAllScore();
        if (null == list || 0 == list.size()) {
            return ResultUtils.failure(10003, "resource not found");
        }

        JSONArray items = new JSONArray();
        int buffet = 0 ;
        for(Score score: list) {
            buffet += score.getSingleScore(subject);
        }
        items.add(buffet);
        return ResultUtils.jsonResult(items, new JSONObject(), "");
    }
}
