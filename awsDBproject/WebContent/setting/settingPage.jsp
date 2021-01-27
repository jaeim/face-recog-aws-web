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
	#div1 {
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

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

</head>
<body>


<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <a class="navbar-brand" href="#">메뉴</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="<c:url value= '/user/test.jsp'></c:url>">
        	Home</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="#">Settings <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
      </li>
    </ul>
  </div>
</nav>

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

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
</body>
</html>