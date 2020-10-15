package com.yckj.uol.service.Impl;

import com.yckj.uol.pojo.Match;
import com.yckj.uol.service.IMatchService;
import com.yckj.uol.service.IUserService;
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
public class MatchServiceImplTest {
    private Logger logger = Logger.getLogger(this.getClass());

    /**
     * 测试录入参赛信息
     */
    @Test
    public void insert() {
        IMatchService matchService = new MatchServiceImpl();
        Match match = new Match();
        match.setMatch_id(35);
        match.setMatch_kind("体育");
       // match.setMatch_year(2016);
        match.setMatch_title("拔河");
        match.setMatch_groupleader("李白");
        match.setMatch_groupmember("刘五");
        match.setMatch_comgrade("一等");
        match.setMatch_teacher("胡三");
        boolean flag = matchService.insert(match);
        if (flag){
            logger.debug("录入参赛信息成功");
        } else {
            logger.debug("录入参赛信息失败");
        }
    }

    /**
     * 测试根据竞赛编号对部分参赛信息修改
     */
    @Test
    public void updateByMatch_id() {
        IMatchService matchService = new MatchServiceImpl();
        Match match = new Match();
        match.setMatch_groupmember("王琪");
        match.setMatch_comgrade("二等");
        match.setMatch_id(10);
        boolean flag = matchService.updateByMatch_id(match);
        if (flag) {
            logger.debug("参赛信息修改成功");
        } else {
            logger.debug("参赛信息修改失败");
        }
    }

    @Test
    public void deleteBatch() {
        IMatchService matchService = new MatchServiceImpl();
        int[] arr = {5,6};
        boolean flag = matchService.deleteBatch(arr);
        if (flag){
            logger.debug("批量删除成功");
        } else{
            logger.debug("批量删除失败");
        }
    }

}
