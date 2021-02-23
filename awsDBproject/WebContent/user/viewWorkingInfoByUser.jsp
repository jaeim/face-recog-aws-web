<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<div id="divForWorkingHistory">
	
	<!-- /.row -->
				<div class="row">
					<div class="col-12">
						<div class="card">
							<div class="card-header">
								<div class="row">
								<div class="col-11">
								<h3 class="card-title"><b>${member.member_name }</b>의 근무기록</h3>
								</div>
								
								<div class="col-1">
									<button type="button" id="closeBtn"
								class="btn btn-primary btn-block " onclick="closeWorkingHistory();">닫기</button>
								</div>
								</div>
							</div>
							<!-- /.card-header -->
							<div class="card-body table-responsive p-0"
								style="height: 210px;">
								<table id="historyList" class="table table-head-fixed text-nowrap">
									<thead>
										<tr>
											<th>#</th>
											<th>구분</th>
											<th>날짜</th>
											<th>로그인시각</th>
											<th>로그아웃시각</th>
											<th>총근무시간</th>
											<th>인정근무시간</th>
											<th>태만탐지화면</th>
											<th>근무통계</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="workingInfo" items="${workingInfoList}" varStatus="status">
											<tr>
												<td><c:out value='${status.count }' /></td>
												<td>${workingInfo.workType }</td>
												<td>
													<fmt:parseDate value="${workingInfo.dateTime }" var="postDate" pattern="yyyy-MM-dd HH:mm:ss"/>
													<fmt:formatDate value="${postDate}" pattern="yyyy-MM-dd"/>
												</td>
												<td>
													<fmt:parseDate value="${workingInfo.logInfo.CREATED_DT }" var="loginTime" pattern="yyyy-MM-dd HH:mm:ss"/>
													<fmt:formatDate value="${loginTime}" pattern="HH:mm:ss"/>
												</td>
												<td>
													<fmt:parseDate value="${workingInfo.logInfo.LOGOUT_DT }" var="logoutTime" pattern="yyyy-MM-dd HH:mm:ss"/>
													<fmt:formatDate value="${logoutTime}" pattern="HH:mm:ss"/>
												</td>
												<td class="totalTime">                   
													${workingInfo.totalTime }	
												</td>
												<td class="workTime">
													${workingInfo.workTime }
												</td>
												<td>
													<c:choose>
														<c:when test="${workingInfo.workType eq 'real'}">
															<button type="button" class="btn btn-outline-secondary"
															onclick="location.href='${pageContext.request.contextPath}/work/captureImage?workId=${workingInfo.history_id}'">상세보기</button>
														</c:when>
														<c:otherwise>
															<button type="button" class="btn btn-light"
															onclick="" disabled>정보없음</button>
														</c:otherwise>
													</c:choose>
													
												</td>
												<td>
													<button type="button" class="btn btn-outline-secondary"
														onclick="location.href='${pageContext.request.contextPath}/work/detailLog?workId=${workingInfo.history_id}'">로그보기</button>
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