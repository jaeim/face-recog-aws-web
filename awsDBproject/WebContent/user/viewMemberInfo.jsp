<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="scripts/jquery-1.12.4.min.js"></script>
<script>	
//	function closeInfo() {
//		alert("닫기");
		// $("div#divForMemberInfo").empty();
	//}

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

</head>
<div id="divForMemberInfo">
	<!-- Profile Image -->
	<div class="card card-primary card-outline">
		<div class="card-body box-profile">
			<div class="text-center">
				<img class="profile-user-img img-fluid img-circle"
					src="data:image/jpeg;base64,${member.image_encoded}"
					alt="User profile picture">
			</div>

			<h3 class="profile-username text-center">${member.member_name }</h3>

			<!-- <p class="text-muted text-center">Software Engineer</p> -->

			<ul class="list-group list-group-unbordered mb-3">
				<li class="list-group-item"><b>Id</b> <a class="float-right">${member.login_id }</a>
				</li>
				<li class="list-group-item"><b>Password</b> <a
					class="float-right">${member.password }</a></li>
			</ul>

			<div class="row">
				<div class="col-10"></div>
				<!-- /.col -->
				<div class="col-2">
					<button type="button" id="closeBtn"
						class="btn btn-primary btn-block" onclick="closeInfo();">닫기</button>
				</div>
				<!-- /.col -->
			</div>
		</div>
		<!-- /.card-body -->
	</div>
	<!-- /.card -->
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
</div>
</html>