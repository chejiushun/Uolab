package com.yckj.uol.service.Impl;

import com.yckj.uol.dao.MemberMapper;
import com.yckj.uol.dao.UserMapper;
import com.yckj.uol.pojo.PageBean;
import com.yckj.uol.pojo.QueryItem;
import com.yckj.uol.pojo.User;
import com.yckj.uol.service.IUserService;
import com.yckj.uol.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

/**
 * Description:描述
 * Copyright:Copyright(c) 2020
 * Company 英才汇硕有限公司
 *
 * @author cjs <br>
 * @version 1.0 <br>
 * @created Administrator 2020/8/25
 */
public class UserServiceImpl implements IUserService {
    private Logger logger = Logger.getLogger(this.getClass());

    /**
     * 实现用户登录
     * @param user 用户对象
     * @return
     */
    @Override
    public boolean login(User user) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        logger.debug("进入"+this.getClass().getName()+"用户登录方法");
        boolean flag = false;
        User user1 = userMapper.selectByUser_nameAndUser_pwd(user.getUser_name(), user.getUser_pwd());
        if(user1 != null){
            flag = true;
            sqlSession.commit();
        }
        logger.debug("离开"+this.getClass().getName()+"用户登录方法");
        sqlSession.close();
        return flag;
    }
    /**
     * 实现通过用户id查询用户信息
     * @param user_id
     * @return
     */
    @Override
    public User selectByUser_id(int user_id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        logger.debug("进入"+this.getClass().getName()+"根据id查询用户信息方法");
        User user = userMapper.selectByUser_id(user_id);
        if (user != null){
            logger.debug("查询成功");
            logger.debug(user);
        } else {
            logger.debug("查询失败");
        }
        logger.debug("离开"+this.getClass().getName()+"根据id查询用户信息方法");
        sqlSession.close();
        return user;
    }
    /**
     * 实现通过用户名和密码查询
     * @param user_name
     * @param user_pwd
     * @return
     */
    @Override
    public boolean selectByUser_nameAndUser_pwd(String user_name, String user_pwd) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        logger.debug("进入"+this.getClass().getName()+"通过用户名和密码查询方法");
        boolean flag = false;
        User user = userMapper.selectByUser_nameAndUser_pwd(user_name, user_pwd);
        if (user != null){
            flag = true;
            sqlSession.commit();
        } else{
            sqlSession.rollback();
        }
        logger.debug("离开"+this.getClass().getName()+"通过用户名和密码查询方法");
        sqlSession.close();
        return flag;
    }
    /**
     * 实现批量删除用户信息
     * @param  ids
     * @return 返回影响的行数
     */
    @Override
    public boolean deleteBatch(int[] ids) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        boolean flag = false;
        int i = userMapper.deleteBatch(ids);
        if(i>0) {
            sqlSession.commit();
            flag=true;
        }else {
            sqlSession.rollback();
        }
        return flag;
    }
    /**
     * 组合查询按：按姓名、院系、专业、班级、年级组合查询用户信息
     * @param pageBean
     * @param item
     * @return
     */
    @Override
    public List<User> selectCombination(PageBean<User> pageBean, QueryItem item) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = userMapper.selectCombination(pageBean,item);
        sqlSession.close();
        return list;
    }
    /**
     * 添加用户
     * @param user
     * @return
     */
    @Override
    public boolean insert(User user) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        logger.debug("进入"+this.getClass().getName()+"用户添加方法");
        boolean flag = false;
        int res = userMapper.insert(user);
        if (res > 0){
            flag = true;
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        logger.debug("离开"+this.getClass().getName()+"用户添加方法");
        sqlSession.close();
        return flag;
    }
    /**
     * 实现根据用户ID修改用户信息
     * @param user
     * @return
     */
    @Override
    public boolean update(User user) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        logger.debug("进入"+this.getClass().getName()+"修改用户方法");
        boolean flag = false;
        int res = userMapper.update(user);
        if (res > 0) {
            flag = true;
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        logger.debug("离开"+this.getClass().getName()+"修改用户方法");
        sqlSession.close();
        return flag;
    }
    /**
     * 查询所有用户
     * @return
     */
    @Override
    public List<User> selectAll() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        boolean flag = false;
        List<User> users = userMapper.selectAll();
        if(users != null){
            flag=true;
        }
        return users;
    }
    /**
     * 实现根据用户ID删除用户信息
     * @param user_id
     * @return
     */
    @Override
    public boolean deleteById(int user_id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        logger.debug("进入"+this.getClass().getName()+"根据用户ID删除用户方法");
        boolean flag = false;
        MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
        int res1 = mapper.deleteByUser_Id(user_id);
        SqlSession sqlSession2 = MyBatisUtil.getSqlSession();
        if (res1 > 0){
              sqlSession.commit();
              UserMapper userMapper = sqlSession2.getMapper(UserMapper.class);
              int res2 = userMapper.deleteByUser_id(user_id);
              if(res2 > 0){
                  sqlSession2.commit();
                  flag = true;
              }else{
                  sqlSession2.rollback();
              }
        } else {
           sqlSession.rollback();
        }
        logger.debug("离开"+this.getClass().getName()+"根据用户ID删除用户方法");
        MyBatisUtil.close(sqlSession2);
        MyBatisUtil.close(sqlSession);
        return flag;
    }
    @Override
    public List<User> pageUserList(PageBean<User> PageBean) throws SQLException {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
       return null;
    }
    @Override
    public int queryUserCount() {
        return 0;
    }
    @Override
    public List<User> queryUserListLimit(PageBean<User> pageBean) {
        return null;
    }
    /**
     * 统计查询后的总记录数
     * @param item
     * @return
     */
    @Override
    public int selectTotalByCondition(QueryItem item) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int i = userMapper.selectTotalByCondition(item);
        sqlSession.close();
        return i;

    }
    /**
     * 通过用户ID修改用户状态
     * @param user_id
     * @param user_state
     * @return
     */
    @Override
    public boolean updateStatusByUser_id(int user_id, int user_state) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        boolean flag = false;
        int id = userMapper.updateStatusByUser_id(user_id, user_state);
        if (id >0){
            flag = true;
            sqlSession.commit();
        } else{
            sqlSession.rollback();
        }
        sqlSession.close();
        return flag;
    }
}
