package com.yckj.uol.pojo;


import java.util.List;

/**
 * Description: 描述【】
 * Copyright: Copyright (c) 2020
 * Company: 英才汇硕信息技术有限公司
 *
 * @author lihongjie <br>
 * @version 1.0 <br>
 * @created 2020/8/26 14:31
 */
public class PageBean<T> {
    /**
     * 当前页码
     */
    private int pageCode;
    /**
     * 从第几条开始查询
     * 偏移量
     *
     */
    private int pageOffset;
    /**
     * 每页显示的条数
     */
    private int pageSize;
    /**
     * 总记录
     */
    private int total;
    /**
     * 总页数
     */
    private int totalPage;

    /**
     * 按照哪个字段排序的字段名称
     */
    private String order;
    /**
     * 排序 （升序或降序）
     */
    private String sort;
    /**
     * 分页显示当前页的用户记录信息
     */
    private List<T> beanList;
    public int getPageCode() {
        return pageCode;
    }
    public void setPageCode(int pageCode) {
        this.pageCode = pageCode;
    }
    public int getPageOffset() {
        // 计算偏移量
        pageOffset = (pageCode-1)*pageSize;
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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<T> beanList) {
        this.beanList = beanList;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "pageCode=" + pageCode +
                ", pageOffset=" + pageOffset +
                ", pageSize=" + pageSize +
                ", total=" + total +
                ", totalPage=" + totalPage +
                ", order='" + order + '\'' +
                ", sort='" + sort + '\'' +
                ", beanList=" + beanList +
                '}';
    }
}
