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
public class LimitsRole {
    /**
     * 表示角色id
     */
    private int role_id;
    /**
     * 表示权限id
     */
    private int limits_id;

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public int getLimits_id() {
        return limits_id;
    }

    public void setLimits_id(int limits_id) {
        this.limits_id = limits_id;
    }

    public LimitsRole(int role_id, int limits_id) {
        this.role_id = role_id;
        this.limits_id = limits_id;
    }

    public LimitsRole() {
    }

    @Override
    public String toString() {
        return "LimitsRole{" +
                "role_id=" + role_id +
                ", limits_id=" + limits_id +
                '}';
    }
}
