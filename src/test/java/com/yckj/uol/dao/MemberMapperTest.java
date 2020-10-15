package com.yckj.uol.dao;

import com.yckj.uol.pojo.Member;
import com.yckj.uol.pojo.MqueryItem;
import com.yckj.uol.pojo.PageBean;
import com.yckj.uol.pojo.User;
import com.yckj.uol.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
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
 * @created Administrator 2020/8/24
 */

public class MemberMapperTest {
    private Logger logger = Logger.getLogger(this.getClass());

    /**
     * 测试按条件组合查询：姓名，年级，电话，院系，专业，状态，是否担任管理职务。
     */
    @Test
    public void selectCombination() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
        PageBean<Member> pageBean = new PageBean<>();
        pageBean.setPageCode(1);
        pageBean.setPageSize(1);
        pageBean.setSort("asc");
        pageBean.setOrder("mem_id");
        MqueryItem item = new MqueryItem();
        item.setMem_major("计算机科学与技术");
        List<Member> members = mapper.selectCombination(pageBean, item);
        for (Member member : members) {
            System.out.println(member);
        }
        sqlSession.close();
    }

    /**
     * 测试添加实验室成员信息
     */
    @Test
    public void insert() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
        Member member = new Member();
       // member.setClass_name("计科一班");
        member.setMem_id(9);
        member.setMem_name("刘七");
      // member.setMem_sno(125);
        //member.setMem_sex('女');
        member.setMem_grade("2020级");
        member.setMem_nation("山西");
        member.setMem_dep("外国语学院");
        member.setMem_major("英语");
        member.setMem_duty("劳动委员");
        member.setMem_date("2019年9月1日");
        member.setMem_tel("15321526252");
     //   member.setMem_state("启用");
        member.setMem_sysduty("组长");
        member.setMem_remarks("暂无");
        int res = mapper.insert(member);
        if (res > 0){
            sqlSession.commit();
            logger.debug("添加实验室成员信息成功");
        } else {
            sqlSession.rollback();
            logger.debug("添加实验室成员信息失败");
        }
        sqlSession.close();
    }

    /**
     * 测试根据实验室成员编号修改实验室成员信息
     */
    @Test
    public void updateMem_id() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
        Member member = new Member();
        member.setMem_id(12);
        member.setMem_tel("15113450321");
        member.setMem_duty("社团干部");
    //    member.setMem_state("启用");
        member.setMem_sysduty("项目负责人");
        member.setMem_remarks("暂时没有");
        int res = mapper.update(member);
        logger.debug(res);
        if (res > 0){
            sqlSession.commit();
            logger.debug("修改实验室成员信息成功");
        }else{
            sqlSession.rollback();
            logger.debug("修改实验室成员失败");
        }
        sqlSession.close();
    }

    /**
     * 测试根据实验室成员编号删除实验室成员信息
     */
    @Test
    public void deleteByMem_id() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
        int res = mapper.deleteByMem_id(12);
        logger.debug(res);
        if (res > 0){
            sqlSession.commit();
            logger.debug("删除实验室成员信息成功");
        } else {
            sqlSession.rollback();
            logger.debug("删除实验室成员信息失败");
        }
        sqlSession.close();
    }

    /**
     * 测试批量删除实验室成员信息
     */
    @Test
    public void deleteBatch() {
//        SqlSession sqlSession = MyBatisUtil.getSqlSession();
//        MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
//        Member member = new Member();
//        member.setMem_id(5);
//        Member member1 = new Member();
//        member1.setMem_id(3);
//        List<Member> list = new ArrayList<>();
//        list.add(member);
//        list.add(member1);
//        int res = mapper.deleteBatch(list);
//        if (res > 0) {
//            sqlSession.commit();
//            logger.debug("批量删除实验室成员信息成功");
//        } else {
//            sqlSession.rollback();
//            logger.debug("批量删除实验室成员信息失败");
//        }
//        sqlSession.close();
   }
}
