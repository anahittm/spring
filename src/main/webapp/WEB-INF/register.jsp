<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 27-Dec-19
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    if(request.getAttribute("ab") != null){
        response.getWriter().print(request.getAttribute("ab"));
    }
%>
<form method="post" action="/register">
    Username :  <input type="text" name="username"><br/>
    Password :  <input type="password" name="pass"><br/>
    Name :  <input type="text" name="name"><br/>
    Surname :  <input type="text" name="surname"><br/>
    Age :  <input type="text" name="age"><br/>
    <input type="Submit" name="Sign up">
</form>

</body>
</html>
