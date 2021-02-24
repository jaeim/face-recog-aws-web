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
 <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/AdminLTE/plugins/fontawesome-free/css/all.min.css">
  <!-- Ekko Lightbox -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/AdminLTE/plugins/ekko-lightbox/ekko-lightbox.css">
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
        <a class="nav-link" href="<c:url value='/user/site-login' />">메인 화면 <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<c:url value='/user/updateForm' />">내 정보</a>
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
            <h1></h1>
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
	<div class="container-fluid">
	    <!-- /.row -->
	        <div class="row">
	          <div class="col-12">
	            <div class="card">
	              <div class="card-header">
	                <h3 class="card-title">태만탐지 화면내역</h3>
	
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
	              <div class="card-body table-responsive p-0" style="height: 500px;">
	                <table id="userList" class="table table-head-fixed text-nowrap">
	                  <thead>
	                    <tr>
	                      <th>#</th>
	                      <th>파일이름</th>
	                      <th>상세보기</th>
	                    </tr>
	                  </thead>
	                  <tbody>
	                    <c:forEach var="imageInfo" items="${imageInfoList}" varStatus="status" >
	                    	<c:set var="imageInfo" value="${imageInfo }" />
	                    	<tr>
	                    		<td><c:out value='${status.count }' /></td>
	                    		<td>${imageInfo.TITLE }</td>
	                    		<td>
	                    			<%
					ImageInfo imageInfo = (ImageInfo) pageContext.getAttribute("imageInfo");
					
					// 이미지파일 존재검사
					File imageFile = new File(imageInfo.getPATH() + "/" + imageInfo.getTITLE());
					boolean exist = imageFile.exists();
					
					if(exist){
						BufferedImage image;
						image = ImageIO.read(imageFile);
					
						ByteArrayOutputStream output = new ByteArrayOutputStream();
						ImageIO.write(image, "jpg", output);
						String imageAsBase64 = Base64.getEncoder().encodeToString(output.toByteArray());
				
						pageContext.setAttribute("result", 1);
						pageContext.setAttribute("imageBase64", imageAsBase64);
					}
					else{
						pageContext.setAttribute("result", 0);
					}
				%>
				<c:if test="${result == 1 }">
					<img src="data:image/jpeg;base64,${imageBase64}" alt="이미지 로드 실패" width="300" height="150"/>
				</c:if>
				<c:if test="${result == 0 }">
					이미지를 불러올 수 없습니다
				</c:if>
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

 	</div>	
 <!-- wrapper -->
</div>

<footer class="main-footer">
    <div class="float-right d-none d-sm-block">
      <b>Version</b> 3.1.0-rc
    </div>
    <strong>Copyright &copy; 2014-2021 <a href="https://adminlte.io">AdminLTE.io</a>.</strong> All rights reserved.
 </footer>
  <!-- /.content-wrapper -->
<!-- wrapper -->
</div>

<!-- REQUIRED SCRIPTS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js" integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js" integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG" crossorigin="anonymous"></script>

<!-- jQuery -->
<script src="${pageContext.request.contextPath}/AdminLTE/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="${pageContext.request.contextPath}/AdminLTE/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- Ekko Lightbox -->
<script src="${pageContext.request.contextPath}/AdminLTE/plugins/ekko-lightbox/ekko-lightbox.min.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath}/AdminLTE/dist/js/adminlte.min.js"></script>
<!-- Filterizr-->
<script src="${pageContext.request.contextPath}/AdminLTE/plugins/filterizr/jquery.filterizr.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="${pageContext.request.contextPath}/AdminLTE/dist/js/demo.js"></script>
<!-- Page specific script -->
<script>
  $(function () {
    $(document).on('click', '[data-toggle="lightbox"]', function(event) {
      event.preventDefault();
      $(this).ekkoLightbox({
        alwaysShowClose: true
      });
    });

    $('.filter-container').filterizr({gutterPixels: 3});
   $('.btn[data-filter]').on('click', function() {
     $('.btn[data-filter]').removeClass('active');
      $(this).addClass('active');
    });
  })
</script>

</body>
</html>