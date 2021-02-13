<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%request.setCharacterEncoding("utf-8"); %> 
<%@page import="java.util.*" %>    
<%@page import="model.*, controller. *" %>
<%@page import="org.json.*" %>
<%@page import="java.io.*" %>
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
			<% 
				String filename = (String) pageContext.getAttribute("filename");
				//String path = request.getServletContext().getRealPath("/logFolder/");
				String path = "/home/ubuntu/log/";
				//String path = "C:\\project\\awsworkspace\\log\\";
				
				// 로그파일 존재 검사
				File f = new File(path);
				boolean exist = false;
				if(f.isDirectory()) {
				    File[] fList = f.listFiles();
				    for(int i=0; i < fList.length; i++)
				       if(filename.equals(fList[i].getName())){
				    	   exist = true;
				    	   path += filename;
				    	   break;
				       }
				}
				
				if(exist){
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