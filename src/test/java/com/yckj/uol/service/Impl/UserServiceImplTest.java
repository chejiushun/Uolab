package com.yckj.uol.service.Impl;


import com.yckj.uol.pojo.User;
import com.yckj.uol.service.IUserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;


/**
 * Description:描述
 * Copyright:Copy
 * imporright(c) 2020
 * Company 英才汇硕有限公司
 *
 * @author cjs <br>
 * @version 1.0 <br>
 * @created Administrator 2020/8/25
 */

public class UserServiceImplTest {
    private Logger logger = Logger.getLogger(this.getClass());


    @Test
    public void login(){
        IUserService userService = new UserServiceImpl();
        User user = new User();
        user.setUser_name("li");
        user.setUser_pwd("12345678");
        boolean flag = userService.login(user);
        if (flag) {
            logger.debug("用户登录成功");
        } else {
            logger.debug("用户登录失败");
        }
    }
    @Test
    public void selectByUser_id() {
        IUserService userService = new UserServiceImpl();
        User user = userService.selectByUser_id(2);
        logger.debug(user);
    }
    @Test
    public void selectByUser_nameAndUser_pwd() {
        IUserService userService = new UserServiceImpl();
        boolean flag = userService.selectByUser_nameAndUser_pwd("zhangsan", "123456");
        if(flag){
            logger.debug("用户查询成功");
        } else {
            logger.debug("用户查询失败");
        }
    }
    @Test
    public void deleteBatch() {
        IUserService userService = new UserServiceImpl();
        int[] arr = {2,3};
        boolean flag = userService.deleteBatch(arr);
        if (flag){
            logger.debug("批量删除成功");
        } else{
            logger.debug("批量删除失败");
        }
    }
    @Test
    public void selectCombination() {
        IUserService userService = new UserServiceImpl();
//        List<User> list = userService.selectCombination("", "", "", "", "");
//        logger.debug(list.size());
    }
    @Test
    public void insert() {
        IUserService userService = new UserServiceImpl();
        User user = new User();
        user.setUser_name("zhaoliu");
        user.setUser_pwd("12345678");
        user.setRole_id(2);
        user.setUser_realname("赵六");
        user.setUser_sex("男");
        user.setUser_tel("15123523256");
        user.setUser_dep("机械学院");
        user.setUser_grade("2018级");
        user.setUser_major("机自");
        user.setUser_class("机自172001班");
        user.setUser_duty("团支书");
        user.setUser_qq("853252332");
        user.setUser_remarks("无");
        boolean flag = userService.insert(user);
        if (flag) {
            logger.debug("用户添加成功");
        } else {
            logger.debug("用户添加失败");
        }
    }
    @Test
    public void update() {
        IUserService userService = new UserServiceImpl();
        User user = new User();
        user.setUser_id(1);
        user.setUser_tel("15941403965");
        boolean flag = userService.update(user);
        if (flag){
            logger.debug("修改用户信息成功");
        } else {
            logger.debug("修改用户信息失败");
        }
    }
    @Test
    public void selectAll() {
        IUserService userService = new UserServiceImpl();
        List<User> list = userService.selectAll();
        logger.debug(list.size());
    }
    @Test
    public void deleteByUser_id() {
        IUserService userService = new UserServiceImpl();
        boolean flag = userService.deleteById(7);
        if (flag){
            logger.debug("删除用户信息成功");
        } else {
            logger.debug("删除用户信息失败");
        }
    }
}
