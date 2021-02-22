<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>홈 화면</title>
<script src="scripts/jquery-1.12.4.min.js"></script>
<script>
	function settingModify(){
	
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
		    alert("숫자를 입력하세요!");
		    return false;
		  }

		form.submit();
	}
	function viewWorkingHistory(id) {
		// alert(id);
		$.ajax ({
			url : '${pageContext.request.contextPath}/user/workingHistory',
			type : 'POST',
			data : jQuery.param({ _id : id }) ,
		    contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
			dataType : "text",
			// contentType: false,
			processData: false,
			cache : false,
			error:function(request,status,error){
			        alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
			        
			}

		}).done(function(result) {
			console.log("결과확인");
			var html = jQuery('<div>').html(result);
			var contents = html.find("div#divForWorkingHistory").html();
			$("#workingHistoryContainer").html(contents);
			// 초 -> 시간 변환
			$('.totalTime').each( function() {
				var seconds = $(this).text();
				seconds = Number(seconds);
				var hour = parseInt(seconds/3600);
				var min = parseInt((seconds%3600)/60);
				var sec = seconds%60;
				
				hour = addZero(hour);
				min = addZero(min);
				sec = addZero(sec);
				
				$(this).html(hour + ":" + min + ":" + sec);	
			});		
			$('.workTime').each( function() {
				var seconds = $(this).text();
				seconds = Number(seconds);
				var hour = parseInt(seconds/3600);
				var min = parseInt((seconds%3600)/60);
				var sec = seconds%60;
				
				hour = addZero(hour);
				min = addZero(min);
				sec = addZero(sec);
				// $(this).html(hour + ":" + min + ":" + sec);
				$(this).text(hour + ":" + min + ":" + sec);
			});		
		}).fail(function (jqXHR, textStatus, errorThrown) { console.log("에러"); console.log(jqXHR); console.log(textStatus); console.log(errorThrown); });
	}
	
	function addZero(num) {
		  num < 10 ? num = `0` + num : num;
		  return num;
		}
	
	function viewMemberInfo(id) {
		// alert(id);
		$.ajax ({
			url : '${pageContext.request.contextPath}/user/view',
			type : 'POST',
			data : jQuery.param({ login_id : id }) ,
		    contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
			dataType : "text",
			// contentType: false,
			processData: false,
			cache : false,
			error:function(request,status,error){
			        alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
			        
			}

		}).done(function(result) {
			console.log("결과확인");
			var html = jQuery('<div>').html(result);
			var contents = html.find("div#divForMemberInfo").html();
			$("#memberInfoContainer").html(contents);
		}).fail(function (jqXHR, textStatus, errorThrown) { console.log("에러"); console.log(jqXHR); console.log(textStatus); console.log(errorThrown); });
	}
	
	function test() {
		alert('테스트!');
	}
	
	function closeInfo() {
		//alert("닫기");
		$("#memberInfoContainer").empty();
	}
	
	function closeWorkingHistory() {
		$("#workingHistoryContainer").empty();
	}
	
	$(document).ready(function () {
	    var seconds = $('#totalTime').text();
	    var hour = parseInt(seconds/3600);
		var min = parseInt((seconds%3600)/60);
		var sec = seconds%60;
		
		document.getElementById("totalTime").innerHTML = hour + ":" + min + ":" + sec
	    //$('#totalTime').val(total);
	});
	
</script>

<!-- Google Font: Source Sans Pro -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/AdminLTE/plugins/fontawesome-free/css/all.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/AdminLTE/dist/css/adminlte.min.css">
<!-- DataTables -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/AdminLTE/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/AdminLTE/plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/AdminLTE/plugins/datatables-buttons/css/buttons.bootstrap4.min.css">

<!-- bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">

