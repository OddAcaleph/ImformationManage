package servlet;

import Util.GraphicUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(name = "verifycode", value = "/verifycode")
public class verifycode extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        final int width = 200;
        final int height = 50;
        final String ImgType = "jpeg";
        final OutputStream outputStream = response.getOutputStream();
        String s = GraphicUtils.create(width, height, ImgType, outputStream);
        session.setAttribute("verifyCode", s);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
