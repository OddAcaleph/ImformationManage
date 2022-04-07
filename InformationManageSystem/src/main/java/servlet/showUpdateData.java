package servlet;

import Dao.FlyAshDao;
import domain.FlyAsh;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "showUpdateData", value = "/showUpdateData")
public class showUpdateData extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        FlyAshDao flyAshDao = new FlyAshDao();
        FlyAsh flyAsh = flyAshDao.idSearch(Integer.parseInt(id));
        HttpSession session = request.getSession();
        session.setAttribute("updatefa", flyAsh);
        session.setAttribute("updateID", Integer.parseInt(id));
        response.sendRedirect("update.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
