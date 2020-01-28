package am.basic.web.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlet1 extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String id = req.getParameter("realname");
        String password = req.getParameter("mypassword");
        // Returns the value of a request parameter as a String, or null if the parameter does not exist.
        PrintWriter printWriter = res.getWriter();
        printWriter.println("id: " +  id);
        printWriter.println("password: " +  password);
    }
}
