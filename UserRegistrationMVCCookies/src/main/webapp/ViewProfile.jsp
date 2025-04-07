<%@ page import="pack1.UserBean"%>

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

	String fname=(String)request.getAttribute("fname");
	UserBean bean=(UserBean)application.getAttribute("userbean");
	out.println("This session belongs to "+fname+"<br><br>");
	out.println("<h2><u>Profile Details </u></h2>");
	String pwd=bean.getPassword();
	String s=pwd.substring(0,1)+"****"+pwd.substring(pwd.length()-1);
	out.println(bean.getUserName()+" "+s+bean.getfName()+" "+bean.getlName()+" "+bean.getMailId()+" "+bean.getPhoneNo()+"<br><br>");
%>
<a href="edit">Edit Profile</a><br><br>
<a href="logout">Logout</a><br><br>
</center>
</body>
</html>