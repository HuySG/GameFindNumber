package Servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GameServlet", value = "/GameServlet")
public class GameServlet extends HttpServlet {
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
        int soBiMat = Integer.parseInt(randomNumber);
        String number = req.getParameter("number");
        int soDuocDoan = Integer.parseInt(number);
        if (soDuocDoan > soBiMat) {
            writer.print("<h2 style='color:red; text-align:center'>Số được nhập lớn hơn số bí mật</h2>");
            req.getRequestDispatcher("gamectroller").include(req,resp);
        } else if (soDuocDoan < soBiMat) {
            writer.print("<h2 style='color:red; text-align:center'>Số được nhập bé hơn số bí mật</h2>");
            req.getRequestDispatcher("gamectroller").include(req,resp);
        } else {
            req.getRequestDispatcher("/player").forward(req, resp);
        }
    }
}
