package servlet;

import Dao.FlyAshDao;
import domain.FlyAsh;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "showData", value = "/showData")
public class showData extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FlyAshDao flyAshDao = new FlyAshDao();
        List<FlyAsh> flyAshes = flyAshDao.searchAll();
        HttpSession session = request.getSession();
        session.setAttribute("datas", flyAshes);
        response.sendRedirect("/showData.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
