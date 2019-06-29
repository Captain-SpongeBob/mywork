
刘东升 
王天娇
淡思宇
张平
郑凤仪

项目后端使用SpringBoot框架，持久层使用JPA，采用maven结构 前端使用Ant Design框架
实现基本的增删改查功能 
    1.输入学生/教师ID进行查询分数、课表 
    2.修改相应信息
端口号：8080 
        **学生端：** 
        1.学生注册 /stu_register 
        2.学生登录 /stu_login 
        3.按学生ID查询信息 /stu_get 
        4.查看个人分数 /stu_score 教师端： 
        **教师端：**
        1.教师登录 /login 
        2.教师注册 /register 
        3.查询全部学生 /stu_list 
        4.按姓名查找学生 /stu_list2 
        5.查看全部教师 /list 
        6.按姓名查看教师 /list2 
        7.按班级查看学生 /stu_class 
        8.查看全部学生分数 /scores 
        9.查看单科分数 /single_score
测试用例：教师 admin 123456 学生 张三 123456