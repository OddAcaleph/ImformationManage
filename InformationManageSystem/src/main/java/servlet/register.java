package servlet;

import Dao.UserDao;
import domain.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "register", value = "/register")
public class register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        String code = (String) session.getAttribute("verifyCode");
        String checkcode = request.getParameter("checkcode");
        if(!code.equals(checkcode)) {
            writer.println("<h1 style=\"text-align: center\">Verify Code Error!</h1>");
            writer.println("<div style=\"text-align: center\"><a href=\"/register.html\">Back</a></div>");
            return;
        }
        String rootpassword = request.getParameter("root-password");
        if(!rootpassword.equals("267738")) {
            writer.println("<h1 style=\"text-align: center\">Root Password Error!</h1>");
            writer.println("<div style=\"text-align: center\"><a href=\"/register.html\">Back</a></div>");
            return;
        }
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        User user = new User();
        UserDao userDao = new UserDao();
        user.setUsername(name);
        user.setPassword(password);
        User exist = userDao.exist(user);
        if(exist != null) {
            writer.println("<h1 style=\"text-align: center\">Username has existed!</h1>");
            return;
        }
        int insertrow = userDao.register(user);
        if(insertrow != 0) {
            writer.println("<h1 style=\"text-align: center\">Register Succeed!</h1>");
        }else{
            writer.println("<h1 style=\"text-align: center\">Register Failed!</h1>");
        }
        writer.println("<div style=\"text-align: center\"><a href=\"/register.html\">Back</a></div>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
