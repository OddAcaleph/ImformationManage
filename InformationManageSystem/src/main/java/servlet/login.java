package servlet;

import Dao.UserDao;
import domain.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Objects;

@WebServlet(name = "login", value = "/login")
public class login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();
        String code = (String) session.getAttribute("verifyCode");
        String checkcode = request.getParameter("checkcode");
        if(!code.equals(checkcode)) {
            writer.println("<h1 style=\"text-align: center\">Verify Code Error!</h1>");
        }
        String name = request.getParameter("name");
        String psw = request.getParameter("password");
        User user = new User();
        UserDao userDao = new UserDao();
        user.setUsername(name);
        user.setPassword(psw);
        User login = userDao.login(user);
        response.setContentType("text/html");
        if (login != null) {
            writer.println("<h1 style=\"text-align: center\">Welcome!" + login.getUsername() + "</h1>");
            response.sendRedirect("/showData");
        }else{
            writer.println("<h1 style=\"text-align: center\">Login Failed!</h1>");
        }
        writer.println("<div style=\"text-align: center\"><a href=\"/login.jsp\">Back</a></div>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
