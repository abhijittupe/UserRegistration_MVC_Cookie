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
	UserBean bean=(UserBean)application.getAttribute("userbean");
	String fname=(String)request.getAttribute("fname");
	out.println("<h1>This session belongs to "+fname+"<h1><br><br>");
%>

<form action="update" method="post">
	First Name <input type="text" name="u_fname" value="<%= bean.getfName() %>"><br><br>
	Last Name <input type="text" name="u_lname" value="<%= bean.getlName() %>"><br><br>
	Mail Id <input type="text" name="u_mailid" value="<%= bean.getMailId() %>"><br><br>
	Phone Number <input type="text" name="u_phone" value="<%= bean.getPhoneNo() %>"><br><br>
	<input type="submit" value="Update Data">


</form>

</center>

</body>
</html>