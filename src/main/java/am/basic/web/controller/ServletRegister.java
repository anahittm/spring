package am.basic.web.controller;

import am.basic.web.model.User;
import am.basic.web.repository.UserRepository;
import am.basic.web.repository.UserRepositoryIMPLJdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletRegister")
public class ServletRegister extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String username = request.getParameter("username");
        String password = request.getParameter("pass");
        int age = Integer.parseInt(request.getParameter("age"));
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        UserRepository userRepositor = new UserRepositoryIMPLJdbc();
        User user = new User();
        user.setAge(age);
        user.setName(name);
        user.setPassword(password);
        user.setSurname(surname);
        user.setUsername(username);

        try {
            if (user.getSurname() != null) {
                Cookie cookie = new Cookie("username", user.getUsername());
                cookie.setMaxAge(345678906);
                response.addCookie(cookie);
                session.setAttribute("user", user);
                response.sendRedirect("/secure/home.html");
                userRepositor.add( user );
            } else {
                request.setAttribute( "ab", "INVALID" );
                request.getRequestDispatcher( "/register.jsp" ).forward( request, response );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

