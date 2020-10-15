package com.yckj.uol.dao;


import com.yckj.uol.pojo.Page;
import com.yckj.uol.pojo.PageBean;
import com.yckj.uol.pojo.QueryItem;
import com.yckj.uol.pojo.User;
import org.apache.ibatis.annotations.Param;
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
public interface UserMapper {
    /**
     * 添加用户信息
     * @param user 用户对象
     * @return
     */
    int insert(User user);
    /**
     * 修改用户信息
     * @param user 用户对象
     * @return
     */
    int update(User user);
    /**
     * 通过用户名和密码查询
     * @param user_name
     * @param user_pwd
     * @return
     */
    User selectByUser_nameAndUser_pwd(@Param("user_name")String user_name,@Param("user_pwd")String user_pwd);
    /**
     * 查询所有用户信息
     * @return
     */
    List<User> selectAll();
    /**
     * 根据用户ID删除用户信息
     * @param user_id
     * @return
     */
    int deleteByUser_id(int user_id);
    /**
     * 分页查询
     * @param page
     * @return
     */
    List<User> pageSelect(Page page);
    /**
     * 统计查询后的总记录数
     * @return
     */
    int selectTotalByCondition(@Param("item") QueryItem item);
    /**
     * 根据用户ID查询用户信息
     * @param user_id
     * @return
     */
    User selectByUser_id(int user_id);
    /**
     * 动态分页查询按：按姓名、院系、专业、班级、年级组合查询用户信息
     * @param pageBean 分页
     * @param item 查询封装
     * @return
     */
    List<User> selectCombination(@Param("pageBean") PageBean<User> pageBean,@Param("item") QueryItem item);
    /**
     * 批量删除
     * @param ids ID数组
     * @return 返回影响的行数
     */
    int deleteBatch(int[] ids);
    /**
     * 通过用户ID修改用户状态
     * @param user_id 用户ID
     * @param state 用户状态
     * @return
     */
    int updateStatusByUser_id(@Param("user_id") int user_id,@Param("user_state") int state);
}
