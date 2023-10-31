package com.example.demo;

import com.example.demo.beans.HttpResponseEntity;
import com.example.demo.controller.ProjectController;
import com.example.demo.controller.UserController;
import com.example.demo.dao.ProjectEntityMapper;
import com.example.demo.dao.entity.ProjectEntity;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import  com.example.demo.dao.UserEntityMapper;

import com.example.demo.dao.entity.UserEntity;
import com.example.demo.common.utils.UUIDUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;
import java.io.InputStream;
import java.util.List;
import org.apache.log4j.Logger;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {

   @Resource
   private UserController userController;
   @Resource
   private ProjectController projectController;
    Logger log = Logger.getLogger(DemoApplicationTests.class);
    @Test
    public void queryProjectList() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
      ProjectEntityMapper projectEntityMapper = sqlSession.getMapper(ProjectEntityMapper.class);
        //调用userMapper的方法
        ProjectEntity projectEntity = null;
        //projectEntity.setProjectName("5488374");
        HttpResponseEntity httpResponseEntity = projectController.queryProjectList(projectEntity);
//        if(CollectionUtils.isEmpty(httpResponseEntity)){
//            // 记录error级别的信息
//        }else{
        log.info(httpResponseEntity.getData().toString());
            // 记录info级别的信息
            log.info(">>queryUserList项目列表查询测试成功");
      //  }
    }
@Test
public void queryUserList() throws Exception {
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession sqlSession = sqlSessionFactory.openSession();
    //创建UserMapper对象，mybatis自动生成mapper代理对象
    UserEntityMapper projectEntityMapper = sqlSession.getMapper(UserEntityMapper.class);
    //调用userMapper的方法
//    UserEntity userEntity = new UserEntity();
//    userEntity.setUsername("sucdvhu");
    HttpResponseEntity httpResponseEntity = userController.queryUserList(null
    );
//        if(CollectionUtils.isEmpty(httpResponseEntity)){
//            // 记录error级别的信息
//        }else{
    log.info(httpResponseEntity.getData().toString());
    // 记录info级别的信息
    log.info(">>queryUserList项目列表查询测试成功");
    //  }
}


    @Test
    public void selectProjectInfo() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        ProjectEntityMapper projectEntityMapper = sqlSession.getMapper(ProjectEntityMapper.class);
        //调用userMapper的方法
        ProjectEntity projectEntity = new ProjectEntity();

        projectEntity.setProjectName("项目五");
        HttpResponseEntity httpResponseEntity =projectController.selectProjectInfo(projectEntity);
//        if(CollectionUtils.isEmpty(list)){
//            // 记录error级别的信息
//        }else{
       // log.info(httpResponseEntity.getData().toString());
            // 记录info级别的信息
          //  log.info(">>qselectUserInfo项目筛选测试成功");

    }
    @Test
    public void selectUserInfo() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象

        //调用userMapper的方法
        UserEntity userEntity = new UserEntity();

        userEntity.setUsername("admin");
        userEntity.setPassword("123");
        HttpResponseEntity httpResponseEntity =userController.userLogin(userEntity);
//        if(CollectionUtils.isEmpty(list)){
//            // 记录error级别的信息
//        }else{
        // log.info(httpResponseEntity.getData().toString());
        // 记录info级别的信息
        //  log.info(">>qselectUserInfo项目筛选测试成功");

    }

    @Test
    public void modifyProjectInfo() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        ProjectEntityMapper projectEntityMapper = sqlSession.getMapper(ProjectEntityMapper.class);
        //调用userMapper的方法
        ProjectEntity projectEntity = new ProjectEntity();

        projectEntity.setId("26c76e015106474dbf61e5d0cac829c8");
        HttpResponseEntity httpResponseEntity =projectController.modifyProjectInfo(projectEntity);
//        if(CollectionUtils.isEmpty(list)){
//            // 记录error级别的信息
//        }else{
        // log.info(httpResponseEntity.getData().toString());
        // 记录info级别的信息
        //  log.info(">>qselectUserInfo项目筛选测试成功");

    }
    @Test
    public void modifyUser() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        //UserEntityMapper userEntityMapper = sqlSession.getMapper(UserEntityMapper.class);
        //调用userMapper的方法
        UserEntity userEntity = new UserEntity();
//        userEntity.setId("425fe645255b4bb18b8e4629ee70765b");
//        userEntity.setPassword("123");
//        userEntity.setUsername("jxy");
        HttpResponseEntity i = userController.modifyUser(userEntity);
//        if(i==0){
//            // 记录error级别的信息
//        }else{
//            System.out.println(i);
//            // 记录info级别的信息
//            log.info(">>delete用户删除测试成功");
//        }
    }
    @Test
    public void deleteUserByName() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        //UserEntityMapper userEntityMapper = sqlSession.getMapper(UserEntityMapper.class);
        //调用userMapper的方法
        UserEntity userEntity = new UserEntity();
        userEntity.setId("1");
        HttpResponseEntity i = userController.deleteUser(userEntity);
//        if(i==0){
//            // 记录error级别的信息
//        }else{
//            System.out.println(i);
//            // 记录info级别的信息
//            log.info(">>delete用户删除测试成功");
//        }
    }
//
@Test
public void addUser() throws Exception {
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession sqlSession = sqlSessionFactory.openSession();
    //创建UserMapper对象，mybatis自动生成mapper代理对象
    //UserEntityMapper userEntityMapper = sqlSession.getMapper(UserEntityMapper.class);
    //调用userMapper的方法
    UserEntity userEntity = new UserEntity();
    userEntity.setId("10");
    HttpResponseEntity i = userController.addUser(userEntity);
//        if(i==0){
//            // 记录error级别的信息
//        }else{
//            System.out.println(i);
//            // 记录info级别的信息
//            log.info(">>delete用户删除测试成功");
//        }
}


    @Test
    public void insert() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
       ProjectEntityMapper projectEntityMapper = sqlSession.getMapper(ProjectEntityMapper.class);
        //调用userMapper的方法
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setId(UUIDUtil.getOneUUID());
        projectEntity.setId("3");
        projectEntity.setCreatedBy("LS");

        HttpResponseEntity httpResponseEntity  = projectController.addProjectInfo(projectEntity);
//        if(i==0){
//            // 记录error级别的信息
//        }else{
        log.info(httpResponseEntity.getData().toString());
            // 记录info级别的信息
            log.info(">>insert项目新增插入测试成功");

    }

    @Test
    public void deleteProjectById() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        ProjectEntityMapper projectEntityMapper = sqlSession.getMapper(ProjectEntityMapper.class);
        //调用userMapper的方法
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setId("1c889c7c30e14200824c62c47842a8a0");

        HttpResponseEntity httpResponseEntity = projectController.deleteProjectById(projectEntity);
//        if(i==0){
//            // 记录error级别的信息
//        }else{
        log.info(httpResponseEntity.getData().toString());
            // 记录info级别的信息
          //  log.info(">>delete项目删除测试成功");
       // }
    }

}
