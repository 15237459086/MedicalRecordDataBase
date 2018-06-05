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
					<h3>病案资源标签类型管理</h3>
				</div>

				<div class="list_con_table">
					<input type="hidden" value="${basicDataQuery.totalCounts}" id="totalCountsHidden">
					<form action="${path}/basic/getMrPageTypes" method="get" id="queryForm">
						<div class="search_table">
							<ul>
								<li>名称：&nbsp;</li>
								<li class="Label_2" style="width:30%">
									<input class="form-control" type="text" name="name" id="queryName" maxlength="200" value="${basicDataQuery.name}" />
								</li>
								<li>医院：&nbsp;</li>
								<li class="Label_2" style="width:30%">
									<select class="form-control" name="hospitalId" id="queryHospitalId">
										<option value="">请选择</option>
										<c:forEach var="hospital" items="${hospitals}">
											<option value="${hospital.id}" <c:if test="${basicDataQuery.hospitalId==hospital.id}">selected="selected"</c:if>>${hospital.name}</option>
										</c:forEach>
									</select>
								</li>
								<li class="Label_2" style="width:15%;margin-top: -1%">
								<button class="button" type="submit">查询</button></li>
							</ul>
						</div>
					</form>
					<form action="${path}/basic/getMrPageTypes" method="get" id="pageForm">
						<input type="hidden" name="currentPage" value="${basicDataQuery.currentPage }" id="currentPageHidden"> 
						<input type="hidden" name="pageSize" value="${basicDataQuery.pageSize }" id="pageSizeHidden"> 
						<input type="hidden" name="name" value="${basicDataQuery.name}" />
						<input type="hidden" name="hospitalId" value="${basicDataQuery.hospitalId}" />
					</form>
				</div>
				<button class="button" onclick='insertBasic()' style="float:right;">新增</button>
				<table class="tableList" cellpadding="0" cellspacing="0">
					<tr>
						<td class="tdLabel_4" style="display: none">主键</td>
						<td class="tdLabel_4">编码</td>
						<td class="tdLabel_4">名称</td>
						<td class="tdLabel_4">检索码</td>
						<td class="tdLabel_4">所属医院</td>
						<td class="tdLabel_4_button">编辑</td>
						<td class="tdLabel_4_button">删除</td>
					</tr>
					<tbody id="tbody">
						<c:forEach var="basic" items="${basics}">
							<tr>
								<td class="tdLabel_5" style="display: none">${basic.pageTypeId }</td>
								<td class='tdLabel_5'>${basic.code}</td>
								<td class='tdLabel_5'>${basic.name}</td>
								<td class='tdLabel_5'>${basic.indexCode}</td>
								<td class='tdLabel_5'>${basic.hospitalName}</td>
								<td class='tdLabel_5' style="text-align: center">
								<a onclick="updateBasic(${basic.pageTypeId})">
								<img src="${path}/static/images/edit.png" style="height: 23px;margin-bottom: 8px;"/>
								</a></td> 
								<td class='tdLabel_5' style="text-align: center">
								<a onclick="deleteBasic(${basic.pageTypeId})">
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
	   function deleteBasic(id){
		   
		   $.ajax({
	           type: "POST",
	           url:"<%=path%>/basic/validateMrPageTypeIsUse?id="+id,
	            success: function(data) {
	            	if (data.success==true) {
	            		 confirm("删除提示","是否删除？",function(){
	            			 $.ajax({
	 	         	            type: "POST",
	 	         	           url:"<%=path%>/basic/deleteMrPageType?id="+id,
	 	         	            success: function(data) {
	 	         	            	if (data.success==true) {
	 	         	            		location.href="<%=basePath%>/basic/getMrPageTypes";
	 	         	    			} else {
	 	         	    				showfailMsg("删除提示","删除失败");
	 	         	    			}
	 	         	            }
	 	         	        }); 
	          		   },function(){});
	            		
	    			} else {
	    				showWarnMsg("删除提示","该记录已被引用不可删除");
	    			}
	            }
	        }); 
		  
	   }
	   
	   function insertBasic(){
		   location.href="<%=basePath%>/basic/addMrPageTypePage";
	   }
	   
	   function updateBasic(id){
		   var currentPageCount = $("#currentPageHidden").val();
		   var pageCount =$("#pageSizeHidden").val();
		   var queryName = $("#queryName").val();
		   var hospitalId = $("#queryHospitalId").val();
		   location.href = "<%=basePath%>/basic/showMrPageType?id="+id+"&currentPage="+currentPageCount+"&pageSize="+pageCount+"&name="+queryName+"&hospitalId="+hospitalId;
	   }
	</script>
</html>