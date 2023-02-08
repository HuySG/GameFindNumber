package Model;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "Player", value = "/Player")
public class Player extends HttpServlet {
    public static ArrayList<String> list = new ArrayList<String>();
    private String user;
    private int count;

    public Player() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String xuat() {
        String out = new StringBuilder().append("||" + getUser() + "||").append(getCount() + "||").toString();
        return out;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        String userName = req.getParameter("username");
        String count = req.getParameter("count");
        list.add(userName + "/" + count);
        writer.print("<h2 style='color:green; text-align:center'>Chúc mừng bạn đã đoán đúng số bí mật !!!!</h2>");
        writer.print("<h4 style='text-align:center'>Vui lòng chọn Home để quay về trang chủ</h4>");
        writer.print("<h4 style='text-align:center'>hoặc Record để xem bảng xếp hạng</h4>");
        writer.print("<div style='text-align:center'>");
        writer.print(
                "<form action='homeServlet' method='get' style='display:inline-block; margin: 10px'>");
        writer.print("<input type='submit' value='Home'>");
        writer.print("</form>");
        writer.print(
                "<form action='gameRecord' method='get' style='display:inline-block; margin: 10px'>");
        writer.print("<input type='submit' value='Record'>");
        writer.print("</form>");
        writer.print("<div>");
    }
}
