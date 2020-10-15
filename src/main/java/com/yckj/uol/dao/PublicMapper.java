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
public interface PublicMapper {
    /**
     * 根据时间段查询公开课信息
     * @param begin_time
     * @param end_time
     * @return
     */
    List<Publik> selectByPublic_time(@Param("begin_time") String begin_time, @Param("end_time") String end_time);
    /**
     * 添加公开课信息
     * @param
     * @return
     */
    int insert(Publik publik);
    /**
     * 统计查询后的总记录数
     * @return
     */
    int selectTotalByCondition(@Param("item") PqueryItem item);
    /**
     * 动态分页查询
     * @param pageBean 分页
     * @param item 查询封装
     * @return
     */
    List<Publik> selectCombination(@Param("pageBean") PageBean<Publik> pageBean, @Param("item") PqueryItem item);
}
