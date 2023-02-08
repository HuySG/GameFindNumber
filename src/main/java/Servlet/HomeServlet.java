package Servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HomeServlet", value = "/HomeServlet")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        int randomNumber = (int) (Math.random() * 1000 + 1);
        int count = 0;
        writer.print("<form action='gamectroller' method='post' style='text-align:center'>");
        writer.print("<h1 style='color:red'>GAME ĐOÁN SỐ BÍ MẬT</h1>");
        writer.print("<h2>Vui lòng nhập tên để tham gia<h2>");
        writer.print("<input type='text' name='randomNumber'value='" + randomNumber + "'style='display:none'>");
        writer.print("<input type='text' name='count'value='" + count + "' style='display:none'>");
        writer.print("<input type='text' name='username'>");
        writer.print("<input type='submit' value='Bắt đầu'>");
        writer.print("</form>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
