package am.basic.web.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class Servlet2 extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       /* String login = req.getParameter("login");
        String password = req.getParameter("password");
        PrintWriter printWriter = res.getWriter();
        printWriter.println("login: " +  login);
        printWriter.println("password: " +  password);*/
        res.sendRedirect("/pages/home.html");
    }
}
