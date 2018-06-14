<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/base_resource.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="${basePath}assets/multiselect-master/css/style.css" />
<script type="text/javascript" src="${basePath}assets/js/iframe.js"></script>
<script type="text/javascript" src="${basePath}assets/js/icd/icd_disease_page.js"></script>
<script type="text/javascript" src="${basePath}assets/multiselect-master/js/multiselect.js"></script>
<div class="loc">
	<h3>ICD_10</h3>
	<ul class="loc_loc"><li> 当前位置：ICD数据> ICD_10</li>
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
     <a onclick="layerCreatDisease()">新增</a>
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
	      	<a onclick="layerUpdateDisease(this)" title="编辑">编辑&nbsp;</a>
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
		    <li class="Label_1" style="width: 20%">适合男性编码：&nbsp;</li>
		    <li class="Label_2" style="width: 30%">
		    	<input type="checkbox" name="fitManCodeFlag" checked="checked" value="1"/>
		    </li>
		    <li class="Label_1" style="width: 20%">适合女性编码：&nbsp;</li>
		    <li class="Label_2" style="width: 30%">
		    	<input type="checkbox" name="fitWomanCodeFlag" checked="checked" value="1"/>
		    </li>
		    <li class="Label_1" style="width: 20%">非死亡标：&nbsp;</li>
		    <li class="Label_2" style="width: 30%">
		    	<input type="checkbox" name="unDeathFlag" value="1"/>
		    </li>
		    <li class="Label_1" style="width: 20%">非主要诊断标识：&nbsp;</li>
		    <li class="Label_2" style="width: 30%">
		    	<input type="checkbox" name="unPrimaryFlag" value="1"/>
		    </li>
		    <li class="Label_1" style="width: 20%">慎用诊断标识：&nbsp;</li>
		    <li class="Label_2" style="width: 30%">
		    	<input type="checkbox" name="attentionFlag" value="1"/>
		    </li>
		    <li class="Label_1" style="width: 20%">慎用诊断原因：&nbsp;</li>
		    <li class="Label_2" style="width: 30%">
		    	<input class="input_box" type="text" name="attentionComment"/>
		    </li>
		    <li class="Label_1" style="width: 20%">备注：&nbsp;</li>
		    <li class="Label_2" style="width: 80%">
		    	<input class="input_box" type="text" name="comment"/>
		    </li>
		    <li class="Label_5">
		   
		     <a onclick="createBtnClick()">新增</a>
		    </li>
	    </ul>
	    </div>
	</form>
</div>


<div hidden="hidden" id="update_disease_div">
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
		    <li class="Label_1" style="width: 20%">适合男性编码：&nbsp;</li>
		    <li class="Label_2" style="width: 30%">
		    	<input type="checkbox" name="fitManCodeFlag" value="1"/>
		    </li>
		    <li class="Label_1" style="width: 20%">适合女性编码：&nbsp;</li>
		    <li class="Label_2" style="width: 30%">
		    	<input type="checkbox" name="fitWomanCodeFlag" value="1"/>
		    </li>
		    <li class="Label_1" style="width: 20%">非死亡标：&nbsp;</li>
		    <li class="Label_2" style="width: 30%">
		    	<input type="checkbox" name="unDeathFlag" value="1"/>
		    </li>
		    <li class="Label_1" style="width: 20%">非主要诊断标识：&nbsp;</li>
		    <li class="Label_2" style="width: 30%">
		    	<input type="checkbox" name="unPrimaryFlag" value="1"/>
		    </li>
		    <li class="Label_1" style="width: 20%">慎用诊断标识：&nbsp;</li>
		    <li class="Label_2" style="width: 30%">
		    	<input type="checkbox" name="attentionFlag" value="1"/>
		    </li>
		    <li class="Label_1" style="width: 20%">慎用诊断原因：&nbsp;</li>
		    <li class="Label_2" style="width: 30%">
		    	<input class="input_box" type="text" name="attentionComment"/>
		    </li>
		    <li class="Label_1" style="width: 20%">备注：&nbsp;</li>
		    <li class="Label_2" style="width: 80%">
		    	<input class="input_box" type="text" name="comment"/>
		    </li>
		    <li class="Label_5">
		   
		     <a onclick="updateBtnClick()">保存</a>
		    </li>
	    </ul>
	    </div>
	</form>
</div>


