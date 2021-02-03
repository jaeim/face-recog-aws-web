<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%request.setCharacterEncoding("UTF-8"); %> 
<%@page import="java.util.*" %>    
<%@page import="model.*, controller. *" %>
<%@page import="org.json.*" %>
<%@page import="java.io.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table>
<c:forEach var="member" items="${memberList }">
	<tr>
		<td>
			<a href="<c:url value='/working/logInfo'>
						<c:param name='memberId' value='${member._id}' />
						</c:url>">${member.member_name}</a>
		</td>
	</tr>
</c:forEach>
</table>

<c:if test="${logInfoList != null}">
	<table>
	<tr>
		<td>로그 날짜</td>
		<td>로그 내용</td>
	</tr>
	<c:forEach var="logInfo" items="${logInfoList }">
		<c:set var="logInfo" value="${logInfo }" />
		<tr>
			<td><a href="<c:url value='/working/workingInfo'>
						<c:param name='logId' value='${logInfo.LOG_ID}' />
						</c:url>">${logInfo.CREATED_DT }</a></td>
			<td>
			<% 
				LogInfo logInfo = (LogInfo) pageContext.getAttribute("logInfo");
				String content = new String(logInfo.getCONTENT());
				out.print(content);
			%>
			</td>
		</tr>
	</c:forEach>
	</table>
</c:if>

<c:if test="${workingInfoList != null}">
	<table>
	<tr>
		<td>date</td>
		<td>workType</td>
		<td>totalTime</td>
		<td>workTime</td>
		<td>notWorkTime</td>
	</tr>
	<c:forEach var="workingInfo" items="${workingInfoList }">
		<tr>
			<td>${workingInfo.dateTime }</td>
			<td>${workingInfo.workType }</td>
			<td>${workingInfo.totalTime }</td>
			<td>${workingInfo.workTime }</td>
			<td>${workingInfo.notWorkTime }</td>
		</tr>
	</c:forEach>
	</table>
</c:if>

</body>
</html>