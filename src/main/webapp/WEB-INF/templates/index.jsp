<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("basePath", basePath);
%>
<script>
	$(function(){
		var url = $($("#nav ul li a")[1]).attr("href"); 
		window.location.href = url;
	});
</script>