</head>
<body class="hold-transition sidebar-mini">
	<!-- Site wrapper -->
	<div class="wrapper">

		<!-- Navbar -->
		<nav class="navbar navbar-expand-md navbar-light bg-light">
			<a class="navbar-brand" href="#">Navbar</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNav" aria-controls="navbarNav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item active"><a class="nav-link" href="#">메인
							화면 <span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="<c:url value='/user/updateForm' />">내 정보</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#">Disabled</a>
					</li>
				</ul>
			</div>
		</nav>
		<!-- /.navbar -->



		<!-- Content Wrapper. Contains page content -->
		<div class="wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1>Main Page</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active">Main Page</li>
							</ol>
						</div>
					</div>
				</div>
				<!-- /.container-fluid -->
			</section>

			<div class="container-fluid">
				<!-- /.row -->
				<div class="row">
					<div class="col-12">
						<div class="card">
							<div class="card-header">
								<h3 class="card-title">근태관리 프로그램 설정</h3>


							</div>
							<!-- /.card-header -->
							<div class="card-body" style="height: 285px;">
								<form name="form" method="post"
									action="<c:url value='/setting/update'>
	                	</c:url>">
									<div class="input-group mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-default">사용자
												인식 단계 </span>
										</div>
										<input type="text" class="form-control" aria-label="Default"
											aria-describedby="inputGroup-sizing-default" name="RECOG_LV"
											value="${stg.RECOG_LV}">
									</div>
									<div class="input-group mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-default">태만
												기준 시간 (초) </span>
										</div>
										<input type="text" class="form-control" aria-label="Default"
											aria-describedby="inputGroup-sizing-default" name="NOD_SEC"
											value="${stg.NOD_SEC}">
									</div>
									<div class="input-group mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-default">화면
												탐지 간격 (초) </span>
										</div>
										<input type="text" class="form-control" aria-label="Default"
											aria-describedby="inputGroup-sizing-default" name="DETEC_SEC"
											value="${stg.DETEC_SEC}">
									</div>
									<div class="input-group mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-default">동영상
												처리 속도 (초) </span>
										</div>
										<input type="text" class="form-control" aria-label="Default"
											aria-describedby="inputGroup-sizing-default" name="VID_INTVL"
											value="${stg.VID_INTVL}">
									</div>
									<div class="row">
										<div class="col-10"></div>
										<!-- /.col -->
										<div class="col-2">
											<button type="button" class="btn btn-primary btn-block"
												onclick="settingModify();">수정하기</button>
										</div>
										<!-- /.col -->
									</div>
								</form>
							</div>
							<!-- /.card-body -->
						</div>
						<!-- /.card -->
					</div>
				</div>
				<!-- row -->
				
				<div class="row">
					<div class="col-10"></div>
					<!-- /.col -->
					<div class="col-2">
						<!--  <button type="button" class="btn btn-primary btn-block"
							onclick="settingModify();">근무자 등록</button> -->
					</div>
					<!-- /.col -->
				</div>
				
			</div>
			<br />



			<div class="container-fluid">
				<!-- /.row -->
				<div class="row">
					<div class="col-12">
						<div class="card">
							<div class="card-header">
							<div class="row">
								<div class="col-10">
								<h3 class="card-title">근무자 목록</h3>
								</div>
								
								<div class="col-2">
									<button type="button" class="btn btn-primary btn-block"
							onclick="location.href='${pageContext.request.contextPath}/user/registerForm'">근무자 등록</button>
								</div>
								</div>
								

								<div class="card-tools">
									<div class="input-group input-group-sm" style="width: 150px;">
										<!-- 검색어 입력창 삭제 -->
										<div class="input-group-append">
											<!-- 돋보기 아이콘 삭제 -->
										</div>
									</div>
								</div>
							</div>
							<!-- /.card-header -->
							<div class="card-body table-responsive p-0"
								style="height: 210px;">
								<table id="userList" class="table table-head-fixed text-nowrap">
									<thead>
										<tr>
											<th>#</th>
											<th>이름</th>
											<th>인식단계</th>
											<th>근무기록</th>
											<th>등록정보</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="member" items="${members}" varStatus="status">
											<tr>
												<td><c:out value='${status.count }' /></td>
												<td>${member.login_id }</td>
												<td>${stg.RECOG_LV }</td>
												<td>
													<button type="button" class="btn btn-light"
														onclick="viewWorkingHistory('${member._id }');">상세보기</button>
												</td>
												<td>
													<button type="button" class="btn btn-light"
														onclick="viewMemberInfo('${member.login_id }');">상세보기</button>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<!-- /.card-body -->
						</div>
						<!-- /.card -->
					</div>
				</div>
				<!-- row -->
			</div>

			<br/>
			
			<div id="memberInfoContainer" class="container-fluid">
				<!-- container-fluid -->
			</div>

			<div id="workingHistoryContainer" class="container-fluid">
				<!-- container-fluid -->
			</div>
			
			<!-- content-fluid -->
		</div>

		<footer class="main-footer">
			<div class="float-right d-none d-sm-block">
				<b>Version</b> 3.1.0-rc
			</div>
			<strong>Copyright &copy; 2014-2021 <a
				href="https://adminlte.io">AdminLTE.io</a>.
			</strong> All rights reserved.
		</footer>
		<!-- /.content-wrapper -->

		<!-- REQUIRED SCRIPTS -->
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
			crossorigin="anonymous"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js"
			integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi"
			crossorigin="anonymous"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js"
			integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG"
			crossorigin="anonymous"></script>

		<!-- jQuery -->
		<script
			src="${pageContext.request.contextPath}/AdminLTE/plugins/jquery/jquery.min.js"></script>
		<!-- Bootstrap 4 -->
		<script
			src="${pageContext.request.contextPath}/AdminLTE/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
		<!-- AdminLTE App -->
		<script
			src="${pageContext.request.contextPath}/AdminLTE/dist/js/adminlte.min.js"></script>
		<!-- AdminLTE for demo purposes -->
		<script
			src="${pageContext.request.contextPath}/AdminLTE/dist/js/demo.js"></script>
</body>
</html>