package priv.lyb.study.concurrent.javamultithreadinaction.one;

import org.springframework.boot.web.servlet.ServletComponentScan;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author LiuYingBo 2021/02/02 04:21
 */

@WebServlet("/ehco")
public class EchoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Thread thread = Thread.currentThread();
        String currentThreadName = thread.getName();
        System.out.println("EchoServlet ThreadName: " + currentThreadName);
    }
}
