<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%request.setCharacterEncoding("UTF-8"); %> 
<%@page import="java.util.*" %>    
<%@page import="model.*, controller. *" %>
<%@page import="org.json.*" %>
<%@page import="java.io.*" %>
<%
	response.setContentType("application/json");
	JSONObject obj = new JSONObject();

	obj.put("error", "error");
	response.getWriter().write(obj.toString());
%>