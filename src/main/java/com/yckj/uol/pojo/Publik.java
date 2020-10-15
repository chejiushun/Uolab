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
public class Publik {
    /**
     * 表示公开课课程编号
     */
    private int public_id;
    /**
     * 表示公开课课程日期
     */
    private String public_date;
    /**
     * 表示公开课技术专题
     */
    private String public_project;
    /**
     * 表示公开课主讲人
     */
    private String public_speaker;
    /**
     * 表示公开课组织人
     */
    private String public_organizer;
    /**
     * 表示公开课演讲地点
     */
    private String public_place;
    /**
     * 表示创新学分值
     */
    private int public_credit;
    /**
     * 表示参加人数
     */
    private int public_people;
    /**
     * 表示公开课群体说明
     */
    private String public_group;
    /**
     * 表示公开课方式
     */
    private String public_classway;
    /**
     * 表示公开课备注
     */
    private String public_remarks;

    public int getPublic_id() {
        return public_id;
    }

    public void setPublic_id(int public_id) {
        this.public_id = public_id;
    }

    public String getPublic_date() {
        return public_date;
    }

    public void setPublic_date(String public_date) {
        this.public_date = public_date;
    }

    public String getPublic_project() {
        return public_project;
    }

    public void setPublic_project(String public_project) {
        this.public_project = public_project;
    }

    public String getPublic_speaker() {
        return public_speaker;
    }

    public void setPublic_speaker(String public_speaker) {
        this.public_speaker = public_speaker;
    }

    public String getPublic_organizer() {
        return public_organizer;
    }

    public void setPublic_organizer(String public_organizer) {
        this.public_organizer = public_organizer;
    }

    public String getPublic_place() {
        return public_place;
    }

    public void setPublic_place(String public_place) {
        this.public_place = public_place;
    }

    public int getPublic_credit() {
        return public_credit;
    }

    public void setPublic_credit(int public_credit) {
        this.public_credit = public_credit;
    }

    public int getPublic_people() {
        return public_people;
    }

    public void setPublic_people(int public_people) {
        this.public_people = public_people;
    }

    public String getPublic_group() {
        return public_group;
    }

    public void setPublic_group(String public_group) {
        this.public_group = public_group;
    }

    public String getPublic_classway() {
        return public_classway;
    }

    public void setPublic_classway(String public_classway) {
        this.public_classway = public_classway;
    }

    public String getPublic_remarks() {
        return public_remarks;
    }

    public void setPublic_remarks(String public_remarks) {
        this.public_remarks = public_remarks;
    }

    public Publik(int public_id, String public_date, String public_project, String public_speaker, String public_organizer, String public_place,int public_credit,int public_people, String public_group, String public_classway, String public_remarks) {
        this.public_id = public_id;
        this.public_date = public_date;
        this.public_project = public_project;
        this.public_speaker = public_speaker;
        this.public_organizer = public_organizer;
        this.public_place = public_place;
        this.public_credit = public_credit;
        this.public_people = public_people;
        this.public_group = public_group;
        this.public_classway = public_classway;
        this.public_remarks = public_remarks;
    }

    public Publik() {
    }

    @Override
    public String toString() {
        return "Publik{" +
                "public_id=" + public_id +
                ", public_date='" + public_date + '\'' +
                ", public_project='" + public_project + '\'' +
                ", public_speaker='" + public_speaker + '\'' +
                ", public_organizer='" + public_organizer + '\'' +
                ", public_place='" + public_place + '\'' +
                ", public_credit=" + public_credit +
                ", public_people=" + public_people +
                ", public_group='" + public_group + '\'' +
                ", public_classway='" + public_classway + '\'' +
                ", public_remarks='" + public_remarks + '\'' +
                '}';
    }
}
