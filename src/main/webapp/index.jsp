<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 26-Dec-19
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    if(request.getAttribute("abcd") != null){
        response.getWriter().print(request.getAttribute("abcd"));
    }
%>
<form method="post" action="/login">
    Username :  <input type="text" name="username"><br/>
    Password :  <input type="password" name="pass"><br/>
    <input type="Submit" name="Sign in">
</form>
<a href="/register.html">sign up</a>
</body>
</html>
