package com.yckj.uol.pojo;

/**
 * Description:描述
 * Copyright:Copyright(c) 2020
 * Company 英才汇硕有限公司
 *
 * @author cjs <br>
 * @version 1.0 <br>
 * @created Administrator 2020/9/22
 */
public class MqueryItem {
    private String mem_name;
    private String mem_dep;
    private String mem_major;
    private String mem_grade;
    private String mem_class;
    private String mem_duty;
    private String mem_tel;
    private int mem_state;

    public String getMem_name() {
        return mem_name;
    }

    public void setMem_name(String mem_name) {
        this.mem_name = mem_name;
    }

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

    public String getMem_class() {
        return mem_class;
    }

    public void setMem_class(String mem_class) {
        this.mem_class = mem_class;
    }

    public String getMem_duty() {
        return mem_duty;
    }

    public void setMem_duty(String mem_duty) {
        this.mem_duty = mem_duty;
    }

    public String getMem_tel() {
        return mem_tel;
    }

    public void setMem_tel(String mem_tel) {
        this.mem_tel = mem_tel;
    }

    public int getMem_state() {
        return mem_state;
    }

    public void setMem_state(int mem_state) {
        this.mem_state = mem_state;
    }

    @Override
    public String toString() {
        return "MqueryItem{" +
                "mem_name='" + mem_name + '\'' +
                ", mem_dep='" + mem_dep + '\'' +
                ", mem_major='" + mem_major + '\'' +
                ", mem_grade='" + mem_grade + '\'' +
                ", mem_class='" + mem_class + '\'' +
                ", mem_duty='" + mem_duty + '\'' +
                ", mem_tel='" + mem_tel + '\'' +
                ", mem_state=" + mem_state +
                '}';
    }
}
