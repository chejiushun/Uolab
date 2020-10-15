package com.yckj.uol.servlet;

import com.google.gson.Gson;
import com.yckj.uol.pojo.Credit;
import com.yckj.uol.service.ICreditService;
import com.yckj.uol.service.Impl.CreditServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Description:描述
 * Copyright:Copyright(c) 2020
 * Company 英才汇硕有限公司
 *
 * @author cjs <br>
 * @version 1.0 <br>
 * @created Administrator 2020/9/11
 */
@WebServlet(value = "/CreditServlet")
public class CreditServlet extends HttpServlet {
    private ICreditService creditService = new CreditServiceImpl();
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
        if ("addCredit".equals(method)){
            this.addCredit(req,resp);
        }else{
            logger.debug("请求的地址不存在");
        }
    }

    /**
     * 添加用户信息
     * @param req
     * @param resp
     */
    public void addCredit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String data = req.getParameter("data");
        System.out.println("data:" + data);
        Gson gson = new Gson();
        // 将JSON字符串转换成Java对象
        Credit credit = gson.fromJson(data, Credit.class);
        logger.debug(credit);
        PrintWriter writer = null;
        try{
            boolean flag = creditService.insert(credit);
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
}
