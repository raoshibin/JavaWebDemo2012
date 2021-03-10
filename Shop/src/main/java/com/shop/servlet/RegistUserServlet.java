package com.shop.servlet;

import com.shop.bean.User;
import com.shop.dao.impl.UserDaoImpl;
import com.shop.service.UserService;
import com.shop.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author 饶世斌
 * @Date 2021/3/9 18:55
 * @Version 1.0
 * @describe 用户注册servlet
 */
@WebServlet(name = "RegistUserServlet", urlPatterns = "/registUser.do")
public class RegistUserServlet extends HttpServlet {
    User user = new User();
    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户在页面输入的内容  注册的请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");
        System.out.println("输入的验证码：" + code);

        //动态验证码
        String veriftCode = VerifyCodeServlet.stringBuffer.toString();
        System.out.println("画的域验证码：" + veriftCode);
        //检查输入的验证是否正确
        if (code.equals(veriftCode)) {
            //验证码正确后，再检查用户名是否存在
            boolean existUser = userService.existUser(username);
            if (existUser == true) { //返回false表示用户不存在
                System.out.println("用户名: " + username + "已存在!");
                //清空验证码
                veriftCode = null;
                //用户已存在跳回注册界面 请求转发
                request.getRequestDispatcher("pages/user/regist.html").forward(request, response);
            } else {
                //用户不存在
                System.out.println("用户名: " + username + "不存在，可注册!");
                //把验证码记录清空
                veriftCode = null;
                //把请求参数添加进User对象中
                user.setUsername(username);
                user.setPassword(password);
                user.setEmail(email);
                //调用注册方法
                boolean registUser = userService.registUser(user);
                if (registUser == true) {
                    System.out.println("注册成功");
                    //注册成功跳转到注册成功的界面
                    request.getRequestDispatcher("pages/user/regist_success.html").forward(request, response);
                } else {
                    System.out.println("注册失败");
                    request.getRequestDispatcher("pages/user/regist.html").forward(request, response);
                }
            }
        } else {
            //验证码错误
            System.out.println("验证码错误");
            //错误后跳转到注册界面
            request.getRequestDispatcher("pages/user/regist.html").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
