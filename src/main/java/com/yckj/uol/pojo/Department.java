package com.yckj.uol.pojo;

/**
 * Description:描述
 * Copyright:Copyright(c) 2020
 * Company 英才汇硕有限公司
 *
 * @author cjs <br>
 * @version 1.0 <br>
 * @created Administrator 2020/8/23
 */
public class Department {
    /**
     * 表示院系编号
     */
    private int dep_id;
    /**
     * 表示院系名称
     */
    private String dep_name;
    /**
     * 表示院系备注
     */
    private String dep_remarks;

    public int getDep_id() {
        return dep_id;
    }

    public void setDep_id(int dep_id) {
        this.dep_id = dep_id;
    }

    public String getDep_name() {
        return dep_name;
    }

    public void setDep_name(String dep_name) {
        this.dep_name = dep_name;
    }

    public String getDep_remarks() {
        return dep_remarks;
    }

    public void setDep_remarks(String dep_remarks) {
        this.dep_remarks = dep_remarks;
    }

    public Department(int dep_id, String dep_name, String dep_remarks) {
        this.dep_id = dep_id;
        this.dep_name = dep_name;
        this.dep_remarks = dep_remarks;
    }

    public Department() {
    }

    @Override
    public String toString() {
        return "Department{" +
                "dep_id=" + dep_id +
                ", dep_name='" + dep_name + '\'' +
                ", dep_remarks='" + dep_remarks + '\'' +
                '}';
    }
}
