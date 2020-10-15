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
public class Limits {
    /**
     * 表示权限编号
     */
    private  int limits_id;
    /**
     * 表示权限名称
     */
    private  String limits_name;
    /**
     * 表示上级权限
     */
    private  String limits_up;
    /**
     * 表示权限描述
     */
    private  String limits_describle;
    /**
     * 表示权限URL
     */
    private  String limits_URL;

    public int getLimits_id() {
        return limits_id;
    }

    public void setLimits_id(int limits_id) {
        this.limits_id = limits_id;
    }

    public String getLimits_name() {
        return limits_name;
    }

    public void setLimits_name(String limits_name) {
        this.limits_name = limits_name;
    }

    public String getLimits_up() {
        return limits_up;
    }

    public void setLimits_up(String limits_up) {
        this.limits_up = limits_up;
    }

    public String getLimits_describle() {
        return limits_describle;
    }

    public void setLimits_describle(String limits_describle) {
        this.limits_describle = limits_describle;
    }

    public String getLimits_URL() {
        return limits_URL;
    }

    public void setLimits_URL(String limits_URL) {
        this.limits_URL = limits_URL;
    }

    public Limits(int limits_id, String limits_name, String limits_up, String limits_describle, String limits_URL) {
        this.limits_id = limits_id;
        this.limits_name = limits_name;
        this.limits_up = limits_up;
        this.limits_describle = limits_describle;
        this.limits_URL = limits_URL;
    }

    public Limits() {
    }

    @Override
    public String toString() {
        return "Limits{" +
                "limits_id=" + limits_id +
                ", limits_name='" + limits_name + '\'' +
                ", limits_up='" + limits_up + '\'' +
                ", limits_describle='" + limits_describle + '\'' +
                ", limits_URL='" + limits_URL + '\'' +
                '}';
    }
}
