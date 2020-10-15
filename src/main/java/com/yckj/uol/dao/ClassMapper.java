package com.yckj.uol.dao;

import com.yckj.uol.pojo.Clazz;
import com.yckj.uol.pojo.Major;

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
public interface ClassMapper {

    /**
     * 添加班级信息
     * @param clazz
     * @return
     */
    int insert(Clazz clazz);

    /**
     * 通过专业名查询班级信息
     * @param major_name
     * @return
     */
    List<Clazz> selectByMajor_name(String major_name);
}
