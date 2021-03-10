import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author 饶世斌
 * @Date 2021/3/8 9:55
 * @Version 1.0
 * @describe
 */
@WebServlet(name="RequestAPIServlet",urlPatterns = "/requestAPIServlet")
public class RequestAPIServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的资源路径 URI
        System.out.println("URI = "+req.getRequestURI());
        //2.获取请求的同意资源定位URL
        System.out.println("URL = "+req.getRequestURL());
        //3.获取客户端的ip地址
        System.out.println("客户端IP地址 = " +req.getRemoteHost());
        System.out.println("客户端getRemoteAddr = "+req.getRemoteAddr());
        //4.获取请求头
        System.out.println("请求头 = "+req.getHeader("Cookie"));
        //5.获取请求方式GET或者POST
        System.out.println("请求方式 = "+req.getMethod());
    }
}
