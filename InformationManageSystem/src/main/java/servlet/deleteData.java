package servlet;

import Dao.FlyAshDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "deleteData", value = "/deleteData")
public class deleteData extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        FlyAshDao flyAshDao = new FlyAshDao();
        int delete = flyAshDao.delete(Integer.parseInt(id));
        response.sendRedirect("showData");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
