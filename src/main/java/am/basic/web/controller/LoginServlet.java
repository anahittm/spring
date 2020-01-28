package am.basic.web.controller;

import am.basic.web.model.User;
import am.basic.web.repository.UserRepository;
import am.basic.web.repository.UserRepositoryIMPLJdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {


    UserRepository userRepository = new UserRepositoryIMPLJdbc();

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       HttpSession session = request.getSession();

        String username = request.getParameter("username");
        String password = request.getParameter("pass");
        try {
          User user = userRepository.getByUsernamePassword(username, password);
            if (user != null) {
                Cookie cookie = new Cookie("username", user.getUsername());
                cookie.setMaxAge(345678906);
                response.addCookie(cookie);
                session.setAttribute("user", user);
                response.sendRedirect("/secure/home.html");

            } else {
               /* PrintWriter printWriter = response.getWriter();
                printWriter.println("login and password are incorrect");*/
               request.setAttribute("abcd", "incorrect input");
               request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
        } catch (SQLException e) {
                e.printStackTrace();
        }
    }
}
