package com.yckj.uol.service.Impl;

import com.yckj.uol.pojo.Major;
import com.yckj.uol.service.IDepartmentService;
import com.yckj.uol.service.IMajorService;
import org.apache.log4j.Logger;
import org.junit.Test;


/**
 * Description:描述
 * Copyright:Copyright(c) 2020
 * Company 英才汇硕有限公司
 *
 * @author cjs <br>
 * @version 1.0 <br>
 * @created Administrator 2020/8/26
 */
public class MajorServiceImplTest {
    private Logger logger = Logger.getLogger(this.getClass());
    /**
     * 测试添加专业信息
     */
    @Test
    public void insert() {
        IMajorService majorService = new MajorServiceImpl();
        Major major = new Major();
      //  major.setDep_name("软件");
        major.setMajor_name("计算机科学与技术");
        major.setMajor_remarks("暂无");
        boolean flag = majorService.insert(major);
        if (flag){
            logger.debug("添加专业成功");
        } else {
            logger.debug("添加专业失败");
        }
    }
}
