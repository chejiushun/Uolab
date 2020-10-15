package com.yckj.uol.dao;


import com.yckj.uol.pojo.Major;

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
public interface MajorMapper {
    /**
     * 添加专业
     * @param major
     * @return
     */
    int insert(Major major);
    /**
     * 通过院系名查询专业信息
     * @param dep_name
     * @return
     */
    List<Major> selectByDep_name(String dep_name);
    List<Major> selectByDep_id(int id);
}
