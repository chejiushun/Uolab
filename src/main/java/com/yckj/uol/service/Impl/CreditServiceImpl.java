package com.yckj.uol.service.Impl;

import com.yckj.uol.dao.CreditMapper;
import com.yckj.uol.pojo.Credit;
import com.yckj.uol.service.ICreditService;
import com.yckj.uol.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

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
public class CreditServiceImpl implements ICreditService {
    private Logger logger = Logger.getLogger(this.getClass());

    /**
     * 实现录入学分信息
     * @param credit
     * @return
     */
    @Override
    public boolean insert(Credit credit) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        CreditMapper mapper = sqlSession.getMapper(CreditMapper.class);
        logger.debug("进入"+this.getClass().getName()+"录入学分信息方法");
        boolean flag = false;
        int res = mapper.insert(credit);
        if (res > 0){
            flag = true;
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        logger.debug("离开"+this.getClass().getName()+"录入学分信息方法");
        sqlSession.close();
        return flag;
    }

    /**
     * 实现组合查询单个学生的创新学分记录：输入学号、姓名、时间段（年月），查询学生所有创新
     * 学分记录，并显示总分数
     * @param credit_sno
     * @param credit_name
     * @param begin_time
     * @param end_time
     * @return
     */
    @Override
    public List<Credit> selectCombination(int credit_sno, String credit_name, String begin_time, String end_time) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        CreditMapper mapper = sqlSession.getMapper(CreditMapper.class);
        logger.debug("进入"+this.getClass().getName()+"通过学号、姓名、时间段（年月）查询方法");
        List<Credit> list = mapper.selectCombination(credit_sno, credit_name, begin_time, end_time);
        logger.debug("离开"+this.getClass().getName()+"通过学号、姓名、时间段（年月）查询方法");
        return list;
    }
}
