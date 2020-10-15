package com.yckj.uol.service.Impl;

import com.yckj.uol.pojo.Member;
import com.yckj.uol.service.IMemberService;
import org.apache.log4j.Logger;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;


/**
 * Description:描述
 * Copyright:Copyright(c) 2020
 * Company 英才汇硕有限公司
 *
 * @author cjs <br>
 * @version 1.0 <br>
 * @created Administrator 2020/8/26
 */

public class MemberServiceImplTest {
    private Logger logger = Logger.getLogger(this.getClass());
    /**
     * 测试按条件组合查询：姓名，年级，电话，院系，专业，状态，是否担任管理职务。
     */
    @Test
    public void selectCombination() {
//        IMemberService memberService = new MemberServiceImpl();
//        List<Member> list = memberService.selectCombination("", "", "", "", "","","","");
//        logger.debug(list.size());
    }

    /**
     * 测试添加实验室成员信息
     */
    @Test
    public void insert() {
        IMemberService memberService = new MemberServiceImpl();
        Member member = new Member();
     //   member.setClass_name("计科一班");
        member.setMem_name("张三");
       // member.setMem_sno(25);
     //   member.setMem_sex('男');
        member.setMem_grade("2019级");
        member.setMem_nation("山西");
        member.setMem_dep("外国语学院");
        member.setMem_major("英语");
        member.setMem_duty("劳动委员");
        member.setMem_date("2019年9月1日");
        member.setMem_tel("15321526252");
    //    member.setMem_state("启用");
        member.setMem_sysduty("组长");
        member.setMem_remarks("暂无");
        boolean flag = memberService.insert(member);
        if (flag){
            logger.debug("添加实验室成员成功");
        } else {
            logger.debug("添加实验室成员失败");
        }
    }

    /**
     * 测试根据实验室成员编号修改实验室成员信息
     */
    @Test
    public void updateByMem_id() {
        IMemberService memberService = new MemberServiceImpl();
        Member member = new Member();
        member.setMem_id(3);
        member.setMem_tel("15535624532");
        member.setMem_duty("学生会干部");
     //   member.setMem_state("禁用");
        member.setMem_sysduty("项目经理");
        member.setMem_remarks("暂时没有");
        boolean flag = memberService.update(member);
        if (flag){
            logger.debug("修改实验室成员信息成功");
        } else {
            logger.debug("修改实验室成员信息失败");
        }
    }

    /**
     * 测试据实验室成员编号删除实验室成员信息
     */
    @Test
    public void deleteByMem_id() {
        IMemberService memberService = new MemberServiceImpl();
        boolean flag = memberService.deleteById(2);
        if (flag) {
            logger.debug("删除实验室成员信息成功");
        } else {
            logger.debug("删除实验室成员信息失败");
        }
    }

    /**
     * 测试批量删除实验室成员信息
     */
    @Test
    public void deleteBatch() {
//        IMemberService memberService = new MemberServiceImpl();
//        Member member = new Member();
//        member.setMem_id(1);
//        Member member1 = new Member();
//        member1.setMem_id(3);
//        List<Member> list = new ArrayList<>();
//        list.add(member);
//        list.add(member1);
//        boolean flag = memberService.deleteBatch(list);
//        if (flag){
//            logger.debug("批量删除实验室成员信息成功");
//        } else{
//            logger.debug("批量删除实验室成员信息失败");
//        }
   }
}

