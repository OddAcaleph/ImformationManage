package servlet;

import Dao.FlyAshDao;
import domain.FlyAsh;
import org.springframework.dao.DataAccessException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "insertData", value = "/insertData")
public class insertData extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String Date = request.getParameter("getDate");
        String[] split = Date.split("-");
        String origin = request.getParameter("origin");
        String remark = request.getParameter("remark");
        Date getDate = null;
        try {
            getDate = new Date(Integer.parseInt(split[0]) - 1900, Integer.parseInt(split[1]) - 1, Integer.parseInt(split[2]));
            FlyAsh flyAsh = new FlyAsh(0, name, type, getDate, origin, remark);
            FlyAshDao flyAshDao = new FlyAshDao();
            int insert = flyAshDao.insert(flyAsh);
            writer.println(insert > 0 ? "<h1 style=\"text-align: center\">Inserted succeed!</h1>" : "<h1 style=\"text-align: center\">Insert failed!</h1>");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            writer.println("<h1 style=\"text-align: center\">Date input error!<h1>");
        } catch (DataAccessException e1) {
            e1.printStackTrace();
            writer.println("<h1 style=\"text-align: center\">Message input error!</h1>");
        } finally {
            writer.println("<div style=\"text-align: center\"><a href=\"/showData\">Back</a></div>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
