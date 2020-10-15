package com.yckj.uol.service.Impl;

import com.yckj.uol.dao.ClassMapper;
import com.yckj.uol.pojo.Clazz;

import com.yckj.uol.service.IClazzService;
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
 * @created Administrator 2020/9/17
 */
public class ClazzServiceImpl implements IClazzService {
    private Logger logger = Logger.getLogger(this.getClass());
    @Override
    public boolean insert(Clazz clazz) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        logger.debug("进入"+this.getClass().getName()+"添加班级方法");
        boolean flag = false;
        int res = mapper.insert(clazz);
        if(res > 0){
            flag = true;
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        logger.debug("离开"+this.getClass().getName()+"添加班级方法");
        sqlSession.close();
        return flag;
    }

    @Override
    public List<Clazz> selectByMajor_name(String major_name) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        List<Clazz> list = mapper.selectByMajor_name(major_name);
        return list;
    }
}
