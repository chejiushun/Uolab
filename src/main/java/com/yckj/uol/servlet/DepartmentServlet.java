package com.yckj.uol.servlet;

import com.google.gson.Gson;
import com.yckj.uol.pojo.Department;
import com.yckj.uol.service.IDepartmentService;
import com.yckj.uol.service.Impl.DepartmentServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(value = "/DepartmentServlet")
public class DepartmentServlet extends HttpServlet {
    private IDepartmentService departmentService = new DepartmentServiceImpl();
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
        if ("addDepartment".equals(method)){
            this.addDepartment(req,resp);
        }else if ("selectAll".equals(method)){
            this.selectAll(req, resp);
        }else{
            logger.debug("请求的地址不存在");
        }
    }

    /**
     * 添加院系
     * @param req
     * @param resp
     */
    public void addDepartment(HttpServletRequest req, HttpServletResponse resp){
        String data = req.getParameter("data");
        logger.debug("data:"+data);
        Gson gson = new Gson();
        // 将JSON字符串转换成Java对象
        Department department = gson.fromJson(data, Department.class);
        logger.debug(department);
        PrintWriter writer = null;
        try{
            boolean flag = departmentService.insert(department);
            logger.debug(flag);
            writer = resp.getWriter();
            if(flag){
                logger.debug("院系添加成功");
//                resp.sendRedirect("/UserServlet?method=pageSelect&page=1&limit=10");
                resp.getWriter().println(1);
                //resp.sendRedirect("page/UserManage/selectUser.jsp");
            }else{
                logger.debug("院系添加失败");
                writer.println(0);
                Thread.sleep(3000);
                resp.sendRedirect("page/DepartmentManage/addDepartment.jsp");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(writer != null){
                writer.close();
            }
        }
    }

    private void selectAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        IDepartmentService departmentService = new DepartmentServiceImpl();
        List<Department> departments = departmentService.selectAll();
        if(departments != null && departments.size() !=0 ){
            Gson gson = new Gson();
            String s = gson.toJson(departments);
            System.out.println(s);
            PrintWriter writer = resp.getWriter();
            writer.println(s);
            writer.close();
        }
    }
}
