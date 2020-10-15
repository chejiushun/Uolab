package com.yckj.uol.dao;

import com.yckj.uol.pojo.Department;

import java.util.List;

/**
 * Description:描述
 * Copyright:Copyright(c) 2020
 * Company 英才汇硕有限公司
 *
 * @author cjs <br>
 * @version 1.0 <br>
 * @created Administrator 2020/8/24
 */
public interface DepartmentMapper {
    /**
     * 添加院系信息
     * @param department
     * @return
     */
    int insert(Department department);
    /**
     * 查询所有
     * @return
     */
    List<Department> selectAll();
}
