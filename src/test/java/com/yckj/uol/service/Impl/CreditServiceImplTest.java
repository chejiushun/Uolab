package com.yckj.uol.service.Impl;

import com.yckj.uol.pojo.Credit;
import com.yckj.uol.service.ICreditService;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

/**
 * Description:描述
 * Copyright:Copyright(c) 2020
 * Company 英才汇硕有限公司
 *
 * @author cjs <br>
 * @version 1.0 <br>
 * @created Administrator 2020/8/27
 */
public class CreditServiceImplTest {
    private Logger logger = Logger.getLogger(this.getClass());

    /**
     * 测试录入学分信息
     */
    @Test
    public void insert() {
        ICreditService creditService = new CreditServiceImpl();
        Credit credit = new Credit();
        credit.setCredit_name("赵六");
       // credit.setCredit_sno(38);
        credit.setCredit_dep("机械学院");
        credit.setCredit_grade("2020级");
        //credit.setCredit_score(50);
        credit.setCredit_reason("必修课");
        credit.setCredit_gettime("20190105");
        credit.setCredit_recordtime("20200405");
        credit.setCredit_recorder("晓飞");
        credit.setCredit_remarks("没有");
        boolean flag = creditService.insert(credit);
        if (flag){
            logger.debug("录入学分信息成功");
        } else {
            logger.debug("录入学分信息失败");
        }
    }

    /**
     * 测试组合查询单个学生的创新学分记录：输入学号、姓名、时间段（年月），查询学生所有创新
     * 学分记录，并显示总分数
     */
    @Test
    public void selectCombination() {
        ICreditService creditService = new CreditServiceImpl();
        List<Credit> list = creditService.selectCombination(38, "赵六", "20190101", "20221001");
        for (Credit credit : list) {
            logger.debug(credit);
        }
    }
}
