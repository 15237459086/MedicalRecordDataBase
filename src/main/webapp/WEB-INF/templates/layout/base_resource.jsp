<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("basePath", basePath);
%>
<link rel="stylesheet" href="${basePath}assets/css/basic.css"/>
<link rel="stylesheet" href="${basePath}assets/css/list.css"/><%-- 
<link rel="stylesheet" href="${basePath}assets/css/login.css"/> --%>
<script type="text/javascript" src="${basePath}assets/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${basePath}assets/jquery/jquery.form.js"></script>

<link rel="stylesheet" href="${basePath}assets/bootstrap/css/bootstrap.css"/>   
<%-- <script type="text/javascript" src="${basePath}assets/bootstrap/js/bootstrap.js"></script> --%>
<script type="text/javascript" src="${basePath}assets/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${basePath}assets/jqPaginator/jqPaginator.js"></script>
<script type="text/javascript" src="${basePath}assets/layer/layer.js"></script>

<script type="text/javascript" src="${basePath}assets/jqueryValidate/jquery.validate.js"></script>

<script type="text/javascript" src="${basePath}assets/jqueryValidate/localization/messages_zh.js"></script>
