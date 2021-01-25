<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*, model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>setting Info Page</title>

<style>
	body {
	  margin: 0;
	  padding: 0;
	  font-family: 'NanumSquare', sans-serif !important;
	  display: flex;
	  flex-flow: column nowrap;
	  justify-content: center;
	  align-items: center;
	  overflow-x: hidden;  
	}
</style>

</head>
<body>
<div id="div1">
	<h4 id="title">Setting Info Page</h4>
	<table id="setting_table">
		<tr>
			<td>사용자 인식 단계 </td>
			<td>&nbsp;${stg.RECOG_LV} 단계</td>
		</tr>
		<tr>
			<td>태만 기준 시간 </td>
			<td>&nbsp;${stg.NOD_SEC} 초</td>
		</tr>
		<tr>
			<td>화면 탐지 간격 </td>
			<td>&nbsp;${stg.DETEC_SEC} 초</td>
		</tr>		
	</table>
</div>
<div id="div2">
	<a href="<c:url value= '/setting/update/form' >
	</c:url>" id="update_btn">수정하기</a>	
</div>
</body>
</html>