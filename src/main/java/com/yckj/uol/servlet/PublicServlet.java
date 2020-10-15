package com.yckj.uol.servlet;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.yckj.uol.pojo.*;
import com.yckj.uol.service.IPublicService;
import com.yckj.uol.service.Impl.PublicServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
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
@WebServlet(value = "/PublicServlet")
public class PublicServlet extends HttpServlet {
    private IPublicService publicService = new PublicServiceImpl();
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
        if ("addPublic".equals(method)) {
            this.addPublic(req, resp);
        }else if("selectByCondition".equals(method)){
            this.selectByCondition(req,resp);
        } else {
            logger.debug("请求的地址不存在");
        }
    }
    /**
     * 添加公开课信息
     * @param req
     * @param resp
     */
    public void addPublic(HttpServletRequest req, HttpServletResponse resp){
        String data = req.getParameter("data");
        logger.debug("data:"+data);
        Gson gson = new Gson();
        // 将JSON字符串转换成Java对象
        Publik publik = gson.fromJson(data, Publik.class);
        logger.debug(publik);
        PrintWriter writer = null;
        try{
            boolean flag = publicService.insert(publik);
            logger.debug(flag);
            writer = resp.getWriter();
            if(flag){
                logger.debug("公开课添加成功");
//                resp.sendRedirect("/UserServlet?method=pageSelect&page=1&limit=10");
                resp.getWriter().println(1);
                //resp.sendRedirect("page/UserManage/selectUser.jsp");
            }else{
                logger.debug("公开课添加失败");
                writer.println(0);
                Thread.sleep(3000);
                resp.sendRedirect("page/PublicManage/addPublic.jsp");
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
        logger.debug("他的值为"+data);
        Gson gson = new Gson();
        PqueryItem item = null;
        if (data ==null){
            item =null;
        }else{
            item= gson.fromJson(data,PqueryItem.class);
            if (item.getTime()!=null&&!("".equals(item.getTime()))){
                String s = item.getTime();
                String[] split1 = s.split("-");
                String s1 = split1[0].toString();
                String s2 = split1[1].toString();
                String s3 = split1[2].toString();
                String s4 = s1 + s2 + s3;
                String trim1 = s4.trim();
                String s5 = split1[3].toString();
                String s6 = split1[4].toString();
                String s7 = split1[5].toString();
                String s8 = s5 + s6 + s7;
                String trim2 = s8.trim();
                logger.debug(trim1);
                logger.debug(trim2);
                item.setBegin_time(trim1);
                item.setEnd_time(trim2);
            }
          /*  if((item.getTime()==null||"".equals(item.getTime()))&&(item.getBegin_time()==null||"".equals(item.getBegin_time())&&(item.getEnd_time()==null||"".equals(item.getEnd_time())))){
                item = null;
            }*/
        }

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PageBean<Publik> pageBean = new PageBean<>();

        //获取当前页信息
        String pageCodeStr = req.getParameter("page");
        logger.debug("当前的值为"+pageCodeStr);
        int pageCode = 0;
        if(pageCodeStr != null){
            pageCode = Integer.parseInt(pageCodeStr);
        }else{
            System.out.println("转换异常");
        }
        logger.debug(pageCode);
        pageBean.setPageCode(pageCode);
        String limit = req.getParameter("limit");
        int i= 0;
        if(limit != null){
            i = Integer.parseInt(limit);
            logger.debug("当前的值为limit"+i);
        }else{
            System.out.println("转换异常");
        }
        pageBean.setPageSize(i);
        pageBean.setOrder("oid");
        pageBean.setSort("asc");

        //获取总记录数信息
        int total = 0;

        List<Publik> publicList =null;
        publicList = publicService.selectCombination(pageBean,item);
        logger.debug("他的值为"+publicList);
        for (Publik publik : publicList) {
            String public_date = publik.getPublic_date();
            public_date=public_date.substring(0,4)+"-"+public_date.substring(4,6)+"-"+public_date.substring(6,8);
            publik.setPublic_date(public_date);
        }
        //获取条数
        total= publicService.selectTotalByCondition(item);
        pageBean.setTotal(total);
        int totalPage = 0;
        if(total%pageBean.getPageSize() > 0) {
            // 如果总记录数除以每页显示的记录数不能整除，就要总页码加1
            totalPage = total/pageBean.getPageSize() + 1;
        }else {
            totalPage = total/pageBean.getPageSize();
        }
        // 设置总页数
        pageBean.setTotalPage(totalPage);
        // 设置当前页的记录信息
        pageBean.setBeanList(publicList);
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",total);
        //多少页
        map.put("data",publicList);
        String s = JSON.toJSONString(map);
        resp.getWriter().println(s);
        //将pageBean对象信息添加到request域中，转发回分页页面
        req.setAttribute("pageBean", pageBean);
    }
}
