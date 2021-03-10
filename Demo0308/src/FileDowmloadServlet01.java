import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @Author 饶世斌
 * @Date 2021/3/8 14:28
 * @Version 1.0
 * @describe
 */
@WebServlet(name = "FileDowmloadServlet01",urlPatterns = "/fileDownload.do")
public class FileDowmloadServlet01 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //实现文件下载，获取到响应对象的字节输出流
        OutputStream outputStream = response.getOutputStream();
        //需要下载的文件
        File file=new File("E:\\a1\\295804.jpg");
        //通过相应 设置响应头，告诉浏览器，要下载文件
        response.setHeader("content-disposition","attachment;fileName="+new String("学习.jpg".getBytes("utf-8"),"ISO8859-1"));
        //把下载的文件放进输入流里
        InputStream inputStream=new FileInputStream(file);
        //使用字节流把下载的文件写入文件
        byte[] bytes=new byte[1024];
        int length=0;
        while ((length=inputStream.read(bytes))!=-1){
            outputStream.write(bytes);
            outputStream.flush();
        }
        //关闭字节流，输出流
        inputStream.close();
        outputStream.close();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
