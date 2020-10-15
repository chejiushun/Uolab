package com.yckj.uol.service;

import com.yckj.uol.pojo.PageBean;
import com.yckj.uol.pojo.QueryItem;
import com.yckj.uol.pojo.User;
import org.apache.ibatis.annotations.Param;

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
public interface IUserService extends BaseService<User> {

    /**
     * 用户登录
     * @param user 用户对象
     * @return 值为true表示登录成功，否则表示登录失败
     */
    boolean login(User user);
    /**
     * 通过id查询用户信息
     * @param user_id
     * @return
     */
    User selectByUser_id(int user_id);
    /**
     * 通过用户名和密码查询用户是否存在
     * @param user_name
     * @param user_pwd
     * @return
     */
    boolean selectByUser_nameAndUser_pwd(String user_name, String user_pwd);
    /**
     * 批量删除用户信息
     * @param ids
     * @return 返回影响的行数
     */
    boolean deleteBatch(int[] ids);
    /**
     * 动态分页查询按：按姓名、院系、专业、班级、年级组合查询用户信息
     * @param pageBean
     * @param item
     * @return
     */
    List<User> selectCombination(@Param("pageBean") PageBean<User> pageBean,@Param("item") QueryItem item);
    /**
     * 分页查询
     * @param PageBean
     * @return
     * @throws SQLException
     */
    List<User> pageUserList(PageBean<User> PageBean) throws SQLException;
    int queryUserCount();
    List<User> queryUserListLimit(PageBean<User> pageBean);
    int selectTotalByCondition(QueryItem item);
    boolean updateStatusByUser_id(@Param("user_id") int user_id,@Param("user_state") int user_state);

}
