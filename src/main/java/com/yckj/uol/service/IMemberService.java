package com.yckj.uol.service;

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
 * @created Administrator 2020/8/26
 */
public interface IMemberService extends BaseService<Member> {


    /**
     * 批量删除信息
     * @param ids
     * @return 返回影响的行数
     */
    boolean deleteBatch(int[] ids);
    /**
     * 通过id查询信息
     * @param mem_id
     * @return
     */
    Member selectByMem_id(int mem_id);

    /**
     * 动态分页查询
     * @param pageBean
     * @param item
     * @return
     */
    List<Member> selectCombination(@Param("pageBean") PageBean pageBean, @Param("item") MqueryItem item);

    int selectTotalByCondition(MqueryItem item);

    /**
     * 根据院系分组统计每个院系的人数，列出院系名称和成员人数
     */
    List<EchartsBean> staticMemberByDept();
    /**
     * 根据院系分组统计后，查询出对应的院系名称
     */
    List<String> queryDeptName();
}
