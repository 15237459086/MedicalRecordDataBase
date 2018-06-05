<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("basePath", basePath);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title><tiles:getAsString name="title" /></title>
	
	<link rel="stylesheet" href="${basePath}assets/css/basic.css"/>
	<link rel="stylesheet" href="${basePath}assets/css/list.css"/>
	<link rel="stylesheet" href="${basePath}assets/css/login.css"/>
	<script type="text/javascript" src="${basePath}assets/jquery/jquery.min.js"></script>
	<link rel="stylesheet" href="${basePath}assets/bootstrap/css/bootstrap.css"/>   
	<script type="text/javascript" src="${basePath}assets/bootstrap/js/bootstrap.js"></script> 
	<script type="text/javascript" src="${basePath}assets/js/header.js"></script>
	
	
  </head>
  
  <body>
  	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="body" />
  </body>
</html>
