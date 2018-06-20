<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	String baseInfoJson= (String)request.getAttribute("baseInfoJson");
 %>
<%@ include file="../layout/base_resource.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="${basePath}assets/multiselect-master/css/style.css" />
<script type="text/javascript" src="${basePath}assets/js/iframe.js"></script>
<script type="text/javascript" src="${basePath}assets/js/icd/icd_operation_page.js"></script>
<script type="text/javascript" src="${basePath}assets/multiselect-master/js/multiselect.js"></script>
<div class="loc">
	<h3>ICD_9_CM</h3>
	<ul class="loc_loc"><li> 当前位置：ICD数据> ICD_9_CM</li>
	</ul>
	
</div>
<div class="list_con_table">
	 
   <div class="search_table">
   <input type="hidden" id="basePath" value="${basePath }"/>
   <form id="queryForm" style="width: 100%">
   	<input type="hidden" name="currentPage" value="1"/>
    <ul>
   
    <li class="Label_1">编号：&nbsp;</li>
    <li class="Label_2"><input class="input_box" type="text" name="code"/></li>
    <li class="Label_1">名称：&nbsp;</li>
    <li class="Label_2"><input class="input_box" type="text" name="name" /></li>
    <li class="Label_1">检索码：&nbsp;</li>
    <li class="Label_2"><input class="input_box" type="text" name="indexCode" /></li>
    <li class="Label_5">
     <a onclick="layerCreatOperation()">新增</a>
     <a id="queryBtn" onclick="queryBtnClick()">查询</a>
    </li>
    </ul>
    </form>
    
   </div>
 <table style="width:934px; float:left; border-collapse:collapse;" id="query_show_table">
      <thead>
	      <tr>
	      	  <td class="tdLabel_4">编号</td>
		      <td class="tdLabel_4">名称</td>
		      <td class="tdLabel_4">检索码</td>
		      <td class="tdLabel_4">操作</td>
	      </tr>
      </thead>
      <tbody>
      	 <tr hidden="hidden" id="template_tr">
      	  <td class="tdLabel_5"><span class="code"></span></td>
	      <td class="tdLabel_5"><span class="name"></span></td>
	      <td class="tdLabel_5"><span class=index_code></span></td>
	      <td class="tdLabel_5">
	      	<a onclick="layerShow(this)" title="预览">预览&nbsp;</a>
	      	<a onclick="layerUpdateOperation(this)" title="编辑">编辑&nbsp;</a>
	      </td>
	     </tr>
      	
      </tbody>
     </table>
 <div id="pageList" class="pageList">
    <ul class="pagination clearfix" id="page_plus"></ul>
    <div class="pagination">
        <div>总共：<b id="totalPage">0</b> 条信息    当前页是第 <b id="currentPage">0/0</b>　页</div>
    </div>
</div>
</div>

<div hidden="hidden" id="create_disease_div">
	<form>
		<div class="search_table" style="width: 720px;">
		 <ul>
   
		    <li class="Label_1" style="width: 20%">编号：&nbsp;</li>
		    <li class="Label_2" style="width: 30%"><input class="input_box" type="text" name="code"/></li>
		    <li class="Label_1" style="width: 20%">名称：&nbsp;</li>
		    <li class="Label_2" style="width: 30%"><input class="input_box" type="text" name="name" /></li>
		    <li class="Label_1" style="width: 20%">英文名称：&nbsp;</li>
		    <li class="Label_2" style="width: 30%">
		    	<input class="input_box" type="text" name="enName"/>
		    </li>
		    <li class="Label_1" style="width: 20%">检索码：&nbsp;</li>
		    <li class="Label_2" style="width: 30%">
		    	<input class="input_box" type="text" name="indexCode"/>
		    </li>
		    <li class="Label_1" style="width: 20%">简称：&nbsp;</li>
		    <li class="Label_2" style="width: 30%">
		    	<input class="input_box" type="text" name="aliasName"/>
		    </li>
		    <li class="Label_1" style="width: 20%">简称索引：&nbsp;</li>
		    <li class="Label_2" style="width: 30%">
		    	<input class="input_box" type="text" name="aliasNameIndex"/>
		    </li>
		    <li class="Label_1" style="width: 20%">手术操作标识：&nbsp;</li>
		    <li class="Label_2" style="width: 30%">
		    	<select class="input_box" data-type="code_name" name="operationMarkCode"></select>
		    	<input type="hidden" name="operationMarkName">
		    </li>
		    <li class="Label_1" style="width: 20%">切口等级：&nbsp;</li>
		    <li class="Label_2" style="width: 30%">
		    	<select class="input_box" data-type="code_name" name="incisionLevelCode"></select>
		    	<input type="hidden" name="incisionLevelName">
		    </li>
		    <li class="Label_1" style="width: 20%">手术等级：&nbsp;</li>
		    <li class="Label_2" style="width: 30%">
		    	<select class="input_box" data-type="code_name" name="operationLevelCode"></select>
		    	<input type="hidden" name="operationLevelName">
		    </li>
		    
		    <li class="Label_1" style="width: 20%">备注：&nbsp;</li>
		    <li class="Label_2" style="width: 30%">
		    	<input class="input_box" type="text" name="comment"/>
		    </li>
		    <li class="Label_5">
		   
		     <a onclick="createBtnClick()">新增</a>
		    </li>
	    </ul>
	    </div>
	</form>
