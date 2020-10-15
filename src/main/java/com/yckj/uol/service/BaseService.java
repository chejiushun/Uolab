package com.yckj.uol.service;

import java.util.List;

/**
 * Description:描述
 * Copyright:Copyright(c) 2020
 * Company 英才汇硕有限公司
 *
 * @author cjs <br>
 * @version 1.0 <br>
 * @created Administrator 2020/9/5
 */
public interface BaseService<T> {
    /**
     * 插入添加
     * @param t
     * @return
     */
    boolean insert(T t);

    /**
     * 更新
     * @param t
     * @return
     */
    boolean update(T t);

    /**
     * 查询所有
     * @return
     */
    List<T> selectAll();

    /**
     * 根据id删除
     * @param id
     * @return
     */
    boolean deleteById(int id);
}
