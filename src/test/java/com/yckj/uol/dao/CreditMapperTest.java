package com.yckj.uol.dao;

import com.yckj.uol.pojo.Credit;
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
 * @created Administrator 2020/8/25
 */

public class CreditMapperTest {
    private Logger logger = Logger.getLogger(this.getClass());

    /**
     * 测试录入学分信息
     */
    @Test
    public void insert() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        CreditMapper mapper = sqlSession.getMapper(CreditMapper.class);
        Credit credit = new Credit();
        credit.setCredit_name("王五");
        //credit.setCredit_sno(40);
        credit.setCredit_dep("材料学院");
        credit.setCredit_grade("2019级");
       // credit.setCredit_score(39);
        credit.setCredit_reason("选修课");
        credit.setCredit_gettime("20181001");
        credit.setCredit_recordtime("20200405");
        credit.setCredit_recorder("张晓飞");
        credit.setCredit_remarks("无");
        int res = mapper.insert(credit);
        if (res > 0){
            sqlSession.commit();
            logger.debug("录入学分信息成功");
        } else {
            sqlSession.rollback();
            logger.debug("录入学分信息失败");
        }
        sqlSession.close();
    }

    /**
     * 测试组合查询单个学生的创新学分记录：
     * 输入学号、姓名、时间段（年月），查询学生所有创新
     * 学分记录，并显示总分数
     */
    @Test
    public void selectCombination(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        CreditMapper mapper = sqlSession.getMapper(CreditMapper.class);
        String begin_time = "20170801";
        String end_time = "20200826";
        List<Credit> list = mapper.selectCombination(40, "王五", begin_time, end_time);
        for (Credit credit : list) {
            logger.debug(credit);
        }
        sqlSession.close();
    }
}
