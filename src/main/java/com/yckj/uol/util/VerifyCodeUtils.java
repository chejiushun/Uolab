package com.yckj.uol.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Copyright(c) 2019 英才汇硕信息科技有限公司. All rights reserved
 *
 * 图片验证码生成工具类
 *
 * @author shengyuee
 * @version 1.0 2019-11-13
 *
 *
 */
public class VerifyCodeUtils {
    private static int width = 94;//定义图片的width
    private static int height = 25;//定义图片的height
    private static int codeCount = 4;//定义图片上显示验证码的个数
    private static int fontHeight = 20;//定义图片中字体的height，比图片略小
    private static int codeY = 20;//生成随机码的y坐标
    private static int xx = 20;//生成随机码的x坐标
    private static char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
            'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

    public static Map<String, Object> getCode() {
        //定义图像buffer对象
        BufferedImage buffImg = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);

        //获取图形处理类型，可以理解为画笔
        Graphics gd = buffImg.getGraphics();

        //将图像填充为白色
        gd.setColor(Color.WHITE);
        gd.fillRect(0, 0, width, height);

        //创建字体，字体的大小应该根据图片的高度来定。
        Font font = new Font("Fixedsys", Font.BOLD, fontHeight);
        //设置字体。
        gd.setFont(font);

        //画边框
        gd.setColor(Color.BLACK);
        gd.drawRect(0, 0, width - 1, height - 1);

        /*
         * 随机产生20条干扰线，使图象中的认证码不易被其它程序探测到。
         * x，y代表干扰线出现的坐标，xl，yl代表干扰线结束的坐标
         */
        // 创建一个随机数生成器类
        Random random = new Random();
        gd.setColor(Color.BLACK);
        for (int i = 0; i < 20; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            gd.drawLine(x, y, x + xl, y + yl);
        }

        //randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
        StringBuffer randomCode = new StringBuffer();
        int red = 0, green = 0, blue = 0;

        /*
         * 随机产生codeCount个数的验证码
         */
        for (int i = 0; i < codeCount; i++) {
            //得到随机产生的验证码数字
            String code = String.valueOf(codeSequence[random.nextInt(36)]);
            //产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。
            red = random.nextInt(255);
            green = random.nextInt(255);
            blue = random.nextInt(255);

            // 用随机产生的颜色将验证码绘制到图像中。
            gd.setColor(new Color(red, green, blue));
            gd.drawString(code, (i + 1) * xx, codeY);

            // 将产生的四个随机数组合在一起。
            randomCode.append(code);
        }

        //设置返回信息
        Map<String, Object> codeInfo = new HashMap<>();
        //添加验证码值
        codeInfo.put("code", randomCode.toString());
        //添加图片
        codeInfo.put("image", buffImg);

        return codeInfo;
    }
}
