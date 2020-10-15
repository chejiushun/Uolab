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
public class User {
    /**
     * 表示用户ID
     */
    private int user_id;
    /**
     * 表示角色编号
     */
    private int role_id;
    /**
     * 表示成员编号
     */
    private int mem_id;
    /**
     * 表示用户名
     */
    private String user_name;
    /**
     * 表示用户密码
     */
    private String user_pwd;
    /**
     * 表示用户状态
     */
    private int user_state;
    /**
     * 表示用户真实姓名
     */
    private String user_realname;
    /**
     * 表示成员性别
     */
    private String user_sex;
    /**
     * 表示电话号码
     */
    private String user_tel;
    /**
     * 表示院系名称
     */
    private String user_dep;
    /**
     * 表示年级
     */
    private String user_grade;
    /**
     * 表示专业名称
     */
    private String user_major;
    /**
     * 表示班级名称
     */
    private String user_class;
    /**
     * 表示校内职务
     */
    private String user_duty;
    /**
     * 表示qq
     */
    private String user_qq;
    /**
     * 表示备注
     */
    private String user_remarks;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public int getMem_id() {
        return mem_id;
    }

    public void setMem_id(int mem_id) {
        this.mem_id = mem_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public int getUser_state() {
        return user_state;
    }

    public void setUser_state(int user_state) {
        this.user_state = user_state;
    }

    public String getUser_realname() {
        return user_realname;
    }

    public void setUser_realname(String user_realname) {
        this.user_realname = user_realname;
    }

    public String getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }

    public String getUser_tel() {
        return user_tel;
    }

    public void setUser_tel(String user_tel) {
        this.user_tel = user_tel;
    }

    public String getUser_dep() {
        return user_dep;
    }

    public void setUser_dep(String user_dep) {
        this.user_dep = user_dep;
    }

    public String getUser_grade() {
        return user_grade;
    }

    public void setUser_grade(String user_grade) {
        this.user_grade = user_grade;
    }

    public String getUser_major() {
        return user_major;
    }

    public void setUser_major(String user_major) {
        this.user_major = user_major;
    }

    public String getUser_class() {
        return user_class;
    }

    public void setUser_class(String user_class) {
        this.user_class = user_class;
    }

    public String getUser_duty() {
        return user_duty;
    }

    public void setUser_duty(String user_duty) {
        this.user_duty = user_duty;
    }

    public String getUser_qq() {
        return user_qq;
    }

    public void setUser_qq(String user_qq) {
        this.user_qq = user_qq;
    }

    public String getUser_remarks() {
        return user_remarks;
    }

    public void setUser_remarks(String user_remarks) {
        this.user_remarks = user_remarks;
    }

    public User(int user_id, int role_id, int mem_id, String user_name, String user_pwd,int user_state, String user_realname, String user_sex, String user_tel, String user_dep, String user_grade, String user_major, String user_class, String user_duty, String user_qq, String user_remarks) {
        this.user_id = user_id;
        this.role_id = role_id;
        this.mem_id = mem_id;
        this.user_name = user_name;
        this.user_pwd = user_pwd;
        this.user_state = user_state;
        this.user_realname = user_realname;
        this.user_sex = user_sex;
        this.user_tel = user_tel;
        this.user_dep = user_dep;
        this.user_grade = user_grade;
        this.user_major = user_major;
        this.user_class = user_class;
        this.user_duty = user_duty;
        this.user_qq = user_qq;
        this.user_remarks = user_remarks;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", role_id=" + role_id +
                ", mem_id=" + mem_id +
                ", user_name='" + user_name + '\'' +
                ", user_pwd='" + user_pwd + '\'' +
                ", user_state=" + user_state +
                ", user_realname='" + user_realname + '\'' +
                ", user_sex='" + user_sex + '\'' +
                ", user_tel='" + user_tel + '\'' +
                ", user_dep='" + user_dep + '\'' +
                ", user_grade='" + user_grade + '\'' +
                ", user_major='" + user_major + '\'' +
                ", user_class='" + user_class + '\'' +
                ", user_duty='" + user_duty + '\'' +
                ", user_qq='" + user_qq + '\'' +
                ", user_remarks='" + user_remarks + '\'' +
                '}';
    }
}
