package com.yckj.uol.pojo;

/**
 * Description:描述
 * Copyright:Copyright(c) 2020
 * Company 英才汇硕有限公司
 *
 * @author cjs <br>
 * @version 1.0 <br>
 * @created Administrator 2020/9/14
 */
public class QueryItem {
    private String user_name;
    private String user_dep;
    private String user_major;
    private String user_grade;
    private String user_class;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_dep() {
        return user_dep;
    }

    public void setUser_dep(String user_dep) {
        this.user_dep = user_dep;
    }

    public String getUser_major() {
        return user_major;
    }

    public void setUser_major(String user_major) {
        this.user_major = user_major;
    }

    public String getUser_grade() {
        return user_grade;
    }

    public void setUser_grade(String user_grade) {
        this.user_grade = user_grade;
    }

    public String getUser_class() {
        return user_class;
    }

    public void setUser_class(String user_class) {
        this.user_class = user_class;
    }

    @Override
    public String toString() {
        return "QueryItem{" +
                "user_name='" + user_name + '\'' +
                ", user_dep='" + user_dep + '\'' +
                ", user_major='" + user_major + '\'' +
                ", user_grade='" + user_grade + '\'' +
                ", user_class='" + user_class + '\'' +
                '}';
    }
}
