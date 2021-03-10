import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author 饶世斌
 * @Date 2021/3/8 11:26
 * @Version 1.0
 * @describe
 */
@WebServlet(name = "Demo01Servlet",urlPatterns = "/demo01.do")
public class Demo01Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取办事材料
        String username = request.getParameter("username");
        System.out.println("在 Servlet1（柜台 1）中查看参数（材料）："+username);
        //在域对象中添加一个共享的数据
        request.setAttribute("key1","柜台1的章");
        //把材料转发给demo02.do
        request.getRequestDispatcher("/demo02.do").forward(request,response);
    }
}
