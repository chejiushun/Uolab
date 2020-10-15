package com.yckj.uol.service;

import com.yckj.uol.pojo.Department;

/**
 * Description:描述
 * Copyright:Copyright(c) 2020
 * Company 英才汇硕有限公司
 *
 * @author cjs <br>
 * @version 1.0 <br>
 * @created Administrator 2020/8/26
 */
public interface IDepartmentService extends BaseService<Department>{
    /**
     * 添加院系信息
     * @param department
     * @return
     */
    boolean insert(Department department);
}
