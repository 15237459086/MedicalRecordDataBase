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
						<h3>编辑${title}信息</h3>
					</div>
					<input type="hidden" id="path" value="${path}"/>
					<input type="hidden" id="currentPage" value="${currentPage }" id="currentPageHidden"> 
					<input type="hidden" id="pageSize" value="${pageSize }" id="pageSizeHidden"> 
					<input type="hidden" id="queryName" value="${name}" />
					<form class="form-horizontal" action="${path}/basic/updateBasicEncode" method="post" style="width:100%;padding:0">
						<input type="hidden" name="id" id="basicId" value="${basic.id }" />
						<input type="hidden" name="status" value="${basic.status }" />
						<input type="hidden" name="tableName" id="tableName" value="${basic.tableName }" />
						<table style="width:100%;margin-top:5px;text-align: center;" >
							<tr>
								<td>编码:</td>
								<td class="tdLable2">
								<div class="form-group">
										<input type="text" name="code" class="form-control" value="${basic.code }"/>
									</div>
									
								</td>
									
							</tr>
							<tr>
								<td>检索码:</td>
								<td class="tdLable2">
								<div class="form-group">
										<input type="text" name="indexCode" class="form-control" value="${basic.indexCode }"/>
									</div>
								</td>
							</tr>
							<tr>
							<td>名称:</td>
								<td class="tdLable2">
								<div class="form-group">
										<input type="text" name="name" class="form-control" value="${basic.name }" />
									</div>
									</td>
							</tr>
							<tr>
							<td>英文名称:</td>
								<td class="tdLable2">
								<div class="form-group">
										<input type="text" name="enName" class="form-control" value="${basic.enName }" />
									</div>
									</td>
							</tr>
								<tr>
									<td>备注:</td>
									<td class="tdLable2">
										<div class="form-group">
											<textarea name="comment"  rows="5" cols="6" class="form-control">${basic.comment}</textarea>
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
<script type="text/javascript" src="${path}/static/js/basic/basicencode.js"></script>
</html>