package com.yckj.uol.servlet;

import com.google.gson.Gson;
import com.yckj.uol.pojo.*;
import com.yckj.uol.service.IMatchService;
import com.yckj.uol.service.Impl.MatchServiceImpl;
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
@WebServlet(value = "/MatchServlet")
public class MatchServlet extends HttpServlet {
    private IMatchService matchService = new MatchServiceImpl();
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
        if ("addMatch".equals(method)){
            this.addMatch(req,resp);
        }else if("selectByCondition".equals(method)){
            this.selectByCondition(req,resp);
        }else if("selectDetailByMatch_id".equals(method)){
            this.selectDetailByMatch_id(req,resp);
        }else if ("selectByMatch_id".equals(method)){
            this.selectByMatch_id(req,resp);
        }else if ("updateMatch".equals(method)){
            this.updateMatch(req,resp);
        }else if("batchDelete".equals(method)){
            this.batchDelete(req,resp);
        }else if ("deleteByMatch_id".equals(method)){
            this.deleteByMatch_id(req,resp);
        }else{
            logger.debug("请求的地址不存在");
        }
    }


    /**
     * 录入参赛信息
     * @param req
     * @param resp
     */
    public void addMatch(HttpServletRequest req, HttpServletResponse resp){
        String data = req.getParameter("data");
        logger.debug("data:"+data);
        Gson gson = new Gson();
        // 将JSON字符串转换成Java对象
        Match match = gson.fromJson(data, Match.class);
        logger.debug(match);
        PrintWriter writer = null;
        try{
            boolean flag = matchService.insert(match);
            logger.debug(flag);
            writer = resp.getWriter();
            if(flag){
                logger.debug("参赛信息录入成功");
//                resp.sendRedirect("/UserServlet?method=pageSelect&page=1&limit=10");
                resp.getWriter().println(1);
                //resp.sendRedirect("page/UserManage/selectUser.jsp");
            }else{
                logger.debug("参赛信息录入失败");
                writer.println(0);
                Thread.sleep(3000);
                resp.sendRedirect("page/GameManage/addGame.jsp");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(writer != null){
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
        GqueryItem item = null;
        Gson gson = new Gson();
        if(data == null) {
            item = null;
        }else{
            // 1.封装成GqueryItem
            // 将JSON字符串转换成Java对象
            item = gson.fromJson(data, GqueryItem.class);
            if((item.getMatch_year()==null||"".equals(item.getMatch_year()))){
                item = null;
            }
        }

        // 2.封装PageBean
        //获取当前页码
        String pageCodeStr = req.getParameter("page");
        // 一页显示的记录数
        String limit = req.getParameter("limit");
        //创建PageBean对象
        PageBean<Match> pageBean = new PageBean<>();
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
        pageBean.setOrder("match_id");
        pageBean.setSort("asc");
        //获取总记录数信息
        int total = matchService.selectTotalByCondition(item);

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

        List<Match> userList = null;

        userList = matchService.selectCombination(pageBean,item);
        // 设置当前页的记录信息
        pageBean.setBeanList(userList);
        //将pageBean对象信息添加到request域中，转发回分页页面
        req.setAttribute("pageBean", pageBean);
        Map<String,Object> map = new LinkedHashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",total);
        map.put("data",userList);
        String s = gson.toJson(map);
        System.out.println("生成的JSON串："+s);
        PrintWriter writer = resp.getWriter();
        writer.println(s);
        writer.close();
    }

    /**
     * 查看参赛详情
     * @param req
     * @param resp
     */
    private void selectDetailByMatch_id(HttpServletRequest req, HttpServletResponse resp) {
        // 获取要修改的用户的ID
        String match_id = req.getParameter("match_id");
        logger.debug("match_id="+match_id);
        int id = Integer.parseInt(match_id);
        Match match = matchService.selectByMatch_id(id);
        req.getSession().setAttribute("match2",match);
        try {
            req.getRequestDispatcher("page/GameManage/gameDetail.jsp").forward(req,resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据ID查询竞赛
     * @param req
     * @param resp
     */
    public void selectByMatch_id(HttpServletRequest req, HttpServletResponse resp) {
        // 获取要修改的竞赛的ID
        String match_id = req.getParameter("match_id");
        logger.debug("match_id="+match_id);
        int id = Integer.parseInt(match_id);
        Match match = matchService.selectByMatch_id(id);
        req.getSession().setAttribute("match1",match);
        try {
            req.getRequestDispatcher("page/GameManage/updateGame.jsp").forward(req,resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 修改参赛
     * @param req
     * @param resp
     */
    public void updateMatch(HttpServletRequest req, HttpServletResponse resp) {
        String data = req.getParameter("data");
        logger.debug("data:"+data);
        Gson gson = new Gson();
        // 将JSON字符串转换成Java对象
        Match match = gson.fromJson(data, Match.class);
        logger.debug(match);
        Match match1 = (Match) req.getSession().getAttribute("match1");
        match.setMatch_id(match1.getMatch_id());
        PrintWriter writer = null;
        try {
            boolean flag = matchService.update(match);
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
     * 根据竞赛ID删除参赛信息
     * @param req
     * @param resp
     */
    public void deleteByMatch_id(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String match_id = req.getParameter("match_id");
        logger.debug("match_id="+match_id);
        if(match_id != null){
            int id = Integer.parseInt(match_id);
            boolean flag = matchService.deleteByMatch_id(id);
            if(flag){
                resp.getWriter().print(1);
            }else{
                resp.getWriter().print(0);
            }
        }else{
            logger.debug("match_id为空");
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
            boolean flag = matchService.deleteBatch(idsArr1);
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
