package com.yckj.uol.servlet;

import com.yckj.uol.pojo.User;
import com.yckj.uol.service.IUserService;
import com.yckj.uol.service.Impl.UserServiceImpl;
import com.yckj.uol.util.Constant;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Description:描述 【用户登录】
 * Copyright:Copyright(c) 2020
 * Company 英才汇硕有限公司
 *
 * @author cjs <br>
 * @version 1.0 <br>
 * @created Administrator 2020/8/31
 */
//@WebServlet(value = "/login",loadOnStartup = 1)
public class LoginServlet  extends HttpServlet {
    private Logger logger = Logger.getLogger(this.getClass());
    private IUserService userService = new UserServiceImpl();

    @Override
    public void init() throws ServletException {
        ServletContext servletContext = this.getServletContext();
        servletContext.setAttribute("count",0);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 针对Post请求处理中文乱码,设置编码
        req.setCharacterEncoding("utf-8");
        //放止响应数据乱码
        resp.setContentType("text/html;charset=utf-8");
        //获取请求参数的值
        String user_name = req.getParameter("user_name");
        String user_pwd = req.getParameter("user_pwd");
        String code = req.getParameter("code");
        logger.debug("code="+code);
        String autoLogin = req.getParameter("autoLogin");

        logger.debug("用户名："+user_name);
        logger.debug("密码："+user_pwd);

        //图片验证码校验
        HttpSession session = req.getSession();
        String sessionCode = (String)session.getAttribute("code");
        logger.debug("sessionCode="+sessionCode);
        if(code == null || !code.equalsIgnoreCase(sessionCode)) {
            req.setAttribute("msg", "验证码输入有误！");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login.jsp");
            requestDispatcher.forward(req, resp);
            return;
        }

        User user = new User();
        user.setUser_name(user_name);
        user.setUser_pwd(user_pwd);
        // 调用业务层的登录方法
        boolean login = userService.login(user);
        logger.debug(login);
        if (login) {
            logger.debug("登录成功");
            logger.debug("欢迎"+user_name+"登录");
            // 将用户名放到session域对象中
            session.setAttribute("user_name",user_name);
            // 统计登录次数
            // 获取上下文对象
            ServletContext servletContext = this.getServletContext();
            // 获取登录次数
            // 获取count属性
            Integer count = (Integer) servletContext.getAttribute("count");
            // 登录成功，获取的count不为空，将count值加1
            count++;
            servletContext.setAttribute("count",count);

            //判断是否勾选了自动登录  若勾选了登录成功后需要将用户名和密码放入cookie中, 写回浏览器
            if(Constant.IS_AUTO_LOGIN.equals(autoLogin)){
                logger.debug("勾选了自动登录");
                //编码是为了在cookie中存储汉字
                String user_nameCode = URLEncoder.encode(user_name, "utf-8");
                Cookie usernameCookie = new Cookie("user_name",user_nameCode);
                Cookie passwordCookie = new Cookie("pass_word",user_pwd);
                //设置持久化时间
                usernameCookie.setMaxAge(60*60);
                passwordCookie.setMaxAge(60*60);
                //设置cookie携带路径
                usernameCookie.setPath(req.getContextPath());
                passwordCookie.setPath(req.getContextPath());
                //发送cookie
                resp.addCookie(usernameCookie);
                resp.addCookie(passwordCookie);
            }
            session.setAttribute("user", user);
            // 重定向
            resp.sendRedirect(req.getContextPath()+"/index.jsp");
        }else{
            logger.debug("登录失败");
            // 将用户名放进session域中
            String msg = "用户名或密码错误";
            session.setAttribute("msg",msg);
            resp.sendRedirect(req.getContextPath()+"/login.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
