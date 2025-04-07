<%@ page import="pack1.UserBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
UserBean bean=(UserBean)application.getAttribute("userbean");
out.println("<h1>Welcome"+bean.getfName());
%>

<a href="view">View Profile</a>
<a href="logout">Logout</a>
</body>
</html>