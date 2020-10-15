package com.yckj.uol.dao;

import com.yckj.uol.pojo.Publik;
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
public class PublicMapperTest {
    private Logger logger = Logger.getLogger(this.getClass());

    /**
     * 测试根据时间段查询公开课信息
     */
    @Test
    public void selectByPublic_time() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        PublicMapper mapper = sqlSession.getMapper(PublicMapper.class);
        String begin_time = "20200101";
        String end_time = "20210901";
        List<Publik> list = mapper.selectByPublic_time(begin_time,end_time);
        for (Publik publik : list) {
            logger.debug(publik);
        }
        sqlSession.close();
    }

    /**
     * 测试添加公开课信息
     */
    @Test
    public void insert() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        PublicMapper mapper = sqlSession.getMapper(PublicMapper.class);
        Publik publik = new Publik();
        publik.setPublic_id(05);
        publik.setPublic_date("2018年9月1日");
        publik.setPublic_project("数学");
        publik.setPublic_speaker("王刚");
        publik.setPublic_organizer("赵燕");
        publik.setPublic_place("北京");
        publik.setPublic_group("暂无");
        publik.setPublic_classway("线下");
        publik.setPublic_remarks("暂无");
        int res = mapper.insert(publik);
        if (res > 0){
            sqlSession.commit();
            logger.debug("添加公开课信息成功");
        } else {
            sqlSession.rollback();
            logger.debug("添加公开课信息失败");
        }
        sqlSession.close();
    }
}
