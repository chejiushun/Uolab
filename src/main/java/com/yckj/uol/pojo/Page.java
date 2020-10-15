package com.yckj.uol.pojo;

/**
 * Description:描述
 * Copyright:Copyright(c) 2020
 * Company 英才汇硕有限公司
 *
 * @author cjs <br>
 * @version 1.0 <br>
 * @created Administrator 2020/9/5
 */
public class Page {
    /**
     * 页码
     */
    private int pageIndex;
    /**
     * 从第几条开始查询
     * 偏移量
     */
    private int pageOffset;
    /**
     * 每页显示的条数
     */
    private int pageSize;
    /**
     * 按照哪个字段排序的字段名称
     */
    private String order;
    /**
     * 排序 （升序或降序）
     */
    private String sort;

    @Override
    public String toString() {
        return "Page{" +
                "pageIndex=" + pageIndex +
                ", pageOffset=" + pageOffset +
                ", pageSize=" + pageSize +
                ", order='" + order + '\'' +
                ", sort='" + sort + '\'' +
                '}';
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageOffset() {
        // 计算偏移量
        pageOffset = (pageIndex-1)*pageSize;
        return pageOffset;
    }

    public void setPageOffset(int pageOffset) {
        this.pageOffset = pageOffset;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
