package com.yckj.uol.dao;

import com.yckj.uol.pojo.Department;
import com.yckj.uol.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;


/**
 * Description:描述
 * Copyright:Copyright(c) 2020
 * Company 英才汇硕有限公司
 *
 * @author cjs <br>
 * @version 1.0 <br>
 * @created Administrator 2020/8/25
 */

public class DepartmentMapperTest {
    private Logger logger = Logger.getLogger(this.getClass());

    /**
     * 测试添加院系信息
     */
    @Test
    public void insert() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        Department department = new Department();
        department.setDep_id(36);
        department.setDep_name("化工学院");
        department.setDep_remarks("暂无");
        int res = mapper.insert(department);
        logger.debug(res);
        if (res > 0){
            sqlSession.commit();
            logger.debug("添加院系信息成功");
        }else{
            sqlSession.rollback();
            logger.debug("添加院系信息失败");
        }
        sqlSession.close();
    }
}
