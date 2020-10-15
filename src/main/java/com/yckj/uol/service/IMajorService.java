package com.yckj.uol.service;

import com.yckj.uol.pojo.Major;

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
public interface IMajorService {
    /**
     * 添加专业信息
     * @param major
     * @return
     */
    boolean insert(Major major);

    List<Major> selectByDep_name(String dep_name);
    List<Major> selectByDep_id(int id);
}
