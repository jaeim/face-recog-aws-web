<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%request.setCharacterEncoding("UTF-8"); %> 
<%@page import="java.util.*" %>    
<%@page import="model.*, controller. *" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
Hi, ${member.login_id }!
This is your INFO.

<table>
	<tr>
		<td>ID</td>
		<td>${meber.login_id }</td>
	</tr>
	<tr>
		<td>PASSWORD</td>
		<td>${member.password }</td>
	</tr>
	<tr>
		<td>NAME</td>
		<td>${member.name }</td>
	</tr>
	<tr>
		<td>IMAGE</td>
		<td>${member.image }</td>
	</tr>
</table>
</body>
</html>