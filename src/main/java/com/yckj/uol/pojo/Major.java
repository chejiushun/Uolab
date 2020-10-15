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
public class Major {
    /**
     * 表示专业编号
     */
    private int major_id;
    /**
     * 表示院系编号
     */
    private int dep_id;
    /**
     * 表示专业名称
     */
    private String major_name;
    /**
     * 表示专业备注
     */
    private String major_remarks;

    public int getMajor_id() {
        return major_id;
    }

    public void setMajor_id(int major_id) {
        this.major_id = major_id;
    }

    public int getDep_id() {
        return dep_id;
    }

    public void setDep_id(int dep_id) {
        this.dep_id = dep_id;
    }

    public String getMajor_name() {
        return major_name;
    }

    public void setMajor_name(String major_name) {
        this.major_name = major_name;
    }

    public String getMajor_remarks() {
        return major_remarks;
    }

    public void setMajor_remarks(String major_remarks) {
        this.major_remarks = major_remarks;
    }

    @Override
    public String toString() {
        return "Major{" +
                "major_id=" + major_id +
                ", dep_id=" + dep_id +
                ", major_name='" + major_name + '\'' +
                ", major_remarks='" + major_remarks + '\'' +
                '}';
    }
}
