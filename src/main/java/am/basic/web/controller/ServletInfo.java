package am.basic.web.controller;

import am.basic.web.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletInfo")
public class ServletInfo extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie:cookies
             ) {
            System.out.println(cookie.getName() + "  " + cookie.getValue());
        }



        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        PrintWriter pw = response.getWriter();
        pw.println( "<html>" +
                "<body>" +
                "<H1>" +
                "<i>");
        pw.print("name= " + user.getName()+"  surname= "+ user.getSurname());
        pw.print("</i>" + "</H1>" + "</body>"+ "</HTML>" );




    }
}
