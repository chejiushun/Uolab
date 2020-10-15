package com.yckj.uol.service.Impl;

import com.yckj.uol.dao.DepartmentMapper;
import com.yckj.uol.pojo.Department;
import com.yckj.uol.service.IDepartmentService;
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
public class DepartmentServiceImpl implements IDepartmentService {
    private Logger logger = Logger.getLogger(this.getClass());
    /**
     * 实现添加院系信息
     * @param department
     * @return
     */
    @Override
    public boolean insert(Department department) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        logger.debug("进入"+this.getClass().getName()+"添加院系方法");
        boolean flag = false;
        int res = mapper.insert(department);
        if (res > 0){
            flag = true;
            sqlSession.commit();
        } else  {
            sqlSession.rollback();
        }
        logger.debug("离开"+this.getClass().getName()+"添加院系方法");
        sqlSession.close();
        return flag;
    }

    @Override
    public boolean update(Department department) {
        return false;
    }

    @Override
    public List<Department> selectAll() {
       SqlSession sqlSession = MyBatisUtil.getSqlSession();
       DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
       List<Department> departments = departmentMapper.selectAll();
       return departments;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

}
