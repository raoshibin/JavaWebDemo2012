package com.shop.servlet;

import com.shop.bean.User;
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
 * @Date 2021/3/9 21:52
 * @Version 1.0
 * @describe 登陆
 */
@WebServlet(name = "LoginServlet",urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户请求的登陆的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        // 调用 userService.login()登录处理业务
        User loginUser = userService.login(user);
        // 如果等于null,说明登录失败
        if (loginUser == null) {
            //   跳回登录页面
            request.getRequestDispatcher("pages/user/login.html").forward(request, response);
        } else {
            // 登录成功
            //跳到成功页面login_success.html
            request.getRequestDispatcher("pages/user/login_success.html").forward(request, response);
        }


    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
