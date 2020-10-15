package com.yckj.uol.dao;

import com.yckj.uol.pojo.Match;
import com.yckj.uol.pojo.Member;
import com.yckj.uol.pojo.User;
import com.yckj.uol.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.ArrayList;
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

public class MatchMapperTest {
    private Logger logger = Logger.getLogger(this.getClass());

    /**
     * 测试录入参赛信息
     */
    @Test
    public void insert() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        MatchMapper mapper = sqlSession.getMapper(MatchMapper.class);
        Match match = new Match();
        match.setMatch_id(40);
        match.setMatch_kind("文体活动");
      //  match.setMatch_year(2017);
        match.setMatch_title("马拉松比赛");
        match.setMatch_groupleader("李华");
        match.setMatch_groupmember("刘五");
        match.setMatch_comgrade("一等");
        match.setMatch_teacher("胡三");
        int res = mapper.insert(match);
        if (res > 0){
            sqlSession.commit();
            logger.debug("参赛信息录入成功");
        } else {
            sqlSession.rollback();
            logger.debug("参赛信息录入失败");
        }
        sqlSession.close();
    }

    /**
     * 测试根据竞赛编号对部分参赛信息修改
     */
    @Test
    public void updateByMatch_id(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        MatchMapper mapper = sqlSession.getMapper(MatchMapper.class);
        Match match = new Match();
        match.setMatch_groupmember("赵六");
        match.setMatch_comgrade("三等");
        match.setMatch_id(40);
        int res = mapper.updateByMatch_id(match);
        logger.debug(res);
        if (res > 0){
            sqlSession.commit();
            logger.debug("参赛信息录入修改成功");
        }else{
            sqlSession.rollback();
            logger.debug("参赛信息录入修改失败");
        }
        sqlSession.close();
    }

    @Test
    public void deleteBatch() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        MatchMapper mapper = sqlSession.getMapper(MatchMapper.class);
        int [] array= {2,3};
        int i = mapper.deleteBatch(array);
        if(i>0) {
            logger.debug("删除成功");
            sqlSession.commit();
        }else {
            logger.debug("删除失败");
            sqlSession.rollback();
        }
        sqlSession.close();
    }

}
