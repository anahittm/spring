<%@ page import="am.basic.web.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 26-Dec-19
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% User user = (User) session.getAttribute("user"); %>
<H1><%=user.getUsername()%></H1>
<H3><%=user.getName()%></H3>
<H4> <%   response.getWriter().println(user.getSurname()); %></H4>

</body>
</html>
