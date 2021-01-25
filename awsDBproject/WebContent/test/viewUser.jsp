<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<td>_id</td>
		<td>${member._id }</td>
	</tr>
	<tr>
		<td>login_id</td>
		<td>${member.login_id }</td>
	</tr>
	<tr>
		<td>password</td>
		<td>${member.password }</td>
	</tr>
	<tr>
		<td>name</td>
		<td>${member.member_name }</td>
	</tr>
	<tr>
		<td>image</td>
		<td><img src="data:image/jpeg;base64,${member.image_encoded}" width="200" height="300"></td>
	</tr>
</table>
</body>
</html>