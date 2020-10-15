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
public class Match {
    /**
     * 表示竞赛编号
     */
    private int match_id;
    /**
     * 表示竞赛类别
     */
    private String match_kind;
    /**
     * 表示竞赛年度
     */
    private String match_year;
    /**
     * 表示竞赛题目
     */
    private String match_title;
    /**
     * 表示竞赛组长
     */
    private String match_groupleader;
    /**
     * 表示竞赛组员
     */
    private String match_groupmember;
    /**
     * 表示年级
     */
    private String match_comgrade;
    /**
     * 表示竞赛指导老师
     */
    private String match_teacher;

    public int getMatch_id() {
        return match_id;
    }

    public void setMatch_id(int match_id) {
        this.match_id = match_id;
    }

    public String getMatch_kind() {
        return match_kind;
    }

    public void setMatch_kind(String match_kind) {
        this.match_kind = match_kind;
    }

    public String getMatch_year() {
        return match_year;
    }

    public void setMatch_year(String match_year) {
        this.match_year = match_year;
    }

    public String getMatch_title() {
        return match_title;
    }

    public void setMatch_title(String match_title) {
        this.match_title = match_title;
    }

    public String getMatch_groupleader() {
        return match_groupleader;
    }

    public void setMatch_groupleader(String match_groupleader) {
        this.match_groupleader = match_groupleader;
    }

    public String getMatch_groupmember() {
        return match_groupmember;
    }

    public void setMatch_groupmember(String match_groupmember) {
        this.match_groupmember = match_groupmember;
    }

    public String getMatch_comgrade() {
        return match_comgrade;
    }

    public void setMatch_comgrade(String match_comgrade) {
        this.match_comgrade = match_comgrade;
    }

    public String getMatch_teacher() {
        return match_teacher;
    }

    public void setMatch_teacher(String match_teacher) {
        this.match_teacher = match_teacher;
    }

    @Override
    public String toString() {
        return "Match{" +
                "match_id=" + match_id +
                ", match_kind='" + match_kind + '\'' +
                ", match_year='" + match_year + '\'' +
                ", match_title='" + match_title + '\'' +
                ", match_groupleader='" + match_groupleader + '\'' +
                ", match_groupmember='" + match_groupmember + '\'' +
                ", match_comgrade='" + match_comgrade + '\'' +
                ", match_teacher='" + match_teacher + '\'' +
                '}';
    }
}
