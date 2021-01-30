<%--
  Created by IntelliJ IDEA.
  User: wangmengyang
  Date: 2021/1/25
  Time: 2:19 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>My JSP  starting page</title>
</head>
<body >
<%--<form action="/web-demo-maven/registerServlet"method="post" style="padding-top:-700px;">--%>
<%--    输入姓名:<input name="name" type="text" autocomplete="off"><br><br>--%>
<%--    输入密码:<input name="password" type="password"><br><br>--%>
<%--    输入id:<input name="id" type="text" autocomplete="off"><br><br>--%>
<%--    <input type="reset" value="重置">--%>
<%--    <input type="submit"value="注册">--%>
<%--</form>--%>

<form action="/registerServlet"method="post" style="padding-top:-700px;">
    输入姓名:<input name="name" type="text" autocomplete="off"><br><br>
    输入密码:<input name="password" type="password"><br><br>
    输入id:<input name="id" type="text" autocomplete="off"><br><br>
    <input type="reset" value="重置">
    <input type="submit"value="注册">
</form>
</body>
</html>
