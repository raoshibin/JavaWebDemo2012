package com.shop.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @Author 饶世斌
 * @Date 2021/3/9 18:55
 * @Version 1.0
 * @describe 验证码
 */
@WebServlet(name = "VerifyCodeServlet", urlPatterns = "/verifyCode.do")
public class VerifyCodeServlet extends HttpServlet {
    static StringBuffer stringBuffer=new StringBuffer();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 1.使用BufferedImage创建图片
         * 2.Graphics绘制内容
         * 绘制显示区域
         * 绘制随机字符
         * 绘制干扰线
         * 3.使用ImageIO将BufferedImage写到浏览器
         * 必须使用response.getOutputStream
         */
        //每次刷新都清空StringBuffer中内容
        stringBuffer.delete(0,stringBuffer.length());
        //1.高和宽
        int height = 25;
        int width = 79;
        String data = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        //2.创建一个图片
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //3.获得画板
        Graphics g = image.getGraphics();
        //4.填充一个矩形
        //设置颜色
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.WHITE);
        g.fillRect(1, 1, width - 2, height - 2);
        //设置字体
        g.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 25));
        //5 写随机字
        for (int i = 0; i < 4; i++) {
            //设置颜色 随机数
            g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
            //获得随机字
            int index = random.nextInt(data.length());
            String str = data.substring(index, index + 1);
           //动态验证码拼接
            //stringBuffer=null;
            stringBuffer.append(str);
            //写入
            g.drawString(str, width / 6 * (i + 1), 20);
        }
        System.out.println("画的验证码："+stringBuffer);
        //创建域对象
        //request.setAttribute("veriftCode",stringBuffer.toString());
        //request.getRequestDispatcher("/registUser.do").forward(request,response);
        //6.花干扰线
        for (int i = 0; i < 3; i++) {
            //设置颜色
            g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
            //绘制随机线
            g.drawLine(random.nextInt(width), random.nextInt(height), random.nextInt(width), random.nextInt(height));
            //随机点
            g.drawOval(random.nextInt(width), random.nextInt(height), 2, 2);
        }

        //将图片响应给浏览器
        ImageIO.write(image, "jpg", response.getOutputStream());
    }
}
