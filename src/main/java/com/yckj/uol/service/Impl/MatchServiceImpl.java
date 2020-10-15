package com.yckj.uol.service.Impl;

import com.yckj.uol.dao.MatchMapper;
import com.yckj.uol.pojo.GqueryItem;
import com.yckj.uol.pojo.Match;
import com.yckj.uol.pojo.PageBean;
import com.yckj.uol.service.IMatchService;
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
public class MatchServiceImpl implements IMatchService {
    private Logger logger = Logger.getLogger(this.getClass());
    /**
     * 实现录入参赛信息
     * @param match
     * @return
     */
    @Override
    public boolean insert(Match match) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        MatchMapper mapper = sqlSession.getMapper(MatchMapper.class);
        logger.debug("进入"+this.getClass().getName()+"参赛信息录入方法");
        boolean flag = false;
        int res = mapper.insert(match);
        if (res > 0) {
            flag = true;
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        logger.debug("离开"+this.getClass().getName()+"参赛信息录入方法");
        sqlSession.close();
        return flag;
    }

    /**
     * 实现根据竞赛编号对部分参赛信息修改
     * @param match
     * @return
     */
    @Override
    public boolean updateByMatch_id(Match match) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        MatchMapper mapper = sqlSession.getMapper(MatchMapper.class);
        logger.debug("进入"+this.getClass().getName()+"通过id修改参赛信息方法");
        boolean flag = false;
        int res = mapper.updateByMatch_id(match);
        if (res > 0){
            flag = true;
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        logger.debug("离开"+this.getClass().getName()+"通过id修改参赛信息方法");
        sqlSession.close();
        return flag;
    }

    @Override
    public Match selectByMatch_id(int match_id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        MatchMapper matchMapper = sqlSession.getMapper(MatchMapper.class);
        logger.debug("进入"+this.getClass().getName()+"根据id查询比赛信息方法");
        Match match = matchMapper.selectByMatch_id(match_id);
        if (match != null){
            logger.debug("查询成功");
            logger.debug(match);
        } else {
            logger.debug("查询失败");
        }
        logger.debug("离开"+this.getClass().getName()+"根据id查询比赛信息方法");
        sqlSession.close();
        return match;
    }

    @Override
    public boolean update(Match match) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        MatchMapper mapper = sqlSession.getMapper(MatchMapper.class);
        logger.debug("进入"+this.getClass().getName()+"修改方法");
        boolean flag = false;
        int res = mapper.update(match);
        if (res > 0) {
            flag = true;
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        logger.debug("离开"+this.getClass().getName()+"修改方法");
        sqlSession.close();
        return flag;
    }

    @Override
    public List<Match> selectAll() {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public boolean deleteByMatch_id(int match_id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        MatchMapper mapper = sqlSession.getMapper(MatchMapper.class);
        boolean flag = false;
        int res = mapper.deleteByMatch_id(match_id);
        if (res > 0){
            flag = true;
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        return flag;
    }

    @Override
    public boolean deleteBatch(int[] ids) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        MatchMapper mapper = sqlSession.getMapper(MatchMapper.class);
        boolean flag = false;
        int i = mapper.deleteBatch(ids);
        if(i>0) {
            sqlSession.commit();
            flag=true;
        }else {
            sqlSession.rollback();
        }
        return flag;
    }


    @Override
    public List<Match> selectCombination(PageBean pageBean, GqueryItem item) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
       MatchMapper mapper = sqlSession.getMapper(MatchMapper.class);
        List<Match> list = mapper.selectCombination(pageBean,item);
        sqlSession.close();
        return list;
    }

    @Override
    public int selectTotalByCondition(GqueryItem item) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        MatchMapper mapper = sqlSession.getMapper(MatchMapper.class);
        int i = mapper.selectTotalByCondition(item);
        sqlSession.close();
        return i;
    }
}
