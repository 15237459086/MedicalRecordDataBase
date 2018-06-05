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
					<h3>北京版RC022-ICD-9手术编码管理</h3>
				</div>

				<div class="list_con_table">
					<input type="hidden" value="${basicDataQuery.totalCounts}" id="totalCountsHidden">
					<form action="${path}/operationIcd9/getStdOperationIcd9s" method="get" id="queryForm">
						<div class="search_table">
							<ul>
								<li>名称：&nbsp;</li>
								<li class="Label_2">
									<input class="form-control" type="text" name="name" id="queryName" maxlength="200" value="${basicDataQuery.name}" />
								</li>
								<li>编码：&nbsp;</li>
								<li class="Label_2">
									<input class="form-control" type="text" name="code" id="querycode" maxlength="200" value="${basicDataQuery.code}" />
								</li>
								<li>检索码：&nbsp;</li>
								<li class="Label_2">
									<input class="form-control" type="text" name="indexCode" id="queryIndexCode" maxlength="200" value="${basicDataQuery.indexCode}" />
								</li>
								<li class="Label_2" style="width:15%;margin-top: -0.5%">
								<button class="button" type="submit">查询</button></li>
							</ul>
						</div>
					</form>
					<form action="${path}/operationIcd9/getStdOperationIcd9s" method="get" id="pageForm">
						<input type="hidden" name="currentPage" value="${basicDataQuery.currentPage }" id="currentPageHidden"> 
						<input type="hidden" name="pageSize" value="${basicDataQuery.pageSize }" id="pageSizeHidden"> 
						<input type="hidden" name="name" value="${basicDataQuery.name}" />
						<input type="hidden" name="code" value="${basicDataQuery.code}" />
						<input type="hidden" name="indexCode" value="${basicDataQuery.indexCode}" />
					</form>
				</div>
				<button class="button" onclick='insertBasic()' style="float:right;">新增</button>
				 <table class="tableList" cellpadding="0" cellspacing="0">
					<tr>
						<td class="tdLabel_4" style="width:20%">编码</td>
						<td class="tdLabel_4" style="width:70%">名称</td>
						<td class="tdLabel_4_button">编辑</td>
						<td class="tdLabel_4_button">删除</td>
					</tr>
						<c:forEach var="basic" items="${basics}">
							<tr>
								<td class='tdLabel_5'><span id="cust_hidden" title="${basic.code}">${basic.code}</span></td>
								<td class='tdLabel_5'><span id="cust_hidden" title="${basic.name}">${basic.name}</span></td>
								<td class='tdLabel_5' style="text-align: center">
								<a onclick="updateBasic('${basic.code}')">
								<img src="${path}/static/images/edit.png" style="height: 23px;margin-bottom: 8px;"/>
								</a></td>
						 		<td class='tdLabel_5' style="text-align: center">
								<a onclick="deleteBasic('${basic.code}')">
								<img src="${path}/static/images/del.png" style="height: 23px;margin-bottom: 8px;"/>
								</a></td> 
							</tr>
						</c:forEach>
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

	   function deleteBasic(code){
		 
	            		 confirm("删除提示","是否删除？",function(){
	            			 $.ajax({
	 	         	            type: "POST",
	 	         	           url:"<%=path%>/operationIcd9/deleteStdOperationIcd9?code="+code,
	 	         	            success: function(data) {
	 	         	            	if (data.success==true) {
	 	         	            		location.href="<%=basePath%>/operationIcd9/getStdOperationIcd9s";
	 	         	    			} else {
	 	         	    				showfailMsg("删除提示","删除失败");
	 	         	    			}
	 	         	            }
	 	         	        }); 
	          		   },function(){});
	   }
	   
	   function insertBasic(){
		   location.href="<%=basePath%>/operationIcd9/addStdOperationIcd9Page";
	   }
	   
	   function updateBasic(code){
		   var currentPageCount = $("#currentPageHidden").val();
		   var pageCount =$("#pageSizeHidden").val();
		   var queryName = $("#queryName").val();
		   var indexCode = $("#queryIndexCode").val();
		   var queryCode = $("#querycode").val();
		   location.href = "<%=basePath%>/operationIcd9/showStdOperationIcd9?code="+code+"&currentPage="+currentPageCount
				   +"&pageSize="+pageCount+"&name="+queryName+"&queryCode="+queryCode+"&indexCode="+indexCode;
	   }
	</script>
</html>