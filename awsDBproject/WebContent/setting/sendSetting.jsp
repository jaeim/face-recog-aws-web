<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%request.setCharacterEncoding("UTF-8"); %> 
<%@page import="java.util.*" %>    
<%@page import="model.*, controller. *" %>
<%@page import="org.json.*" %>
<%@page import="java.io.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	response.setContentType("application/json");
	JSONObject obj = new JSONObject();
	
	obj.put("RECOG_LV", 2);
	obj.put("NOD_SEC", 20);
	obj.put("DETEC_SEC", 60);
	
	response.getWriter().write(obj.toString());
	//String json = obj.toString();
	//out.print(json);
	
	//out.print("<img src=\"data:image/jpeg;base64,${member.getImage_encoded()}\" width=\"200\" height=\"200\">");
%>