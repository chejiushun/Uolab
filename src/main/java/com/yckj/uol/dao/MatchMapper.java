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
public interface MatchMapper {
    /**
     * 修改信息
     * @param match
     * @return
     */
    int update(Match match);
    /**
     * 录入参赛信息
     * @param match
     * @return
     */
    int insert(Match match);
    /**
     * 根据ID删除信息
     * @param
     * @return
     */
    int deleteByMatch_id(int match_id);
    /**
     * 根据竞赛编号对部分参赛信息修改
     * @param match
     * @return
     */
    int updateByMatch_id(Match match);
    /**
     * 批量删除
     * @param ids ID数组
     * @return 返回影响的行数
     */
    int deleteBatch(int[] ids);
    /**
     * 根据竞赛ID查询信息
     * @param match_id
     * @return
     */
    Match selectByMatch_id(int match_id);
    /**
     * 统计查询后的总记录数
     * @return
     */
    int selectTotalByCondition(@Param("item") GqueryItem item);
    /**
     * 动态分页查询
     * @param pageBean 分页
     * @param item 查询封装
     * @return
     */
    List<User> selectCombination(@Param("pageBean") PageBean<User> pageBean,@Param("item") GqueryItem item);
}
