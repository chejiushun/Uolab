package com.yckj.uol.service.Impl;


import com.yckj.uol.dao.MemberMapper;
import com.yckj.uol.pojo.*;
import com.yckj.uol.service.IMemberService;
import com.yckj.uol.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

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
public class MemberServiceImpl implements IMemberService {
    private Logger logger = Logger.getLogger(this.getClass());

    /**
     * 实现添加实验室成员信息
     * @param member
     * @return
     */
    @Override
    public boolean insert(Member member) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
        boolean flag = false;
        int res = mapper.insert(member);
        if (res > 0) {
            flag = true;
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return flag;
    }

    @Override
    public boolean update(Member member) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
        logger.debug("进入"+this.getClass().getName()+"修改方法");
        boolean flag = false;
        int res = mapper.update(member);
        if (res > 0) {
            flag = true;
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        logger.debug("离开"+this.getClass().getName()+"修改方法");
        sqlSession.close();
        return flag;
    }

    @Override
    public List<Member> selectAll() {
        return null;
    }

    @Override
    public boolean deleteById(int mem_id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
        boolean flag = false;
        int res = mapper.deleteByMem_id(mem_id);
        if (res > 0){
            flag = true;
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        return flag;
    }


    @Override
    public boolean deleteBatch(int[] ids) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
        boolean flag = false;
        int i = mapper.deleteBatch(ids);
        if(i>0) {
            sqlSession.commit();
            flag=true;
        }else {
            sqlSession.rollback();
        }
        return flag;
    }

    @Override
    public Member selectByMem_id(int mem_id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
        Member member = mapper.selectByMem_id(mem_id);
        if (member != null){
            logger.debug("查询成功");
            logger.debug(member);
        } else {
            logger.debug("查询失败");
        }
        sqlSession.close();
        return member;
    }

    @Override
    public List<Member> selectCombination(PageBean pageBean, MqueryItem item) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
        List<Member> list = mapper.selectCombination(pageBean,item);
        sqlSession.close();
        return list;
    }

    @Override
    public int selectTotalByCondition(MqueryItem item) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
        int i = mapper.selectTotalByCondition(item);
        sqlSession.close();
        return i;
    }

    /**
     * 根据院系分组统计每个院系的人数，列出院系名称和成员人数
     */
    @Override
    public List<EchartsBean> staticMemberByDept() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
        List<EchartsBean> echartsBeans = mapper.countMemberByDept();
        //System.out.println(echartsBeans);
        MyBatisUtil.close(sqlSession);
        return echartsBeans;
    }

    /**
     * 根据院系分组统计后，查询出对应的院系名称
     */
    @Override
    public List<String> queryDeptName() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
        List<String> list = mapper.selectDeptName();
        //System.out.println(list);
        MyBatisUtil.close(sqlSession);
        return list;
    }
}
