package com.yckj.uol.service.Impl;

import com.yckj.uol.dao.PublicMapper;
import com.yckj.uol.pojo.Match;
import com.yckj.uol.pojo.PageBean;
import com.yckj.uol.pojo.PqueryItem;
import com.yckj.uol.pojo.Publik;
import com.yckj.uol.service.IPublicService;
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
public class PublicServiceImpl implements IPublicService {
    private Logger logger = Logger.getLogger(this.getClass());
    /**
     * 实现根据时间段查询公开课信息
     * @param begin_time
     * @param end_time
     * @return
     */
    @Override
    public List<Publik> selectByPublic_time(String begin_time, String end_time) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        PublicMapper mapper = sqlSession.getMapper(PublicMapper.class);
        logger.debug("进入"+this.getClass().getName()+"根据时间段查询公开课信息方法");
        List<Publik> list = mapper.selectByPublic_time(begin_time, end_time);
        logger.debug("离开"+this.getClass().getName()+"根据时间段查询公开课信息方法");
        return list;
    }

    /**
     * 实现添加公开课信息
     * @param
     * @return
     */
    @Override
    public boolean insert(Publik publik) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        PublicMapper mapper = sqlSession.getMapper(PublicMapper.class);
        logger.debug("进入"+this.getClass().getName()+"录入公开课信息方法");
        boolean flag = false;
        int res = mapper.insert(publik);
        if (res > 0){
            flag = true;
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        logger.debug("离开"+this.getClass().getName()+"录入公开课信息方法");
        sqlSession.close();
        return flag;
    }

    @Override
    public List<Publik> selectCombination(PageBean pageBean, PqueryItem item) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        PublicMapper mapper = sqlSession.getMapper(PublicMapper.class);
        List<Publik> list = mapper.selectCombination(pageBean,item);
        sqlSession.close();
        return list;
    }

    @Override
    public int selectTotalByCondition(PqueryItem item) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        PublicMapper mapper = sqlSession.getMapper(PublicMapper.class);
        int i = mapper.selectTotalByCondition(item);
        sqlSession.close();
        return i;
    }
}
