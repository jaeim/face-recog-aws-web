<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String filename = "yhj_20210205_20-25-53.txt";
	String path = request.getServletContext().getRealPath("/logFolder/" + filename);
	
	BufferedReader reader = null;
	try{
		reader = new BufferedReader(new FileReader(path));
		
		while(true){
			String str = reader.readLine();
			if(str == null){
				break;
			}
			out.println(str + "<br>");
		}
	}
	catch(Exception e){
		
	}finally{
		reader.close();
	}
%>
</body>
</html>