<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/base_resource.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="${basePath}assets/multiselect-master/css/style.css" />
<script type="text/javascript" src="${basePath}assets/js/iframe.js"></script>
<script type="text/javascript" src="${basePath}assets/js/print/print_type_page.js"></script>
<script type="text/javascript" src="${basePath}assets/multiselect-master/js/multiselect.js"></script>
<div class="loc">
	<h3>打印内容管理</h3>
	<ul class="loc_loc"><li> 当前位置：打印设置> 打印内容管理</li>
	</ul>
	
</div>
<div class="list_con_table">
	 
   <div class="search_table">
   <input type="hidden" id="basePath" value="${basePath }"/>
   <form id="updateForm" style="width: 100%">
    <ul>
   
    <li class="Label_1">打印类型：&nbsp;</li>
    <li class="Label_2">
    	<select name="printerTypeId" class="input_box">
    		<option value="">---请选择---</option>
    		<c:forEach var="printType" items="${printTypes }">
    			<option value="${printType.id}">${printType.name }</option>
    		</c:forEach>
    	</select>
    </li>
    <li class="Label_5">
     <a id="updateBtn" hidden="hidden" onclick="updateBtnClick()">保存</a>
    </li>
    </ul>
    <ul>
    <c:forEach var="pageType" items="${pageTypes}">
    	<li class="Label_2" style="width: 20%">
	    	<input type="checkbox" name="pageTypeIds" value="${pageType.id }">${pageType.name }
	    </li>
    </c:forEach>
    </ul>
    </form>
    
   </div>
    
</div>



