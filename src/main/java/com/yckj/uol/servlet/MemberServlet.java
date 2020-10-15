package com.yckj.uol.servlet;

import com.google.gson.Gson;
import com.yckj.uol.pojo.*;
import com.yckj.uol.service.IMemberService;
import com.yckj.uol.service.Impl.MemberServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:描述
 * Copyright:Copyright(c) 2020
 * Company 英才汇硕有限公司
 *
 * @author cjs <br>
 * @version 1.0 <br>
 * @created Administrator 2020/9/11
 */
@WebServlet(value = "/MemberServlet")
public class MemberServlet extends HttpServlet {
    private IMemberService memberService = new MemberServiceImpl();
    private Logger logger = Logger.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置响应编码，防止页面中文乱码
        resp.setContentType("text/html;charset=utf-8");
        // 获取方法名称
        String method = req.getParameter("method");
        System.out.println("method=" + method);
        if ("addMember".equals(method)){
            this.addMember(req,resp);
        }else if("selectByCondition".equals(method)){
            this.selectByCondition(req,resp);
        }else if ("statisticPage".equals(method)) {
            this.statisticPage(req,resp);
        }else if("selectDetailByMem_id".equals(method)){
            this.selectDetailByMem_id(req,resp);
        }else if ("updateMember".equals(method)){
            this.updateMember(req,resp);
        }else if ("selectByMem_id".equals(method)){
            this.selectByMem_id(req,resp);
        }else if ("deleteByMem_id".equals(method)){
            this.deleteByMem_id(req,resp);
        }else if("batchDelete".equals(method)){
            this.batchDelete(req,resp);
        }else {
            logger.debug("请求的地址不存在");
        }
    }


    /**
     * 添加实验室成员
     * @param req
     * @param resp
     */
    private void addMember(HttpServletRequest req, HttpServletResponse resp){
        String data = req.getParameter("data");
        logger.debug("data:"+data);
        Gson gson = new Gson();
        // 将JSON字符串转换成Java对象
        Member member = gson.fromJson(data, Member.class);
        logger.debug(member);
        PrintWriter writer = null;
        try{
            boolean flag = memberService.insert(member);
            logger.debug(flag);
            writer = resp.getWriter();
            if(flag){
                writer.println(1);
            }else{
                writer.println(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(writer != null){
                writer.close();
            }
        }
    }

    /**
     * 修改参赛
     * @param req
     * @param resp
     */
    private void updateMember(HttpServletRequest req, HttpServletResponse resp) {
        String data = req.getParameter("data");
        logger.debug("data:"+data);
        Gson gson = new Gson();
        // 将JSON字符串转换成Java对象
        Member member = gson.fromJson(data, Member.class);
        logger.debug(member);
        Member member1 = (Member) req.getSession().getAttribute("member1");
        member.setMem_id(member1.getMem_id());
        PrintWriter writer = null;
        try {
            boolean flag = memberService.update(member);
            logger.debug(flag);
            writer = resp.getWriter();
            if (flag) {
                logger.debug("修改成功");
                writer.println(1);
                //resp.sendRedirect(req.getContextPath()+"/page/User/selectUser.jsp");
            } else {
                logger.debug("修改失败");
                writer.println(0);
                //resp.sendRedirect("page/User/updateUser.jsp");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null){
                writer.close();
            }
        }
    }

    /**
     * 动态分页查询
     * @param req
     * @param resp
     * @throws IOException
     */
    private void selectByCondition(HttpServletRequest req, HttpServletResponse resp) throws IOException {
      String data = req.getParameter("data");
        System.out.println("接收的参数"+data);
        MqueryItem item = null;
        Gson gson = new Gson();
        if(data == null) {
            item = null;
        }else{
            // 1.封装成MqueryItem
            // 将JSON字符串转换成Java对象
            item = gson.fromJson(data, MqueryItem.class);
            if((item.getMem_name()==null||"".equals(item.getMem_name()))&&(item.getMem_major()==null||"".equals(item.getMem_major()))&&(item.getMem_dep()==null||"".equals(item.getMem_dep()))&&(item.getMem_class()==null||"".equals(item.getMem_class()))&&(item.getMem_grade()==null||"".equals(item.getMem_grade()))&&(item.getMem_tel()==null||"".equals(item.getMem_tel()))&&(item.getMem_duty()==null||"".equals(item.getMem_duty()))&&(item.getMem_state()==0||"".equals(item.getMem_state()))){
                item = null;
            }
     }

      // 2.封装PageBean
     //获取当前页码
        String pageCodeStr = req.getParameter("page");
       // 一页显示的记录数
       String limit = req.getParameter("limit");
        //创建PageBean对象
        PageBean<Member> pageBean = new PageBean<>();
        int pageCode = 0;
        if(pageCodeStr != null){
            pageCode = Integer.parseInt(pageCodeStr);
        }else{
            System.out.println("转换异常");
        }
        pageBean.setPageCode(pageCode);
        int pageSize = 0;
        if(limit != null){
            pageSize = Integer.parseInt(limit);

        }
        pageBean.setPageSize(pageSize);
        pageBean.setOrder("mem_id");
        pageBean.setSort("asc");
        //获取总记录数信息
        int total = memberService.selectTotalByCondition(item);

        // 设置总记录数
        pageBean.setTotal(total);

        // 获取总页数
        int totalPage = 0;

        if(total%pageBean.getPageSize() > 0) {
            // 如果总记录数除以每页显示的记录数不能整除，就要总页码加1
            totalPage = total/pageBean.getPageSize() + 1;
        }else {
            totalPage = total/pageBean.getPageSize();
        }
       // 设置总页数
       pageBean.setTotalPage(totalPage);

        List<Member> memberList = null;

        memberList = memberService.selectCombination(pageBean,item);
        // 设置当前页的记录信息
       pageBean.setBeanList(memberList);
        //将pageBean对象信息添加到request域中，转发回分页页面
        req.setAttribute("pageBean", pageBean);
        Map<String,Object> map = new LinkedHashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",total);
        map.put("data",memberList);
        String s = gson.toJson(map);
        System.out.println("生成的JSON串："+s);
        PrintWriter writer = resp.getWriter();
        writer.println(s);
        writer.close();
    }

    /**
     * 去统计页面
     * @param req
     * @param resp
     */
    public void statisticPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  根据院系统计（饼图2）
        statisticCollege(req,resp);
        req.getRequestDispatcher("/page/Statis/statisMember.jsp").forward(req,resp);

    }

    /**
     * 根据院系统计 （饼图2）
     * @param req
     * @param resp
     */
    public void statisticCollege(HttpServletRequest req, HttpServletResponse resp){
        // 分组统计后的院系名称
        staticDeptName(req,resp);
        // 根据院系分组统计每个院系的人数，列出院系名称和成员人数对应的数据
        staticMemberByDept(req,resp);
    }


    /**
     * 根据院系分组统计每个院系的人数，列出院系名称和成员人数
     */
    public void staticMemberByDept(HttpServletRequest req, HttpServletResponse resp)  {

        List<EchartsBean> echartsBeans = memberService.staticMemberByDept();
        Gson gson = new Gson();
        String json = gson.toJson(echartsBeans);
        logger.debug("collegeDatas:"+json);
        req.setAttribute("collegeDatas",json);
    }
    /**
     * 根据院系分组统计后，查询出对应的院系名称
     */
    public void staticDeptName(HttpServletRequest req, HttpServletResponse resp){
        List<String> list = memberService.queryDeptName();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        logger.debug("college:"+json);
        req.setAttribute("college",json);
    }

    /**
     * 查看参赛详情
     * @param req
     * @param resp
     */
    private void selectDetailByMem_id(HttpServletRequest req, HttpServletResponse resp) {
        // 获取要修改的用户的ID
        String mem_id = req.getParameter("mem_id");
        logger.debug("mem_id="+mem_id);
        int id = Integer.parseInt(mem_id);
        Member member = memberService.selectByMem_id(id);
        req.getSession().setAttribute("member2",member);
        try {
            req.getRequestDispatcher("page/MemberManage/memberDetail.jsp").forward(req,resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据ID查询
     * @param req
     * @param resp
     */
    public void selectByMem_id(HttpServletRequest req, HttpServletResponse resp) {
        // 获取要修改的竞赛的ID
        String mem_id = req.getParameter("mem_id");
        logger.debug("mem_id="+mem_id);
        int id = Integer.parseInt(mem_id);
        Member member = memberService.selectByMem_id(id);
        req.getSession().setAttribute("member1",member);
        try {
            req.getRequestDispatcher("page/MemberManage/updateMember.jsp").forward(req,resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 根据竞赛ID删除信息
     * @param req
     * @param resp
     */
    public void deleteByMem_id(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String mem_id = req.getParameter("mem_id");
        logger.debug("mem_id="+mem_id);
        if(mem_id != null){
            int id = Integer.parseInt(mem_id);
            boolean flag = memberService.deleteById(id);
            if(flag){
                resp.getWriter().print(1);
            }else{
                resp.getWriter().print(0);
            }
        }else{
            logger.debug("mem_id为空");
        }
    }

    /**
     * 批量删除
     * @param req
     * @param resp
     * @throws IOException
     */
    private void batchDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String ids = req.getParameter("ids");
        logger.debug("接收到的参数"+ids);
        if(ids != null){
            String[] idsArr = ids.split(",");
            logger.debug(Arrays.toString(idsArr));
            int[] idsArr1 = new int[idsArr.length];
            for (int i = 0; i < idsArr1.length;i++){
                if(idsArr[i] != null && idsArr[i] !="") {
                    int num = Integer.parseInt(idsArr[i]);
                    idsArr1[i] = num;
                }
            }
            logger.debug("转换后的ids数组："+Arrays.toString(idsArr));
            boolean flag = memberService.deleteBatch(idsArr1);
            PrintWriter writer = resp.getWriter();
            if (flag) {
                writer.println(1);
            } else {
                writer.println(0);
            }
            writer.close();
        }

    }

}
