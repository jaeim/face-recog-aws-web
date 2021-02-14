<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%request.setCharacterEncoding("utf-8"); %> 
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
<meta charset="utf-8">
<title>Insert title here</title>
<style>
  table {
    width: 100%;
    border: 1px solid #444444;
    border-collapse: collapse;
  }
  th, td {
    border: 1px solid #444444;
  }
</style>
</head>
<body>
<ul>
<c:forEach var="member" items="${memberList }">
	<li>
			<a href="<c:url value='/working/logInfo'>
						<c:param name='memberId' value='${member._id}' />
						</c:url>" class="js-action-a">${member.member_name}</a>
	</li>
</c:forEach>
</ul>

<c:if test="${logInfoList != null}">

	<table>
	<tr>
		<td>로그 날짜</td>
		<td>로그 내용</td>
	</tr>
	<c:forEach var="logInfo" items="${logInfoList }">
		<tr>
			<td><a href="<c:url value='/working/workingInfo'>
						<c:param name='logId' value='${logInfo.LOG_ID}' />
						</c:url>" class="js-action-a">${logInfo.CREATED_DT }</a></td>
			<td>
			<c:set var="filename" value="${logInfo.TITLE }" />
			<c:set var="filepath" value="${logInfo.PATH }" />
			<% 
				String filename = (String) pageContext.getAttribute("filename");
				//String path = request.getServletContext().getRealPath("/logFolder/");
				//String path = "/home/ubuntu/log/";
				//String path = "C:\\project\\awsworkspace\\log\\";
				
				String path = (String) pageContext.getAttribute("filepath") + "/";
				
				// 로그파일 존재 검사
				File logFile = new File(path + filename);
				boolean exist = logFile.exists();
				
				if(exist){
					path += filename;
					BufferedReader reader = null;
					try{
						reader = new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));
						if(reader != null){
							while(true){
								String str = reader.readLine();
								if(str == null){
									break;
								}
								out.println(str + "<br>");
							}
						}
					}
					catch(Exception e){
						
					}finally{
						reader.close();
					}
				}else {
					out.println("로그파일을 찾을 수 없습니다.");
				}
			%>
			</td>
		</tr>
	</c:forEach>
	</table>
</c:if>

<c:if test="${workingInfoList != null}">
	<table>
	<tr>
		<td>날짜시각</td>
		<td>근무타입</td>
		<td>총근무시간</td>
		<td>순수근무시간</td>
		<td>근무태만시간</td>
	</tr>
	<c:forEach var="workingInfo" items="${workingInfoList }">
		<tr>
		<td><a href="<c:url value='/working/captureImage'>
						<c:param name='workId' value='${workingInfo.history_id}' />
						</c:url>">${workingInfo.dateTime }</a></td>
			<td>${workingInfo.workType }</td>
			<td>${workingInfo.totalTime }</td>
			<td>${workingInfo.workTime }</td>
			<td>${workingInfo.notWorkTime }</td>
		</tr>
	</c:forEach>
	</table>
</c:if>

<c:if test="${imageInfoList != null }">
	<table>
		<tr>
			<td>이미지</td>
			<td>날짜시각</td>
		</tr>
		<c:forEach var="imageInfo" items="${imageInfoList }">
		<c:set var="imageInfo" value="${imageInfo }" />
		<tr>
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
					<img src="data:image/jpeg;base64,${imageBase64}" alt="이미지 로드 실패" width="400" height="200"/>
				</c:if>
				<c:if test="${result == 0 }">
					이미지를 불러올 수 없습니다
				</c:if>
			</td>
			<td>
				${imageInfo.TITLE }
			</td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>