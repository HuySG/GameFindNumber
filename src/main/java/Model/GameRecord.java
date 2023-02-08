package Model;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

@WebServlet(name = "GameRecord", value = "/GameRecord")
public class GameRecord extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        ArrayList<Player> listPlayer = new ArrayList<Player>();
        for (String user : Player.list) {
            String[] data = user.split("/");
            Player player = new Player();
            player.setUser(data[0]);
            player.setCount(Integer.parseInt(data[1]));
            listPlayer.add(player);
        }
        for (int i = 0; i < listPlayer.size() - 1; i++) {
            for (int j = i + 1; j < listPlayer.size(); j++) {
                if (listPlayer.get(i).getCount() > listPlayer.get(j).getCount()) {
                    Collections.swap(listPlayer, i, j);
                }
            }
        }
        writer.print("<div style='text-align:center'>");
        writer.print("<h1 style='color:red'>BẢNG XẾP HẠNG</h1>");
        writer.print("<table border='1' style='margin:auto'>");
        writer.print("<tr><th>Name</th><th>Record</th><tr>");
        for (Player player : listPlayer) {
            writer.print("<tr>");
            writer.print("<td>" + player.getUser() + "</td>");
            writer.print("<td style='text-align:center'>" + player.getCount() + "</td>");
            writer.print("<tr>");
        }
        writer.print("</table>");
        writer.print(
                "<form action='homeServlet' method='get' style='display:inline-block; margin: 10px'>");
        writer.print("<input type='submit' value='Home'>");
        writer.print("</form>");
        writer.print("</div>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
