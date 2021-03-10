import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author 饶世斌
 * @Date 2021/3/8 15:30
 * @Version 1.0
 * @describe
 */
@WebServlet(name = "ResponeServlet02",urlPatterns = "/resdemo.do")
public class ResponeServlet02 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // response.setStatus(302);
        //response.setHeader("Location","http://www.baidu.com");
        //response.setHeader("Location","/Demo0308/fileDownload.do");
        //推荐使用
        response.sendRedirect("http://www.baidu.com");
    }
}
