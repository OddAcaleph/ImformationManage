package servlet;

import Dao.FlyAshDao;
import domain.FlyAsh;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "updateData", value = "/updateData")
public class updateData extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();
        int updateID = (int)session.getAttribute("updateID");
        FlyAsh updatefa = (FlyAsh) session.getAttribute("updatefa");
        String name = updatefa.getName();
        String type = updatefa.getName();
        Date getDate = updatefa.getGetDate();
        String origin = updatefa.getOrigin();
        String remark = updatefa.getRemark();
        name = request.getParameter("name") == null ? name : request.getParameter("name");
        type = request.getParameter("type") == null ? type : request.getParameter("type");
        String Date = request.getParameter("getDate");
        String[] split = Date.split("-");
        try {
            if (Date != null) {
                getDate = new Date(Integer.parseInt(split[0]) - 1900, Integer.parseInt(split[1]) - 1, Integer.parseInt(split[2]));
            }
        } catch (Exception e) {
            e.printStackTrace();
            writer.println("Date input error!");
        }
        origin = request.getParameter("origin") == null ? origin : request.getParameter("origin");
        remark = request.getParameter("remark") == null ? remark : request.getParameter("remark");
        FlyAsh flyAsh = new FlyAsh(0, name, type, getDate, origin, remark);
        FlyAshDao flyAshDao = new FlyAshDao();
        try {
            flyAshDao.updata(updateID, flyAsh);
        }catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("showData");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
