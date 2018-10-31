<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/base_resource.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="${basePath}assets/multiselect-master/css/style.css" />
<script type="text/javascript" src="${basePath}assets/js/iframe.js"></script>
<script type="text/javascript" src="${basePath}assets/js/hospital_message/medical_dept_page.js"></script>
<script type="text/javascript" src="${basePath}assets/multiselect-master/js/multiselect.js"></script>
<div class="loc">
	<h3>科室管理</h3>
	<ul class="loc_loc"><li> 当前位置：医院信息 > 科室管理</li>
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
    <li class="Label_1">所属医院机构：&nbsp;</li>
    <li class="Label_2">
    	<select class="input_box" name="hospitalCode"></select>
		    	<input type="hidden" name="hospitalName">
    </li>
    <li class="Label_5">
     <a onclick="layerCreateBasicData('${tableNameEnum.tableNameDesc}')">新增</a>
     <a id="queryBtn" onclick="queryBtnClick()">查询</a>
    </li>
    </ul>
    </form>
   </div>
  
    
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
	      	<a onclick="layerUpdateBasicData(this,'${tableNameEnum.tableNameDesc}')" title="编辑">编辑&nbsp;</a>
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


<div hidden="hidden" id="create_basic_data_div">
	<form>
		<input type="hidden" name="tableName" value="${tableNameEnum.tableName }"/>
		<div class="search_table" style="width: 380px;">
		 <ul>
   
		    <li class="Label_1" style="width: 40%">编号：&nbsp;</li>
		    <li class="Label_2" style="width: 60%"><input class="input_box" type="text" name="code"/></li>
		    <li class="Label_1" style="width: 40%">名称：&nbsp;</li>
		    <li class="Label_2" style="width: 60%"><input class="input_box" type="text" name="name" /></li>
		    <li class="Label_1" style="width: 40%">英文名称：&nbsp;</li>
		    <li class="Label_2" style="width: 60%">
		    	<input class="input_box" type="text" name="enName"/>
		    </li>
		    <li class="Label_1" style="width: 40%">检索码：&nbsp;</li>
		    <li class="Label_2" style="width: 60%">
		    	<input class="input_box" type="text" name="indexCode"/>
		    </li>
		    <li class="Label_1" style="width: 40%">排序码：&nbsp;</li>
		    <li class="Label_2" style="width: 60%">
		    	<input class="input_box" type="text" name="sortCode"/>
		    </li>
		    <li class="Label_1" style="width: 40%">说明：&nbsp;</li>
		    <li class="Label_2" style="width: 60%">
		    	<input class="input_box" type="text" name="comment"/>
		    </li>
		    <li class="Label_5">
		   
		     <a onclick="createBasicDataBtnClick()">新增</a>
		    </li>
	    </ul>
	    </div>
	</form>
</div>


<div hidden="hidden" id="update_basic_data_div">
	<form>
		<input type="hidden" name="id"/>
		<input type="hidden" name="tableName" value="${tableNameEnum.tableName }"/>
		<div class="search_table" style="width: 380px;">
		 <ul>
   			<li class="Label_1" style="width: 40%">编号：&nbsp;</li>
		    <li class="Label_2" style="width: 60%"><input class="input_box" type="text" name="code"/></li>
		    <li class="Label_1" style="width: 40%">名称：&nbsp;</li>
		    <li class="Label_2" style="width: 60%"><input class="input_box" type="text" name="name" /></li>
		    <li class="Label_1" style="width: 40%">英文名称：&nbsp;</li>
		    <li class="Label_2" style="width: 60%">
		    	<input class="input_box" type="text" name="enName"/>
		    </li>
		    <li class="Label_1" style="width: 40%">检索码：&nbsp;</li>
		    <li class="Label_2" style="width: 60%">
		    	<input class="input_box" type="text" name="indexCode"/>
		    </li>
		    <li class="Label_1" style="width: 40%">排序码：&nbsp;</li>
		    <li class="Label_2" style="width: 60%">
		    	<input class="input_box" type="text" name="sortCode"/>
		    </li>
		    <li class="Label_1" style="width: 40%">说明：&nbsp;</li>
		    <li class="Label_2" style="width: 60%">
		    	<input class="input_box" type="text" name="comment"/>
		    </li>
		    
		    <li class="Label_5">
		   
		     <a class="ceate_role_btn" onclick="updateBasicDataBtnClick()">保存</a>
		    </li>
	    </ul>
	    </div>
	</form>
</div>