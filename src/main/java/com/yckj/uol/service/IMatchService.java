package com.yckj.uol.service;

import com.yckj.uol.pojo.*;
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
 * @created Administrator 2020/8/27
 */
public interface IMatchService extends BaseService<Match>{
    /**
     * 录入参赛信息
     * @param match
     * @return
     */
    boolean insert(Match match);
    /**
     * 根据竞赛编号对部分参赛信息修改
     * @param match
     * @return
     */
    boolean updateByMatch_id(Match match);
    /**
     * 通过id查询比赛信息
     * @param match_id
     * @return
     */
    Match selectByMatch_id(int match_id);
    /**
     * 修改
     * @param
     * @return
     */
    boolean update(Match match);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    boolean deleteByMatch_id(int id);

    /**
     * 批量删除用户信息
     * @param ids
     * @return 返回影响的行数
     */
    boolean deleteBatch(int[] ids);

    /**
     * 动态分页查询
     * @param pageBean
     * @param item
     * @return
     */
    List<Match> selectCombination(@Param("pageBean") PageBean pageBean, @Param("item") GqueryItem item);
    int selectTotalByCondition(GqueryItem item);
}
