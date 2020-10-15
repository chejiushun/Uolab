package com.yckj.uol.service.Impl;

import com.yckj.uol.pojo.Publik;
import com.yckj.uol.service.IPublicService;
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
public class PublicServiceImplTest {
    private Logger logger = Logger.getLogger(this.getClass());

    /**
     * 测试根据时间段查询公开课信息
     */
    @Test
    public void selectByPublic_time() {
        IPublicService publicService = new PublicServiceImpl();
        List<Publik> list = publicService.selectByPublic_time("20200101", "20220101");
        for (Publik publik : list) {
            logger.debug(publik);
        }
    }

    /**
     * 测试添加公开课信息
     */
    @Test
    public void insert() {
        IPublicService publicService = new PublicServiceImpl();
        Publik publik = new Publik();
        publik.setPublic_id(8);
        publik.setPublic_date("2017年6月1日");
        publik.setPublic_project("语文");
        publik.setPublic_speaker("赵燕");
        publik.setPublic_organizer("赵艳");
        publik.setPublic_place("海南");
        publik.setPublic_group("暂无");
        publik.setPublic_classway("线上");
        publik.setPublic_remarks("暂无");
        boolean flag = publicService.insert(publik);
        if (flag){
            logger.debug("录入公开课信息成功");
        } else {
            logger.debug("录入公开课信息失败");
        }
    }
}
