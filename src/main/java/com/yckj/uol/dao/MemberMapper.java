package com.yckj.uol.dao;

import com.yckj.uol.pojo.*;

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
public interface MemberMapper {
    /**
     * 动态分页查询
     * @param pageBean 分页
     * @param item 查询封装
     * @return
     */
    List<Member> selectCombination(@Param("pageBean") PageBean<Member> pageBean, @Param("item") MqueryItem item);

    /**
     * 添加实验室成员信息
     * @param member
     * @return
     */
    int insert(Member member);

    /**
     * 根据ID查询信息
     * @param mem_id
     * @return
     */
    Member selectByMem_id(int mem_id);

    /**
     * 修改信息
     * @param member
     * @return
     */
    int update(Member member);

    /**
     * 根据实验室成员编号删除实验室成员信息
     * @param mem_id
     * @return
     */
    int deleteByMem_id(int mem_id);
    /**
     * 批量删除
     * @param ids ID数组
     * @return 返回影响的行数
     */
    int deleteBatch(int[] ids);

    /**
     * 统计查询后的总记录数
     * @return
     */
    int selectTotalByCondition(@Param("item") MqueryItem item);

    /**
     * 根据院系分组统计每个院系的人数，列出院系名称和成员人数
     * @return
     */
    List<EchartsBean> countMemberByDept();

    /**
     * 根据院系分组统计后,查处对应的院系名称
     * @return
     */
    List<String> selectDeptName();

    List<EchartsBean> countMemberByDeptname(Condition condition);
    List<String> selectDeptName1(Condition condition);
    int deleteByUser_Id(int user_id);
}
