package com.yckj.uol.servlet;

import com.google.gson.Gson;
import com.yckj.uol.pojo.Major;
import com.yckj.uol.service.IMajorService;
import com.yckj.uol.service.Impl.MajorServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Description:描述
 * Copyright:Copyright(c) 2020
 * Company 英才汇硕有限公司
 *
 * @author cjs <br>
 * @version 1.0 <br>
 * @created Administrator 2020/9/11
 */
@WebServlet(value = "/MajorServlet")
public class MajorServlet extends HttpServlet {
    private IMajorService majorService = new MajorServiceImpl();
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
        if ("addMajor".equals(method)){
            this.addMajor(req,resp);
        }else if("selectByDep_name".equals(method)){
            this.selectByDep_name(req,resp);
        }else if("selectByDep_id".equals(method)){
            this.selectByDep_id(req,resp);
        }else{
            logger.debug("请求的地址不存在");
        }
    }

    /**
     * 添加专业
     * @param req
     * @param resp
     */
    public void addMajor(HttpServletRequest req, HttpServletResponse resp){
        String data = req.getParameter("data");
        logger.debug("data:"+data);
        Gson gson = new Gson();
        // 将JSON字符串转换成Java对象
        Major major = gson.fromJson(data, Major.class);
        logger.debug(major);
        PrintWriter writer = null;
        try{
            boolean flag = majorService.insert(major);
            logger.debug(flag);
            writer = resp.getWriter();
            if(flag){
                logger.debug("专业添加成功");
//                resp.sendRedirect("/UserServlet?method=pageSelect&page=1&limit=10");
                resp.getWriter().println(1);
                //resp.sendRedirect("page/UserManage/selectUser.jsp");
            }else{
                logger.debug("专业添加失败");
                writer.println(0);
                Thread.sleep(3000);
                resp.sendRedirect("page/DepartmentManage/addMajor.jsp");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(writer != null){
                writer.close();
            }
        }
    }

    private void selectByDep_name(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        IMajorService majorService = new MajorServiceImpl();
        String dep_name = req.getParameter("dep_name");
        List<Major> list = majorService.selectByDep_name(dep_name);
        if (list != null && list.size() !=0) {
            Gson gson = new Gson();
            String s = gson.toJson(list);
            System.out.println(s);
            PrintWriter writer = resp.getWriter();
            writer.println(s);
            writer.close();
        }
    }
    private void selectByDep_id(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        IMajorService majorService = new MajorServiceImpl();
        String dep_id = req.getParameter("dep_id");
        if (dep_id != null){
            int id = Integer.parseInt(dep_id);
            List<Major> list = majorService.selectByDep_id(id);
            if (list != null && list.size() !=0) {
                Gson gson = new Gson();
                String s = gson.toJson(list);
                System.out.println(s);
                PrintWriter writer = resp.getWriter();
                writer.println(s);
                writer.close();
            }
        }else{
            logger.debug("dep_id为空");
        }

    }
}
