<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%request.setCharacterEncoding("UTF-8"); %> 
<%@page import="java.util.*" %>    
<%@page import="model.*, controller. *" %>
<%@page import="org.json.*" %>
<%@page import="java.io.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	// ������ ���̽㿡�� �� �������� ������ ���� ���� �ּ�ó���� ���� �κ��� Ȱ���ϸ� �� �� ����.
	Member member = (Member) request.getAttribute("member");

	response.setContentType("application/json");
	JSONObject obj = new JSONObject();
	
	obj.put("image", member.getImage_encoded());
	obj.put("name", member.getMember_name());
	
	response.getWriter().write(obj.toString());
	//String json = obj.toString();
	//out.print(json);
%>

