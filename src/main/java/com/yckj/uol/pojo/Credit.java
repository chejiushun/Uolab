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
public class Credit {
    /**
     * 表示学分编号
     */
    private int credit_id;
    /**
     * 表示成员编号
     */
    private int mem_id;
    /**
     * 表示学号
     */
    private String credit_sno;
    /**
     * 表示姓名
     */
    private String credit_name;
    /**
     * 专业
     */
    private String credit_major;
    /**
     * 表示年级
     */
    private String credit_grade;
    /**
     * 表示院系
     */
    private String credit_dep;
    /**
     * 表示学分分值
     */
    private String credit_score;
    /**
     * 表示事由
     */
    private String credit_reason;
    /**
     * 表示取得时间
     */
    private String credit_gettime;
    /**
     * 表示录入人
     */
    private String credit_recorder;
    /**
     * 表示录入时间
     */
    private String credit_recordtime;
    /**
     * 表示备注
     */
    private String credit_remarks;

    public int getCredit_id() {
        return credit_id;
    }

    public void setCredit_id(int credit_id) {
        this.credit_id = credit_id;
    }

    public int getMem_id() {
        return mem_id;
    }

    public void setMem_id(int mem_id) {
        this.mem_id = mem_id;
    }

    public String getCredit_sno() {
        return credit_sno;
    }

    public void setCredit_sno(String credit_sno) {
        this.credit_sno = credit_sno;
    }

    public String getCredit_name() {
        return credit_name;
    }

    public void setCredit_name(String credit_name) {
        this.credit_name = credit_name;
    }

    public String getCredit_grade() {
        return credit_grade;
    }

    public void setCredit_grade(String credit_grade) {
        this.credit_grade = credit_grade;
    }

    public String getCredit_dep() {
        return credit_dep;
    }

    public void setCredit_dep(String credit_dep) {
        this.credit_dep = credit_dep;
    }

    public String getCredit_major() {
        return credit_major;
    }

    public void setCredit_major(String credit_major) {
        this.credit_major = credit_major;
    }

    public String getCredit_score() {
        return credit_score;
    }

    public void setCredit_score(String credit_score) {
        this.credit_score = credit_score;
    }

    public String getCredit_reason() {
        return credit_reason;
    }

    public void setCredit_reason(String credit_reason) {
        this.credit_reason = credit_reason;
    }

    public String getCredit_gettime() {
        return credit_gettime;
    }

    public void setCredit_gettime(String credit_gettime) {
        this.credit_gettime = credit_gettime;
    }

    public String getCredit_recorder() {
        return credit_recorder;
    }

    public void setCredit_recorder(String credit_recorder) {
        this.credit_recorder = credit_recorder;
    }

    public String getCredit_recordtime() {
        return credit_recordtime;
    }

    public void setCredit_recordtime(String credit_recordtime) {
        this.credit_recordtime = credit_recordtime;
    }

    public String getCredit_remarks() {
        return credit_remarks;
    }

    public void setCredit_remarks(String credit_remarks) {
        this.credit_remarks = credit_remarks;
    }


    @Override
    public String toString() {
        return "Credit{" +
                "credit_id=" + credit_id +
                ", mem_id=" + mem_id +
                ", credit_sno='" + credit_sno + '\'' +
                ", credit_name='" + credit_name + '\'' +
                ", credit_major='" + credit_major + '\'' +
                ", credit_grade='" + credit_grade + '\'' +
                ", credit_dep='" + credit_dep + '\'' +
                ", credit_score='" + credit_score + '\'' +
                ", credit_reason='" + credit_reason + '\'' +
                ", credit_gettime='" + credit_gettime + '\'' +
                ", credit_recorder='" + credit_recorder + '\'' +
                ", credit_recordtime='" + credit_recordtime + '\'' +
                ", credit_remarks='" + credit_remarks + '\'' +
                '}';
    }
}
