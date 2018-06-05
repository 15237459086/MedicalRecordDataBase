<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../form.inc"%>
<html>
<head>
<meta charset="utf-8">
<title>医学信息标准</title>
</head>
<body>
<jsp:include page="../top.jsp"></jsp:include>
	<div style="width:100%;height:80%;">
			<jsp:include page="../left.jsp"></jsp:include>
			<div style="width:100%;height:510px;">
				<div id="list_NR" style="float:left">
					<div class="loc">
						<h3>编辑病历质控标准信息</h3>
					</div>
					<input type="hidden" id="path" value="${path}"/>
					<input type="hidden" id="currentPage" value="${currentPage }" id="currentPageHidden"> 
					<input type="hidden" id="pageSize" value="${pageSize }" id="pageSizeHidden"> 
					<input type="hidden" id="queryName" value="${name}" />
					<form class="form-horizontal" action="${path}/pointStandard/updatePointStandard" method="post" >
						<input type="hidden" id="basicId" name="id" value="${basic[0].id}"/>
						<table style="margin-top:5px;text-align: center">
							<tr>
								<td width="90px">项目:</td>
								<td >
								<div class="form-group">
										<input type="text" name="project" class="form-control" value="${basic[0].project}"/>
									</div>
									
								</td>
							</tr>
							<tr>
								<td width="90px">评分:</td>
								<td >
								<div class="form-group">
										<input type="text" name="score" class="form-control" value="${basic[0].score }"/>
									</div>
								</td>
							</tr>
							<tr>
							<td width="90px">所属项目:</td>
								<td>
								<div class="form-group">
										<input type="text" readonly="readonly" class="form-control" value="${basic[0].parentName}"/>
									    <input type="hidden" name="parentId" value="${basic[0].parentId}"/>
									</div>
									</td>
							</tr>
							
						<tr>
						   	 <td colspan="2" align="center">
						   		 <div id="info" style="color:red"></div>
						   	 </td>
								
							</tr>
						    <tr>
						   	 <td colspan="2" align="center">
						   		 <button type="button" class="button" id="submit">保存</button>
						   	 	<button type="button" class="btn btn-default" id="back">返回</button>
						   	 </td>
							</tr>
						</table>
					</form>
				</div>
				
			</div>
		</div>
</body>
<script type="text/javascript" src="${path}/static/js/basic/pointStandardform.js"></script>

</html>