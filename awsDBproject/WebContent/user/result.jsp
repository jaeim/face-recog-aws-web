<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%request.setCharacterEncoding("UTF-8"); %> 
<%@page import="java.util.*" %>    
<%@page import="model.*, controller. *" %>
<%@page import="org.json.*" %>
<%@page import="java.io.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	// 실제로 파이썬에서 이 페이지에 접속할 때는 지금 주석처리해 놓은 부분을 활용하면 될 것 같다.
	Member member = (Member) request.getAttribute("member");

	response.setContentType("application/json");
	JSONObject obj = new JSONObject();
	
	obj.put("image", member.getImage_encoded());
	obj.put("name", member.getMember_name());
	
	response.getWriter().write(obj.toString());
	//String json = obj.toString();
	//out.print(json);
%>

