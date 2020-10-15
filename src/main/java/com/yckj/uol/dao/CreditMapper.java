package com.yckj.uol.dao;

import com.yckj.uol.pojo.Credit;
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
public interface CreditMapper {
    /**
     * 录入学分信息
     * @param credit
     * @return
     */
    int insert(Credit credit);

    /**
     * 组合查询单个学生的创新学分记录：输入学号、姓名、时间段（年月），查询学生所有创新
     * 学分记录，并显示总分数
     * @param credit_sno
     * @param credit_name
     * @param begin_time
     * @param end_time
     * @return
     */
    List<Credit> selectCombination(@Param("credit_sno") int credit_sno, @Param("credit_name") String credit_name,@Param("begin_time") String begin_time,@Param("end_time") String end_time);
}
