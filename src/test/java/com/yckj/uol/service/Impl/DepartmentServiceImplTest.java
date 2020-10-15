package com.yckj.uol.service.Impl;

import com.yckj.uol.pojo.Department;
import com.yckj.uol.service.IDepartmentService;
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
 * @created Administrator 2020/8/26
 */

public class DepartmentServiceImplTest {
    private Logger logger = Logger.getLogger(this.getClass());
    /**
     * 测试添加院系信息
     */
    @Test
    public void insert() {
        IDepartmentService departmentService = new DepartmentServiceImpl();
        Department department = new Department();
        department.setDep_id(55);
        department.setDep_name("应科学院");
        department.setDep_remarks("暂无");
        boolean flag = departmentService.insert(department);
        if (flag) {
            logger.debug("添加院系成功");
        } else {
            logger.debug("添加院系失败");
        }
    }

    @Test
    public void selectAll() {
        IDepartmentService departmentService = new DepartmentServiceImpl();
        List<Department> departments = departmentService.selectAll();
        for (Department department : departments) {
            logger.debug(department);
        }
    }
}
