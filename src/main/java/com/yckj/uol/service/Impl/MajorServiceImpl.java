package com.yckj.uol.service.Impl;

import com.yckj.uol.dao.MajorMapper;
import com.yckj.uol.pojo.Major;
import com.yckj.uol.service.IMajorService;
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
 * @created Administrator 2020/8/26
 */
public class MajorServiceImpl implements IMajorService {
    private Logger logger = Logger.getLogger(this.getClass());
    /**
     * 实现添加专业信息
     * @param major
     * @return
     */
    @Override
    public boolean insert(Major major) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        MajorMapper mapper = sqlSession.getMapper(MajorMapper.class);
        logger.debug("进入"+this.getClass().getName()+"添加专业方法");
        boolean flag = false;
        int res = mapper.insert(major);
        if(res > 0){
            flag = true;
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        logger.debug("离开"+this.getClass().getName()+"添加专业方法");
        sqlSession.close();
        return flag;
    }

    @Override
    public List<Major> selectByDep_name(String dep_name) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        MajorMapper mapper = sqlSession.getMapper(MajorMapper.class);
        List<Major> list = mapper.selectByDep_name(dep_name);
        return list;
    }

    @Override
    public List<Major> selectByDep_id(int id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        MajorMapper mapper = sqlSession.getMapper(MajorMapper.class);
        List<Major> list = mapper.selectByDep_id(id);
        return list;
    }
}
