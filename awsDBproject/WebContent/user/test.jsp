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
<link href=”bootstrap/css/bootstrap.min.css” rel=”stylesheet” type=”text/css” />
<script type=”text/javascript” src=”bootstrap/js/bootstrap.min.js”></script>
</head>
<body>


<form name="form" method="POST" action="<c:url value='/test/view' />">
<input type="text" name="login_id"/>
<input type="button" value="전송" onClick="send()"/>
</form>

<a href="<c:url value= '/setting/view'>
	</c:url>" id="goSetting_btn">설정 정보</a>

</body>
</html>