package com.yckj.uol.util;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

/**
 * Copyright(c) 2019 英才汇硕信息科技有限公司. All rights reserved
 *
 * 图片验证码生成Servlet
 *
 * @author shengyuee
 * @version 1.0 2019-11-13
 *
 *
 */
@WebServlet("/code")
public class VerifyCodeServlet extends HttpServlet {

    /**
     * get请求，获取图片验证码信息
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取图片验证码信息
        Map<String, Object> codeInfo = VerifyCodeUtils.getCode();
        String code = (String)codeInfo.get("code");
        BufferedImage buffImg = (BufferedImage)codeInfo.get("image");

        //将验证码的字符串信息保存到Session中
        HttpSession session = request.getSession();
        session.setAttribute("code",code);

        //设置响应头，禁止图像缓存
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        //设置响应类型为图片类型，不再是html
        response.setContentType("image/jpeg");

        //获取响应字节流
        ServletOutputStream sos = response.getOutputStream();
        //将图像输出到Servlet输出流中
        ImageIO.write(buffImg, "jpeg", sos);
    }

    /**
     * post请求
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
