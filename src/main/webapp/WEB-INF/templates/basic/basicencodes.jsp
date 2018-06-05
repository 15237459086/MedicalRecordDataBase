<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../list.inc"%>
<html>
<body>
<jsp:include page="../top.jsp"></jsp:include>
	<div style="width: 100%; height:100%;">
		<jsp:include page="../left.jsp"></jsp:include>
		<div style="width:100%; height: 100%;" id="content">
			<div id="list_NR" style="float: left;">
				<div class="loc">
					<h3>${basicDataQuery.title}管理</h3>
				</div>

				<div class="list_con_table">
					<input type="hidden" value="${basicDataQuery.totalCounts }" id="totalCountsHidden">
					<form action="${path}/basic/getBasicEncodes" method="get" id="queryForm">
						<input type="hidden"  name="tableName" value="${basicDataQuery.tableName}" id="tableName">
						<div class="search_table">
							<ul>
								<li>名称：&nbsp;</li>
								<li class="Label_2" style="width:60%">
								<input class="form-control" type="text" name="name" id="queryName" maxlength="200" value="${basicDataQuery.name}" />
								</li>
								<li class="Label_2" style="width:20%;margin-top: -2%">
								<button class="button" type="submit">查询</button></li>
							</ul>
						</div>
					</form>
					<form action="${path}/basic/getBasicEncodes" method="get" id="pageForm">
						<input type="hidden" name="currentPage" value="${basicDataQuery.currentPage }" id="currentPageHidden"> 
						<input type="hidden" name="pageSize" value="${basicDataQuery.pageSize }" id="pageSizeHidden"> 
						<input type="hidden" name="name" value="${basicDataQuery.name}" />
						<input type="hidden"  name="tableName" value="${basicDataQuery.tableName}" id="tableName">
					</form>
				</div>
				<button class="button" onclick='insertBasic("${basicDataQuery.tableName}")' style="float:right;">新增</button>
				<table class="tableList" cellpadding="0" cellspacing="0">
					<tr>
						<td class="tdLabel_4" style="display: none">主键</td>
						<td class="tdLabel_4">编码</td>
						<td class="tdLabel_4">名称</td>
						<td class="tdLabel_4_button">编辑</td>
						<td class="tdLabel_4_button">删除</td>
					</tr>
					<tbody id="tbody">
						<c:forEach var="basic" items="${basics}">
							<tr>
								<td class="tdLabel_5" style="display: none">${basic.id }</td>
								<td class='tdLabel_5'>${basic.code}</td>
								<td class='tdLabel_5'>${basic.name}</td>
								<td class='tdLabel_5' style="text-align: center">
								<a onclick="updateBasic(${basic.id})">
								<img src="${path}/static/images/edit.png" style="height: 23px;margin-bottom: 8px;"/>
								</a></td>
								<td class='tdLabel_5' style="text-align: center">
								<a onclick="deleteBasic(${basic.id})">
								<img src="${path}/static/images/del.png" style="height: 23px;margin-bottom: 8px;"/>
								</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="pageList">
					<ul class="pagination clearfix" id="page_plus"></ul>
					<div class="pagination">
						<div>
							总共：<b id="totalPage">0</b> 条信息 当前页是第 <b id="currentPage">0/0</b>页
						</div>
					</div>
				</div>
			</div>


		</div>
	</div>
