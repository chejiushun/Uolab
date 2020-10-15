package com.yckj.uol.dao;

import com.yckj.uol.pojo.Clazz;
import com.yckj.uol.pojo.Major;
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

public class MajorMapperTest {
    private Logger logger = Logger.getLogger(this.getClass());

    /**
     * 测试添加专业
     */
    @Test
    public void insert() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        MajorMapper mapper = sqlSession.getMapper(MajorMapper.class);
        Major major = new Major();
       // major.setDep_name("外国语学院");
        major.setMajor_name("网络工程");
        major.setMajor_remarks("转专业");
        int res = mapper.insert(major);
        logger.debug(res);
        if (res > 0){
            sqlSession.commit();
            logger.debug("添加专业信息成功");
        }else{
            sqlSession.rollback();
            logger.debug("添加专业信息失败");
        }
        sqlSession.close();
    }
    @Test
    public void selectByDep_id() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        MajorMapper mapper = sqlSession.getMapper(MajorMapper.class);
        List<Major> majors = mapper.selectByDep_id(11);
        logger.debug(majors);
        MyBatisUtil.close(sqlSession);
    }
}
