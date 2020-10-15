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
public class ClassPublic {
    /**
     * 表示实验室成员编号
     */
    private int mem_id;
    /**
     * 表示班级编号
     */
    private int class_id;

    public int getMem_id() {
        return mem_id;
    }

    public void setMem_id(int mem_id) {
        this.mem_id = mem_id;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public ClassPublic(int mem_id, int class_id) {
        this.mem_id = mem_id;
        this.class_id = class_id;
    }

    public ClassPublic() {
    }

    @Override
    public String toString() {
        return "ClassPublic{" +
                "mem_id=" + mem_id +
                ", class_id=" + class_id +
                '}';
    }
}