</body>
<script type="text/javascript" src="${path }/static/js/basic/paginator.js"></script>
<script type="text/javascript">
var tableName = $("#tableName").val();
	   function deleteBasic(id){
		   if("treatment_sign"==tableName){
			   validateTreatmentIsUse(id,"");
		   }else if("treatment_type"==tableName){
			   validateTreatmentIsUse("",id);
		   }else if("in_hospital_type"==tableName){
			   validateHospitalTypeIsUse(id,"");
		   }else if("out_hospital_type"==tableName){
			   validateHospitalTypeIsUse("",id);
		   }else if("sex"==tableName){
			   validateSexIsUse(id);
		   }else if("hospital"==tableName){
			   validateHospitalIsUse(id);
		   }else if("medical_resource_type"==tableName){
			   validateResourceTypeIsUse(id);
		   }else if("std_attributes_code"==tableName){
			   validateStdAttributeCodeIsUse(id);
		   }
		   
		   else if("std_incision_level"==tableName){
			   validateIncisionAndOpsLevelAndOpsMarkIsUse(id,"","");
		   }else if("std_ops_level"==tableName){
			   validateIncisionAndOpsLevelAndOpsMarkIsUse("",id,"");
		   }else if("std_ops_operation_mark"==tableName){
			   validateIncisionAndOpsLevelAndOpsMarkIsUse("","",id);
		   }
		   
		   else if("identity_document_type"==tableName){
			   validateIdTypeIsUse(id);
		   }else{
			   ajaxDeleteBasic(id);
		   }
		   
	   }
	   
	   function validateIdTypeIsUse(id){
		   $.ajax({
	            type: "POST",
	           url:"<%=path%>/basic/validateIdTypeIsUse?id="+id,
	            success: function(data) {
	            	if (data.success==true) {
	            		 ajaxDeleteBasic(id,tableName);
	            	} else {
	    				showfailMsg("删除提示","该记录已被引用不可删除!");
	    			}
	            }
	        }); 
	   }
	   function ajaxDeleteBasic(id){
		   confirm("删除提示","是否删除？",function(){
			   $.ajax({
		            type: "POST",
		           url:"<%=path%>/basic/deleteBasicEncode?id="+id+"&tableName="+tableName,
		            success: function(data) {
		            	if (data.success==true) {
		            		location.href="<%=basePath%>/basic/getBasicEncodes?tableName="+tableName;
		    			} else {
		    				showfailMsg("删除提示","删除失败");
		    			}
		            }
		        }); 
  		   },function(){});
		   
	   }
	   
	   
	   
	   
	   function validateStdAttributeCodeIsUse(id){
		   $.ajax({
	           type: "POST",
	           url:"<%=path%>/basic/validateStdAttributesCode?id="+id,
	            success: function(data) {
	            	if (data.success==true) {
	            		 ajaxDeleteBasic(id);
	            	}else{
	            		showWarnMsg("删除提示","该记录已被引用不可删除");
	            	}
	            }
		   });
	   }
	   
	   
	   function validateTreatmentIsUse(signId,typeId){
		   $.ajax({
	            type: "POST",
	           url:"<%=path%>/basic/validateTreatmentIsUse?signId="+signId+"&typeId="+typeId,
	            success: function(data) {
	            	if (data.success==true) {
	            		var id="";
	            		if(signId!=""){
	            			id = signId;
	            		}
	            		if(typeId!=""){
	            			id= typeId;
	            		}
	            		ajaxDeleteBasic(id);
	    			} else {
	    				showWarnMsg("删除提示","该记录已被引用不可删除");
	    			}
	            }
	        }); 
	   }
	   
	   function validateSexIsUse(id){
		   $.ajax({
	            type: "POST",
	           url:"<%=basePath%>/basic/validateSexIsUse?id="+id,
	            success: function(data) {
	            	if (data.success==true) {
	            		ajaxDeleteBasic(id);
	    			} else {
	    				showWarnMsg("删除提示","该记录已被引用不可删除");
	    			}
	            }
	        }); 
		   
	   }
	   
	   function validateHospitalIsUse(id){
		   $.ajax({
	            type: "POST",
	           url:"<%=basePath%>/basic/validateHospitalIsUse?id="+id,
	            success: function(data) {
	            	if (data.success==true) {
	            		ajaxDeleteBasic(id);
	    			} else {
	    				showWarnMsg("删除提示","该记录已被引用不可删除");
	    			}
	            }
	        }); 
		   
	   }
	   
	   function validateHospitalTypeIsUse(inId,outId){
		   $.ajax({
	            type: "POST",
	           url:"<%=path%>/basic/validateHospitalTypeIsUse?inId="+inId+"&outId="+outId,
	            success: function(data) {
	            	if (data.success==true) {
	            		var id="";
	            		if(inId!=""){
	            			id = inId;
	            		}
	            		if(outId!=""){
	            			id= outId;
	            		}
	            		ajaxDeleteBasic(id);
	    			} else {
	    				showWarnMsg("删除提示","该记录已被引用不可删除");
	    			}
	            }
	        }); 
	   }
	   
	   function validateResourceTypeIsUse(id){
		   $.ajax({
	            type: "POST",
	           url:"<%=basePath%>/basic/validateResourceTypeIsUse?id="+id,
	            success: function(data) {
	            	if (data.success==true) {
	            		ajaxDeleteBasic(id);
	    			} else {
	    				showWarnMsg("删除提示","该记录已被引用不可删除");
	    			}
	            }
	        }); 
	   }
	   
	   
	   function validateIncisionAndOpsLevelAndOpsMarkIsUse(incisionLevelId,opsLevelId,opsMarkId){
		   $.ajax({
	            type: "POST",
	           url:"<%=path%>/basic/validateOperation?incisionLevelId="+incisionLevelId+"&opsLevelId="+opsLevelId+"&opsMarkId="+opsMarkId,
	            success: function(data) {
	            	if (data.success==true) {
	            		var id="";
	            		if(incisionLevelId!=""){
	            			id = incisionLevelId;
	            		}
	            		if(opsLevelId!=""){
	            			id= opsLevelId;
	            		}
	            		if(opsMarkId!=""){
	            			id=opsMarkId;
	            		}
	            		ajaxDeleteBasic(id);
	    			} else {
	    				showWarnMsg("删除提示","该记录已被引用不可删除");
	    			}
	            }
	        }); 
	   }
	   
	   
	   
	   
	   
	   function insertBasic(tableName){
		   location.href="<%=basePath%>/basic/addBasicEncodePage?tableName="+tableName;
	   }
	   
	   function updateBasic(id){
		   var currentPageCount = $("#currentPageHidden").val();
		   var pageCount =$("#pageSizeHidden").val();
		   var queryName = $("#queryName").val();
		   var tableName = $("#tableName").val();
		   location.href = "<%=basePath%>/basic/showBasicEncode?tableName="+tableName+"&id="+id+"&currentPage="+currentPageCount+"&pageSize="+pageCount+"&name="+queryName;
	   }
	</script>
</html>