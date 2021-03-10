import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author 饶世斌
 * @Date 2021/3/8 15:01
 * @Version 1.0
 * @describe
 */
@WebServlet(name = "ResponseIOServlet",urlPatterns = "/text.do")
public class ResponseIOServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //响应的乱码解决
        //方案一
        response.setCharacterEncoding("UTF-8");
        //通过响应头，设置浏览器也使用UTF-8
        response.setHeader("Content-Type","text/html;charset=UTF-8");
        //方案二：（推荐）
        //他会同时设置服务器和客户端都使用UTF-8字符集编码
        //该方法一定要在获取流对象之前使用才有效
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write("响应的字符串内容");


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
