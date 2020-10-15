package com.yckj.uol.servlet;

import com.google.gson.Gson;
import com.yckj.uol.pojo.Clazz;
import com.yckj.uol.service.IClazzService;
import com.yckj.uol.service.Impl.ClazzServiceImpl;
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
 * @created Administrator 2020/9/17
 */
@WebServlet(value = "/ClazzServlet")
public class ClassServlet  extends HttpServlet {
    private IClazzService clazzService = new ClazzServiceImpl();
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
        if ("addClazz".equals(method)){
            this.addClazz(req,resp);
        }else if("selectByMajor_name".equals(method)){
            this.selectByMajor_name(req,resp);
        }else{
            logger.debug("请求的地址不存在");
        }
    }


    /**
     * 添加班级
     * @param req
     * @param resp
     */
    public void addClazz(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("11111111111111111111");
        String data = req.getParameter("data");
        logger.debug("data:"+data);
        Gson gson = new Gson();
        // 将JSON字符串转换成Java对象
        Clazz clazz = gson.fromJson(data, Clazz.class);
        logger.debug(clazz);
        PrintWriter writer = null;
        try{
            boolean flag = clazzService.insert(clazz);
            logger.debug(flag);
            writer = resp.getWriter();
            if(flag){
                logger.debug("班级添加成功");
//                resp.sendRedirect("/UserServlet?method=pageSelect&page=1&limit=10");
                resp.getWriter().println(1);
                //resp.sendRedirect("page/UserManage/selectUser.jsp");
            }else{
                logger.debug("班级添加失败");
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

    private void selectByMajor_name(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        IClazzService clazzService = new ClazzServiceImpl();
        String major_name = req.getParameter("major_name");
        List<Clazz> list = clazzService.selectByMajor_name(major_name);
        if (list != null && list.size() !=0) {
            Gson gson = new Gson();
            String s = gson.toJson(list);
            System.out.println(s);
            PrintWriter writer = resp.getWriter();
            writer.println(s);
            writer.close();
        }
    }
}
