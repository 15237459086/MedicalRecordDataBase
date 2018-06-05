<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../list.inc"%>
<html>
<body>
<jsp:include page="../top.jsp"></jsp:include>
	<div style="width: 100%; height:100%;">
		<jsp:include page="../left.jsp"></jsp:include>
		<div style="width:100%; height: 100%;">
			<div id="list_NR" style="float: left;">
				<div class="loc">
					<h3>病历质控标准（2014）管理</h3>
				</div>

				<div class="list_con_table">
					<input type="hidden" value="${basicDataQuery.totalCounts}" id="totalCountsHidden">
					<form action="${path}/pointStandard/getPointStandards" method="get" id="queryForm">
						<div class="search_table">
							<ul>
								<li>项目：&nbsp;</li>
								<li class="Label_2" style="width:60%">
									<input class="form-control" type="text" name="name" id="queryName" maxlength="169" value="${basicDataQuery.name}" />
								</li>
								<li class="Label_2" style="width:22%;margin-top: -1.5%">
								<button class="button" type="submit">查询</button></li>
							</ul>
						</div>
					</form>
					<form action="${path}/pointStandard/getPointStandards" method="get" id="pageForm">
						<input type="hidden" name="currentPage" value="${basicDataQuery.currentPage }" id="currentPageHidden"> 
						<input type="hidden" name="pageSize" value="${basicDataQuery.pageSize }" id="pageSizeHidden"> 
						<input type="hidden" name="name" value="${basicDataQuery.name}" />
					</form>
				</div>
				<!-- <button class="button" onclick='insertBasic()' style="float:right;">新增</button> -->
				<table class="tableList" cellpadding="0" cellspacing="0">
					<tr>
						<td class="tdLabel_4" style="display: none">主键</td>
						<td class="tdLabel_4">项目</td>
						<td class="tdLabel_4">评分</td>
						 <td class="tdLabel_4_button">编辑</td>
						<!-- <td class="tdLabel_4">删除</td> -->
					</tr>
					<tbody id="tbody">
						<c:forEach var="basic" items="${basics}">
							<tr>
								<td class="tdLabel_5" style="display: none">${basic.id }</td>
								<td class='tdLabel_5'>${basic.project}</td>
								<td class='tdLabel_5'>${basic.score}</td>
 								<td class='tdLabel_5' style="text-align: center">
								<a onclick="updateBasic(${basic.id})">
								<img src="${path}/static/images/edit.png" style="height: 23px;margin-bottom: 8px;"/>
								</a></td>
								<%--<td class='tdLabel_5' style="text-align: center">
								<a onclick="deleteBasic(${basic.id})">
								<img src="${path}/static/images/del.png" style="height: 23px;margin-bottom: 8px;"/>
								</a></td> --%>
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
	            		 confirm("删除提示","是否删除？",function(){
	            			 $.ajax({
	 	         	            type: "POST",
	 	         	           url:"<%=path%>/pointStandard/deletePointStandard?id="+id,
	 	         	            success: function(data) {
	 	         	            	if (data.success==true) {
	 	         	            		location.href="<%=basePath%>/pointStandard/getPointStandards";
	 	         	    			} else {
	 	         	    				showfailMsg("删除提示","删除失败");
	 	         	    			}
	 	         	            }
	 	         	        }); 
	          		   },function(){});
	   }
	   
	   function insertBasic(){
		   location.href="<%=basePath%>/pointStandard/addpointStandardPage";
	   }
	   
	   function updateBasic(id){
		   var currentPageCount = $("#currentPageHidden").val();
		   var pageCount =$("#pageSizeHidden").val();
		   var queryName = $("#queryName").val();
		   location.href = "<%=basePath%>/pointStandard/showPointStandard?id="+id+"&currentPage="+currentPageCount+"&pageSize="+pageCount+"&name="+queryName;
	   }
	</script>
</html>