</div>

<div hidden="hidden" id="show_operation_div">
	<form>
		<div class="search_table" style="width: 720px;">
		 <ul>
   			 <li class="Label_1" style="width: 20%">编号：&nbsp;</li>
		    <li class="Label_2" style="width: 30%"><input class="input_box" type="text" name="code" readonly="readonly"/></li>
		    <li class="Label_1" style="width: 20%">名称：&nbsp;</li>
		    <li class="Label_2" style="width: 30%"><input class="input_box" type="text" name="name" readonly="readonly"/></li>
		    <li class="Label_1" style="width: 20%">英文名称：&nbsp;</li>
		    <li class="Label_2" style="width: 30%">
		    	<input class="input_box" type="text" name="enName" readonly="readonly"/>
		    </li>
		    <li class="Label_1" style="width: 20%">检索码：&nbsp;</li>
		    <li class="Label_2" style="width: 30%">
		    	<input class="input_box" type="text" name="indexCode" readonly="readonly"/>
		    </li>
		    <li class="Label_1" style="width: 20%">简称：&nbsp;</li>
		    <li class="Label_2" style="width: 30%">
		    	<input class="input_box" type="text" name="aliasName" readonly="readonly"/>
		    </li>
		    <li class="Label_1" style="width: 20%">简称索引：&nbsp;</li>
		    <li class="Label_2" style="width: 30%">
		    	<input class="input_box" type="text" name="aliasNameIndex"/>
		    </li>
		    <li class="Label_1" style="width: 20%">手术操作标识：&nbsp;</li>
		    <li class="Label_2" style="width: 30%">
		    	<input class="input_box" type="text" name="operationMarkName" readonly="readonly"/>
		    </li>
		    <li class="Label_1" style="width: 20%">切口等级：&nbsp;</li>
		    <li class="Label_2" style="width: 30%">
		    	<input class="input_box" type="text" name="incisionLevelName" readonly="readonly"/>
		    </li>
		    <li class="Label_1" style="width: 20%">手术等级：&nbsp;</li>
		    <li class="Label_2" style="width: 30%">
		    	<input class="input_box" type="text" name="operationLevelName" readonly="readonly"/>
		    </li>
		    
		    <li class="Label_1" style="width: 20%">备注：&nbsp;</li>
		    <li class="Label_2" style="width: 30%">
		    	<input class="input_box" type="text" name="comment"/>
		    </li>
	    </ul>
	    </div>
	</form>
</div>

<div hidden="hidden" id="update_operation_div">
	<form>
		<div class="search_table" style="width: 720px;">
		 <ul>
   			 <li class="Label_1" style="width: 20%">编号：&nbsp;</li>
		    <li class="Label_2" style="width: 30%"><input class="input_box" type="text" name="code" readonly="readonly"/></li>
		    <li class="Label_1" style="width: 20%">名称：&nbsp;</li>
		    <li class="Label_2" style="width: 30%"><input class="input_box" type="text" name="name" /></li>
		    <li class="Label_1" style="width: 20%">英文名称：&nbsp;</li>
		    <li class="Label_2" style="width: 30%">
		    	<input class="input_box" type="text" name="enName"/>
		    </li>
		    <li class="Label_1" style="width: 20%">检索码：&nbsp;</li>
		    <li class="Label_2" style="width: 30%">
		    	<input class="input_box" type="text" name="indexCode"/>
		    </li>
		    <li class="Label_1" style="width: 20%">简称：&nbsp;</li>
		    <li class="Label_2" style="width: 30%">
		    	<input class="input_box" type="text" name="aliasName"/>
		    </li>
		    <li class="Label_1" style="width: 20%">简称索引：&nbsp;</li>
		    <li class="Label_2" style="width: 30%">
		    	<input class="input_box" type="text" name="aliasNameIndex"/>
		    </li>
		    <li class="Label_1" style="width: 20%">手术操作标识：&nbsp;</li>
		    <li class="Label_2" style="width: 30%">
		    	<select class="input_box" name="operationMarkCode"></select>
		    	<input type="hidden" name="operationMarkName">
		    </li>
		    <li class="Label_1" style="width: 20%">切口等级：&nbsp;</li>
		    <li class="Label_2" style="width: 30%">
		    	<select class="input_box" name="incisionLevelCode"></select>
		    	<input type="hidden" name="incisionLevelName">
		    </li>
		    <li class="Label_1" style="width: 20%">手术等级：&nbsp;</li>
		    <li class="Label_2" style="width: 30%">
		    	<select class="input_box" name="operationLevelCode"></select>
		    	<input type="hidden" name="operationLevelName">
		    </li>
		    
		    <li class="Label_1" style="width: 20%">备注：&nbsp;</li>
		    <li class="Label_2" style="width: 30%">
		    	<input class="input_box" type="text" name="comment"/>
		    </li>
		    <li class="Label_5">
		   
		     <a onclick="updateBtnClick()">保存</a>
		    </li>
	    </ul>
	    </div>
	</form>
</div>



<script type="text/javascript">
	$(function(){
		var baseInfoJson= <%=baseInfoJson%>;
		console.log(baseInfoJson);
		init(baseInfoJson);
	});
</script>
