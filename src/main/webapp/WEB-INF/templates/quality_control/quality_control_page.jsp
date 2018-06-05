<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/base_resource.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="${basePath}assets/multiselect-master/css/style.css" />
<script type="text/javascript" src="${basePath}assets/js/iframe.js"></script>
<script type="text/javascript" src="${basePath}assets/js/quality_control/quality_control_page.js"></script>
<script type="text/javascript" src="${basePath}assets/multiselect-master/js/multiselect.js"></script>
<div class="loc">
	<h3>质控管理</h3>
	<ul class="loc_loc"><li> 当前位置：质控数据 > 质控管理</li>
	</ul>
	
</div>
<div class="list_con_table">
	 
   <div class="search_table">
   <input type="hidden" id="basePath" value="${basePath }"/>
   <form id="queryForm" style="width: 100%">
   	<input type="hidden" name="currentPage" value="1"/>
   	<input type="hidden" name="tableName" value="${tableNameEnum.tableName }"/>
    <ul>
   
    <li class="Label_1">一级项目：&nbsp;</li>
    <li class="Label_2">
    	<select name="firstLevelCode" class="input_box">
    	</select>
    </li>
    <li class="Label_1">二级项目：&nbsp;</li>
    <li class="Label_2">
    	<select name="secondLevelCode" class="input_box">
    	</select>
    </li>
    
    <li class="Label_5">
     <a onclick="layerCreateData('${tableNameEnum.tableNameDesc}')">新增</a>
    </li>
    </ul>
    </form>
   </div>
  
    
</div>
 <table style="width:934px; float:left; border-collapse:collapse;" id="query_show_table">
      <thead>
	      <tr>
	      	  <td class="tdLabel_4">编号</td>
		      <td class="tdLabel_4">项目</td>
		      <td class="tdLabel_4">分数</td>
		      <td class="tdLabel_4">说明</td>
		      <td class="tdLabel_4">操作</td>
	      </tr>
      </thead>
      <tbody>
      	 <tr hidden="hidden" id="template_tr">
      	  <td class="tdLabel_5"><span class="code"></span></td>
	      <td class="tdLabel_5"><span class="project"></span></td>
	      <td class="tdLabel_5"><span class="score"></span></td>
	      <td class="tdLabel_5"><span class="remark"></span></td>
	      <td class="tdLabel_5">
	      	<a onclick="layerUpdateData(this)" title="编辑">编辑&nbsp;</a>
	      </td>
	     </tr>
      	
      </tbody>
     </table>


<div hidden="hidden" id="create_data_div">
	<form>
		<div class="search_table" style="width: 380px;">
		 <ul>
		    <li class="Label_1" style="width: 40%">编号：&nbsp;</li>
		    <li class="Label_2" style="width: 60%">
		    	<input class="input_box" type="text" name="code"/>
		    </li>
		    <li class="Label_1" style="width: 40%">项目名称：&nbsp;</li>
		    <li class="Label_2" style="width: 60%">
		    	<input class="input_box" type="text" name="project" />
		    </li>
		    <li class="Label_1" style="width: 40%">分数：&nbsp;</li>
		    <li class="Label_2" style="width: 60%">
		    	<input class="input_box" type="text" name="score"/>
		    </li>
		    <li class="Label_1" style="width: 40%">说明：&nbsp;</li>
		     <li class="Label_2" style="width: 60%">
		    	<input class="input_box" type="text" name="mark"/>
		    </li>
		    <li class="Label_5">
		   
		     <a onclick="createDataBtnClick()">新增</a>
		    </li>
	    </ul>
	    </div>
	</form>
</div>


<div hidden="hidden" id="update_data_div">
	<form>
		<input type="hidden" name="id"/>
		<div class="search_table" style="width: 380px;">
		 <ul>
   			<li class="Label_1" style="width: 40%">编号：&nbsp;</li>
		    <li class="Label_2" style="width: 60%">
		    	<input class="input_box" type="text" name="code"/>
		    </li>
		    <li class="Label_1" style="width: 40%">项目名称：&nbsp;</li>
		    <li class="Label_2" style="width: 60%">
		    	<input class="input_box" type="text" name="project" />
		    </li>
		    <li class="Label_1" style="width: 40%">分数：&nbsp;</li>
		    <li class="Label_2" style="width: 60%">
		    	<input class="input_box" type="text" name="score"/>
		    </li>
		    <li class="Label_1" style="width: 40%">说明：&nbsp;</li>
		     <li class="Label_2" style="width: 60%">
		    	<input class="input_box" type="text" name="mark"/>
		    </li>
		    <li class="Label_5">
		   
		     <a class="ceate_role_btn" onclick="updateDataBtnClick()">保存</a>
		    </li>
	    </ul>
	    </div>
	</form>
</div>

