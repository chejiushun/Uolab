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
public class MemberMatch {
    /**
     * 表示成员编号
     */
    private int mem_id;
    /**
     * 表示竞赛编号
     */
    private int match_id;

    public int getMem_id() {
        return mem_id;
    }

    public void setMem_id(int mem_id) {
        this.mem_id = mem_id;
    }

    public int getMatch_id() {
        return match_id;
    }

    public void setMatch_id(int match_id) {
        this.match_id = match_id;
    }

    public MemberMatch(int mem_id, int match_id) {
        this.mem_id = mem_id;
        this.match_id = match_id;
    }

    public MemberMatch() {
    }

    @Override
    public String toString() {
        return "MemberMatch{" +
                "mem_id=" + mem_id +
                ", match_id=" + match_id +
                '}';
    }
}
