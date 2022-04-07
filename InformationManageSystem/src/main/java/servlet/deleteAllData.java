package servlet;

import Dao.FlyAshDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "deleteAllData", value = "/deleteAllData")
public class deleteAllData extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ids = request.getParameter("ids");
        PrintWriter writer = response.getWriter();
        int[] delids = getArr(ids);
        FlyAshDao flyAshDao = new FlyAshDao();
        flyAshDao.deleteIds(delids);
        response.sendRedirect("/showData");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    private int[] getArr(String arr) {
        String[] split = arr.split(",");
        int[] res = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            res[i] = Integer.parseInt(split[i]);
        }
        return res;
    }
}
