package com.yckj.uol.service;

import com.yckj.uol.pojo.Clazz;


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
public interface IClazzService {

    /**
     * 添加班级信息
     * @param clazz
     * @return
     */
    boolean insert(Clazz clazz);

    List<Clazz> selectByMajor_name(String major_name);
}
