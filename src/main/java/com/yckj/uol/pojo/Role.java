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
public class Role {
    /**
     * 表示角色编号
     */
    private int role_id;
    /**
     * 表示角色名称
     */
    private String role_name;
    /**
     * 表示角色描述
     */
    private String role_describle;

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_describle() {
        return role_describle;
    }

    public void setRole_describle(String role_describle) {
        this.role_describle = role_describle;
    }

    public Role(int role_id, String role_name, String role_describle) {
        this.role_id = role_id;
        this.role_name = role_name;
        this.role_describle = role_describle;
    }

    public Role() {
    }

    @Override
    public String toString() {
        return "Role{" +
                "role_id=" + role_id +
                ", role_name='" + role_name + '\'' +
                ", role_describle='" + role_describle + '\'' +
                '}';
    }
}
