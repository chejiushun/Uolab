package com.yckj.uol.dao;


import com.yckj.uol.pojo.Clazz;
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
 * @created Administrator 2020/8/23
 */

public class ClassMapperTest {
    private Logger logger = Logger.getLogger(this.getClass());

    /**
     * 测试添加班级信息
     */
    @Test
    public void insert() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        Clazz clazz = new Clazz();
        clazz.setClass_name("Java1017");
        clazz.setClass_people(35);
        clazz.setMajor_id(8);
        int res = mapper.insert(clazz);
        logger.debug(res);
        if (res > 0){
            sqlSession.commit();
            logger.debug("添加班级信息成功");
        }else{
            sqlSession.rollback();
            logger.debug("添加班级信息失败");
        }
        sqlSession.close();
    }

}
