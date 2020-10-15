package com.yckj.uol.dao;

import com.yckj.uol.pojo.Page;
import com.yckj.uol.pojo.PageBean;
import com.yckj.uol.pojo.QueryItem;
import com.yckj.uol.pojo.User;
import com.yckj.uol.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import java.util.List;


/**
 * Description:描述
 * Copyright:Copyright(c) 2020
 * Company 英才汇硕有限公司
 *
 * @author cjs <br>
 * @version 1.0 <br>
 * @created Administrator 2020/8/24
 */
public class UserMapperTest {
    private Logger logger = Logger.getLogger(this.getClass());
    @Test
    public void selectTotalByCondition(){
    }
    @Test
    public void selectCombination() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        PageBean<User> pageBean =new PageBean();
        QueryItem item = new QueryItem();
        pageBean.setOrder("user_id");
        pageBean.setSort("desc");
        pageBean.setPageCode(1);
        pageBean.setPageSize(5);
      /*  pageBean.setTotal(3);*/
        item.setUser_name("zhangsan1");
        List<User> users = mapper.selectCombination(pageBean, item);
        logger.debug(users);
        sqlSession.close();
    }
    @Test
    public void insert() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUser_name("wangwu");
        user.setUser_pwd("12345678");
        user.setRole_id(3);
        user.setUser_realname("王五");
        user.setUser_sex("男");
        user.setUser_tel("15123523256");
        user.setUser_dep("机械学院");
        user.setUser_grade("2018级");
        user.setUser_major("机自");
        user.setUser_class("机自172001班");
        user.setUser_duty("团支书");
        user.setUser_qq("853252332");
        user.setUser_remarks("无");
        int res = mapper.insert(user);
        if (res > 0) {
            sqlSession.commit();
            logger.debug("添加用户信息成功");
        } else {
            sqlSession.rollback();
            logger.debug("添加用户信息失败");
        }
        sqlSession.close();
    }
    @Test
    public void update() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUser_id(10);
        user.setUser_tel("15113695321");
        user.setUser_qq("656212153");
        user.setUser_duty("班长");
        user.setUser_remarks("没有");
        int res = mapper.update(user);
        logger.debug(res);
        if (res > 0) {
            sqlSession.commit();
            logger.debug("修改用户信息成功");
        } else {
            sqlSession.rollback();
            logger.debug("修改用户信息失败");
        }
        sqlSession.close();
    }
    @Test
    public void deleteByUser_id() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.deleteByUser_id(7);
        logger.debug(res);
        if (res > 0) {
            sqlSession.commit();
            logger.debug("删除用户信息成功");
        } else {
            sqlSession.rollback();
            logger.debug("删除用户信息失败");
        }
        sqlSession.close();
    }
    @Test
    public void deleteBatch() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int [] array= {15,16};
        int i = mapper.deleteBatch(array);
        if(i>0) {
            logger.debug("删除成功");
            sqlSession.commit();
        }else {
            logger.debug("删除失败");
            sqlSession.rollback();
        }
        sqlSession.close();
    }
    @Test
    public void selectByUser_nameAndUser_pwd() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectByUser_nameAndUser_pwd("lisi", "12345678");
        if(user != null){
            sqlSession.commit();
            logger.debug(user);
        } else {
            sqlSession.rollback();
            logger.debug("用户查询失败");
        }
        sqlSession.close();
    }
    @Test
    public void selectByUser_id() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.selectByUser_id(2);
        if(user != null){
            logger.debug(user);
        } else {
            logger.debug("没有该用户");
        }
        sqlSession.close();
    }
    @Test
    public void selectAll(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectAll();
        if (users != null) {
            for (User user : users) {
                logger.debug(user);
            }
        } else {
            logger.debug("查询失败");
        }
        sqlSession.close();
    }
    @Test
    public void pageSelect(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Page page = new Page();
        page.setOrder("user_name");
        page.setPageIndex(1);
        page.setSort("DESC");
        page.setPageSize(2);
        List<User> users = mapper.pageSelect(page);
        for (int i=0;i< users.size();i++){
            logger.debug(users.get(i));
        }
        sqlSession.close();
    }
}