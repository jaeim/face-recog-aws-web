<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Setting Info Update</title>
<script>
	function Modify(){
	
		if (form.RECOG_LV.value == "") {
		alert("모든 항목에 값을 입력하십시오.");
		form.RECOG_LV.focus();
		return false;
	}
		
		if (form.NOD_SEC.value == "") {
			alert("모든 항목에 값을 입력하십시오.");
			form.NOD_SEC.focus();
			return false;
		}
		
		if (form.DETEC_SEC.value == "") {
			alert("모든 항목에 값을 입력하십시오.");
			form.DETEC_SEC.focus();
			return false;
		}
		
		var x = form.RECOG_LV.value;
		var y = form.NOD_SEC.value;
		var z = form.DETEC_SEC.value;
		  if (isNaN(x) || isNaN(y) || isNaN(z)) {
		    alert("숫자를 입력하세요.");
		    return false;
		  }

		form.submit();
	}
</script>
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
<div id="div1" >
	<h4 id="title">UPDATE</h4>
	<form name="form" method="POST" action="<c:url value='/setting/update' />">
	<table id="table1">
		<tr>
			<td>사용자 인식 단계 </td>
			<td><input type="text" name="RECOG_LV" value="${stg.RECOG_LV}"> 단계</td>
		</tr>
		<tr>
			<td>태만 기준 시간 </td>
			<td><input type="text" name="NOD_SEC" value="${stg.NOD_SEC}"> 초</td>
		</tr>
		<tr>
			<td>화면 탐지 간격 </td>
			<td><input type="text" name="DETEC_SEC" value="${stg.DETEC_SEC}"> 초</td>
		</tr>
	</table>
	<br><br>
	<input type="button" value="수정 완료" onClick="Modify()" />
</form>
</div>
</body>
</html>