<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:if test="${imageInfoList != null}">
	<table>
		<tr>
			<td>user_id</td>
			<td>img</td>
		</tr>
		<c:forEach var="imageInfo" items="${imageInfoList }">
			<c:set var="imageInfo" value="${imageInfo}" />
			<tr>
				<td>${imageInfo.USER_ID }</td>
				<td>
					<%
						BufferedImage image;
						File imageFile = new File("파일 경로");
						image = ImageIO.read(imageFile);

						
						ByteArrayOutputStream output = new ByteArrayOutputStream();
						ImageIO.write(image, "png", output);
						String imageAsBase64 = Base64.getEncoder().encodeToString(output.toByteArray());
					%>
				</td>
			</tr>
		</c:forEach>
	</table>

</c:if>
</body>
</html>