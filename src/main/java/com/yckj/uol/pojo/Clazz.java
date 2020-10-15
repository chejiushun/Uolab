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
public class Clazz {
    /**
     * 表示班号
     */
    private int class_id;
    /**
     * 表示专业名称
     */
    private int major_id;
    /**
     * 表示班级名称
     */
    private String class_name;
    /**
     * 表示班级人数
     */
    private int class_people;

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public int getMajor_id() {
        return major_id;
    }

    public void setMajor_id(int major_id) {
        this.major_id = major_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public int getClass_people() {
        return class_people;
    }

    public void setClass_people(int class_people) {
        this.class_people = class_people;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "class_id=" + class_id +
                ", major_id=" + major_id +
                ", class_name='" + class_name + '\'' +
                ", class_people=" + class_people +
                '}';
    }
}
