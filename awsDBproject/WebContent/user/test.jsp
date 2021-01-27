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

function moveSetting() {
	var ctx = "${pageContext.request.contextPath}"
	location.href = ctx + "/setting/view";
}

</script>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>

<!-- sd-admin -->

 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    
    <!-- Custom fonts for this template-->
    <link href="${pageContext.request.contextPath}/startbootstrap-sb-admin-2-gh-pages/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="${pageContext.request.contextPath}/startbootstrap-sb-admin-2-gh-pages/css/sb-admin-2.min.css" rel="stylesheet">


<!-- Bootstrap core JavaScript-->
<script src="http://code.jquery.com/jquery-latest.js"></script>
<!-- 외부 js 파일 가져올 시, context path 사용해야함...? -->
    <script src="${pageContext.request.contextPath}/startbootstrap-sb-admin-2-gh-pages/vendor/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/startbootstrap-sb-admin-2-gh-pages/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="${pageContext.request.contextPath}/startbootstrap-sb-admin-2-gh-pages/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="${pageContext.request.contextPath}/startbootstrap-sb-admin-2-gh-pages/js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="${pageContext.request.contextPath}/startbootstrap-sb-admin-2-gh-pages/vendor/chart.js/Chart.min.js"></script>

    <!-- Page level custom scripts -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/startbootstrap-sb-admin-2-gh-pages/js/demo/chart-area-demo.js"></script>
    <script type="text/javascript" src="<c:url value="/startbootstrap-sb-admin-2-gh-pages/js/demo/chart-pie-demo.js"/>"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/startbootstrap-sb-admin-2-gh-pages/js/demo/chart-bar-demo.js"></script>

</head>


<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <a class="navbar-brand" href="#">메뉴</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="#">
        	Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<c:url value= '/setting/view'></c:url>">Settings</a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
      </li>
    </ul>
  </div>
</nav>

<form name="form" method="POST" action="<c:url value='/test/view' />">
<input type="text" name="login_id"/>
<input type="button" value="전송" onClick="send()"/>
</form>

<button type="button" class="btn btn-primary" onclick="moveSetting()">설정 정보</button>


<a href="<c:url value= '/setting/view'>
	</c:url>" id="goSetting_btn">설정 정보</a>
	
	 <!-- Illustrations -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">Illustrations</h6>
		</div>
		<div class="card-body">
			<div class="text-center">
				<img class="img-fluid px-3 px-sm-4 mt-3 mb-4" style="width: 25rem;"
					src="${pageContext.request.contextPath}/startbootstrap-sb-admin-2-gh-pages/img/undraw_posting_photo.svg" alt="">
			</div>
			<p>
				Add some quality, svg illustrations to your project courtesy of <a
					target="_blank" rel="nofollow" href="https://undraw.co/">unDraw</a>,
				a constantly updated collection of beautiful svg images that you can
				use completely free and without attribution!
			</p>
			<a target="_blank" rel="nofollow" href="https://undraw.co/">Browse
				Illustrations on unDraw &rarr;</a>
		</div>
	</div>
	<!-- 차트 부분 -->
	<div class="row">
		<div class="col-xl-8 col-lg-7">

			<!-- Area Chart -->
			<div class="card shadow mb-4">
				<div class="card-header py-3">
					<h6 class="m-0 font-weight-bold text-primary">Area Chart</h6>
				</div>
				<div class="card-body">
					<div class="chart-area">
						<canvas id="myAreaChart"></canvas>
					</div>
					<hr>
					Styling for the area chart can be found in the
					<code>/js/demo/chart-area-demo.js</code>
					file.
				</div>
			</div>

			<!-- Bar Chart -->
			<div class="card shadow mb-4">
				<div class="card-header py-3">
					<h6 class="m-0 font-weight-bold text-primary">Bar Chart</h6>
				</div>
				<div class="card-body">
					<div class="chart-bar">
						<canvas id="myBarChart"></canvas>
					</div>
					<hr>
					Styling for the bar chart can be found in the
					<code>/js/demo/chart-bar-demo.js</code>
					file.
				</div>
			</div>

		</div>

		<!-- Donut Chart -->
		<div class="col-xl-4 col-lg-5">
			<div class="card shadow mb-4">
				<!-- Card Header - Dropdown -->
				<div class="card-header py-3">
					<h6 class="m-0 font-weight-bold text-primary">Donut Chart</h6>
				</div>
				<!-- Card Body -->
				<div class="card-body">
					<div class="chart-pie pt-4">
						<canvas id="myPieChart"></canvas>
					</div>
					<hr>
					Styling for the donut chart can be found in the
					<code>/js/demo/chart-pie-demo.js</code>
					file.
				</div>
			</div>
		</div>
	</div>


</body>
</html>