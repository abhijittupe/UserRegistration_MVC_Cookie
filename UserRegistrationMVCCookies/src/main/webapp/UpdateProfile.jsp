<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<%
String data=(String)request.getAttribute("msg");
String fname=(String)request.getAttribute("fname");

out.println("<h1>This session belongs to "+fname+"<br><br>");
out.println(data+"</h1><br><br>");

%>

<a href="view">View Profile</a>
<a href="logout">Logout</a>
</center>

</body>
</html>