package com.yckj.uol.service.Impl;

import com.yckj.uol.dao.MemberMapper;
import com.yckj.uol.pojo.Member;
import com.yckj.uol.pojo.MqueryItem;
import com.yckj.uol.pojo.PageBean;
import com.yckj.uol.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Description:描述
 * Copyright:Copyright(c) 2020
 * Company 英才汇硕有限公司
 *
 * @author cjs <br>
 * @version 1.0 <br>
 * @created Administrator 2020/10/2
 */
public class IMemberServiceTest {
    @Test
    public void selectCombination(){
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

}