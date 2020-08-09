<%@ page import="java.io.Console" %><%--
  Created by IntelliJ IDEA.
  User: 南宫燚滨
  Date: 2020/7/19
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
</head>
<body>
<form action="/Study/ServletController/form" method = "post">
    用户名：<input type="text" name="name"/><br/>用
    密码：<input type="password" name="pwd"/><br/>
    请选择性别：<br/>
    男<input type="radio" name="sex" value="male"/>
    女<input type="radio" name="sex" value="female"/><br/>
    请选择您的水果：<br/>
    苹果<input type="checkbox" name="fruit" value="apple"/>
    香蕉<input type="checkbox" name="fruit" value="banana"/>
    橘子<input type="checkbox" name="fruit" value="orange"/><br/>
    <input type="submit">
    <input type="reset">
</form>
</body>
</html>
