package am.basic.web.controller;

import javax.script.ScriptContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String name = request.getParameter("tbb");
        PrintWriter printWriter = response.getWriter();
        printWriter.println("i am servlet");
        printWriter.println("hello " + name);
    }


}
