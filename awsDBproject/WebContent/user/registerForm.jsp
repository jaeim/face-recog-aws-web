<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>    
<%@page import="model.*, controller. *" %>
<%@page import="org.json.*" %>
<%@page import="java.io.*" %>
<%@page import="javax.imageio.ImageIO" %>
<%@page import="java.awt.image.BufferedImage" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>홈 화면</title>

<!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/AdminLTE/plugins/fontawesome-free/css/all.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/AdminLTE/dist/css/adminlte.min.css">
  <!-- DataTables -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/AdminLTE/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/AdminLTE/plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/AdminLTE/plugins/datatables-buttons/css/buttons.bootstrap4.min.css">
  
<!-- bootstrap -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">  
</head>
<body class="hold-transition sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

 <!-- Navbar -->
<nav class="navbar navbar-expand-md navbar-light bg-light">
  <a class="navbar-brand" href="#">Navbar</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="#">메인 화면 <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">내 정보</a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#">Disabled</a>
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
            <h1>근무자 등록</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Main Page</a></li>
              <li class="breadcrumb-item active">태만탐지 화면내역</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>
	<div class="container-fluid" style="height: 500px; width: 500px;">
	    <!-- /.row -->
	        <div class="row">
	          <div class="col-12">
	            <div class="card">
	              <!-- /.card-header -->
	              <div class="card-body table-responsive p-0" >
	                    <div class="card-body">
	                    <form method="post" enctype="multipart/form-data" action="<c:url value='/user/register' />">
	                    	<div class="form-group">
	                    		<div id='preview' >
    							</div>
    						</div>
	                   		<div class="form-group">
	                    		<input type='file' id='upload' name='upload'>
							</div>
                			<div class="form-group">
                  				<input class="form-control" placeholder="이름" name="name">
                			</div>
                			<div class="form-group">
                  				<input class="form-control" placeholder="아이디" name="id">
                			</div>
                			<div class="form-group">
                  				<input class="form-control" placeholder="비밀번호" name="password">
                			</div>
                		
                			<button type="submit" class="btn btn-primary">Submit</button>
                		</form>
                		</div> 
	              </div>
	              <!-- /.card-body -->
	            </div>
	            <!-- /.card -->
	          </div>
	        </div>
	        <!-- row -->
	       </div>
 <!-- content-fluid -->
</div>

<footer class="main-footer">
    <div class="float-right d-none d-sm-block">
      <b>Version</b> 3.1.0-rc
    </div>
    <strong>Copyright &copy; 2014-2021 <a href="https://adminlte.io">AdminLTE.io</a>.</strong> All rights reserved.
 </footer>
  <!-- /.content-wrapper -->

<!-- REQUIRED SCRIPTS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js" integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js" integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG" crossorigin="anonymous"></script>

<!-- jQuery -->
<script src="${pageContext.request.contextPath}/AdminLTE/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="${pageContext.request.contextPath}/AdminLTE/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath}/AdminLTE/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="${pageContext.request.contextPath}/AdminLTE/dist/js/demo.js"></script>
</body>
<script>
var upload = document.querySelector('#upload');
var preview = document.querySelector('#preview');

upload.addEventListener('change',function (e) {
    var get_file = e.target.files;

    var image = document.createElement('img');

    /* FileReader 객체 생성 */
    var reader = new FileReader();

    /* reader 시작시 함수 구현 */
    reader.onload = (function (aImg) {
        console.log(1);

        return function (e) {
            console.log(3);
            /* base64 인코딩 된 스트링 데이터 */
            aImg.src = e.target.result
        }
    })(image)

    if(get_file){
        /* 
            get_file[0] 을 읽어서 read 행위가 종료되면 loadend 이벤트가 트리거 되고 
            onload 에 설정했던 return 으로 넘어간다.
            이와 함게 base64 인코딩 된 스트링 데이터가 result 속성에 담겨진다.
        */
        reader.readAsDataURL(get_file[0]);
        console.log(2);
    }
	image.style.cssText = 'width: auto; height: auto; max-width: 200px; max-height: 200px;'
    preview.appendChild(image);
})
</script>


</html>