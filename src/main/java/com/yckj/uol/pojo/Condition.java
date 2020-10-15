package com.yckj.uol.pojo;

/**
 * Description:描述
 * Copyright:Copyright(c) 2020
 * Company 英才汇硕有限公司
 *
 * @author cjs <br>
 * @version 1.0 <br>
 * @created Administrator 2020/10/3
 */
public class Condition {
    private String mem_dep;
    private String mem_major;
    private String mem_grade;
    private int mem_state;

    public String getMem_dep() {
        return mem_dep;
    }

    public void setMem_dep(String mem_dep) {
        this.mem_dep = mem_dep;
    }

    public String getMem_major() {
        return mem_major;
    }

    public void setMem_major(String mem_major) {
        this.mem_major = mem_major;
    }

    public String getMem_grade() {
        return mem_grade;
    }

    public void setMem_grade(String mem_grade) {
        this.mem_grade = mem_grade;
    }

    public int getMem_state() {
        return mem_state;
    }

    public void setMem_state(int mem_state) {
        this.mem_state = mem_state;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "mem_dep='" + mem_dep + '\'' +
                ", mem_major='" + mem_major + '\'' +
                ", mem_grade='" + mem_grade + '\'' +
                ", mem_state=" + mem_state +
                '}';
    }
}
