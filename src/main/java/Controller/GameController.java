package Controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GameController", value = "/GameController")
public class GameController extends HttpServlet {
    int randomNumber = (int) (Math.random() * 1000 + 1);
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        String randomNumber = req.getParameter("randomNumber");
        String userName = req.getParameter("username");
        String count = req.getParameter("count");
        int soBiMat = Integer.parseInt(randomNumber);
        int demSoLanDoan = Integer.parseInt(count);
        demSoLanDoan++;
        writer.print("<form action='gameServlet' method='post' style='text-align:center'>");
        writer.print("<h2>Nhập số dự đoán từ 1-1000</h2>");
        writer.print("<input type='text' name='randomNumber'value='" + soBiMat + "' style='display:none'>");
        writer.print("<input type='text' name='count'value='" + demSoLanDoan + "' style='display:none'>");
        writer.print("<input type='text' name='username'value='" + userName + "' style='display:none'>");
        writer.print("<input type='text' name='number'required pattern='[0-9]+'>");
        writer.print("<input type='submit' value='Đoán'>");
        writer.print("</form>");
    }
}
