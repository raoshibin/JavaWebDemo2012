package servlet;

import beans.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author 饶世斌
 * @Date 2021/3/5 18:31
 * @Version 1.0
 * @describe
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    //创建全局的未始化的全局User的ArrayList集合
    List<User> users = null;
    //ServletContext官方叫servlet上下文。服务器会为每一个工程创建一个对象，这个对象就是ServletContext对象。
    // 这个对象全局唯一，而且工程内部的所有servlet都共享这个对象。所以叫全局应用程序共享对象
    // 创建一个全局的ServletContent全局应用程序共享对象,用于共享程序对象
    //servletContext是一个域对象
    //以键值对的方式存储
    //域对象是服务器在内存上创建的存储空间，用于在不同动态资源（servlet）之间传递与共享数据。
    //作用
    //1.是一个域对象
    //2.可以读取全局配置参数
    //3.可以搜索当前工程目录下面的资源文件
    //4.可以获取当前工程名字（了解）

    //  servletContext读取全局参数核心方法
    //getServletContext().getInitParameter(name);//根据指定的参数名获取参数值
    //getServletContext().getInitParameterNames();//获取所有参数名称列表

    ServletContext context = null;

    /**
     * 初始化方法
     *
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        //实例化User集合
        users = new ArrayList<>();
        //模拟数据库
        users.add(new User("admin", "123", null, 0));
        users.add(new User("user1", "456", null, 0));
        users.add(new User("user2", "789", null, 0));
        users.add(new User("user3", "111", null, 0));
        //取出ServletContent，设置他的totalCount值为0
        context = config.getServletContext(); //取出ServletContent
        System.out.println("content：" + context);
        context.setAttribute("totalCount", 0); //设置他的totalCount值为0
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //getParameter 通过写在input当中的name属性值 获取到对应的value值
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //创建User对象
        User user = new User();
        //把页面传过来的用户名和密码传进User对象
        user.setUsername(username);
        user.setPassword(password);
        //响应中文乱码处理
        response.setContentType("text/html;charset=utf-8");
        //获取响应当中的字符输出流并向客户端输出字符串
        PrintWriter writer = response.getWriter();
        //判断页面请求的数据的用户名和密码是否跟模拟的数据里面的值是否对的，然后做相应的回应
        if (users.contains(user)) {
            writer.write("<h1>" + username + "登陆成功</h1>");
            //当用户登陆成功后，在浏览器页面上提示用户，您是第几个登陆成功的用户，（使用ServletContext）
            context.setAttribute("totalCount", (int) context.getAttribute("totalCount") + 1);
            writer.write("<h1>您是第" + context.getAttribute("totalCount") + "个登陆的用户</h1>");
            //扩展：弄一个集合，模拟数据库，登录在集合中校验。用户登录成功后，
            //获取到用户上次的登录时间(如果之前没有登录，就不显示时间)，该用户第几次登录。
            //遍历用户集合
            for (int i = 0; i < users.size(); i++) {
                //判断用户是否存在且相同
                if (users.get(i).equals(user)) {
                    user = users.get(i);
                    //存储登陆次数 每次登陆成功加1
                    user.setLoginCount(user.getLoginCount() + 1);
                    writer.write("<h1>您是第" + user.getLoginCount() + "次登陆</h1>");
                    if (user.getLastLoginDate() != null) {
                        writer.write("<h1>您上次登陆时间：" + user.getLastLoginDate() + "</h1>");
                    }
                    //最后登陆时间
                    user.setLastLoginDate(new Date());
                }
            }
        }else{
            writer.write("<h1>用户名或密码错误</h1>");
        }
    }


}
