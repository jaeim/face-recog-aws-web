<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>
function send(){
	form.submit();
}
</script>
</head>
<body>
<form name="form" method="POST" action="<c:url value='/user/login' />">
<input type="text" name="login_id"/>
<input type="password" name="password"/>
<input type="button" value="����" onClick="send()"/>
</form>
</body>
</html>