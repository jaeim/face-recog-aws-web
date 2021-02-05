<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%request.setCharacterEncoding("UTF-8"); %> 
<%@page import="java.util.*" %>    
<%@page import="model.*, controller. *" %>
<%@page import="org.json.*" %>
<%@page import="java.io.*" %>
<%
	Setting setting = (Setting) request.getAttribute("setting");
	response.setContentType("application/json");
	JSONObject obj = new JSONObject();
	
	obj.put("RECOG_LV", setting.getRECOG_LV());
	obj.put("NOD_SEC", setting.getNOD_SEC());
	obj.put("DETEC_SEC", setting.getDETEC_SEC());
	obj.put("VID_INTVL", setting.getVID_INTVL());
	
	response.getWriter().write(obj.toString());
	//String json = obj.toString();
	//out.print(json);
	
	//out.print("<img src=\"data:image/jpeg;base64,${member.getImage_encoded()}\" width=\"200\" height=\"200\">");
%>