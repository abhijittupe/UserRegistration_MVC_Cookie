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
<h2>
<%
	String data=(String) request.getAttribute("msg");
	out.println(data);
%>
</h2>
<jsp:include page="index.html"></jsp:include>
</center>
</body>
</html>