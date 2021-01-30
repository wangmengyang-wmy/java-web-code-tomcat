<%--
  Created by IntelliJ IDEA.
  User: wangmengyang
  Date: 2021/1/25
  Time: 2:16 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>My JSP 'success.jsp' starting page</title>
</head>
<body>
<br>
<%--<a href="/web-demo-maven/showAllServlet">查看所有用户</a>--%>
<a href="/showAllServlet">查看所有用户</a>
</body>
</html>
