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
						<h3>编辑打印类型信息</h3>
					</div>
					<input type="hidden" id="path" value="${path}"/>
					<input type="hidden" id="currentPage" value="${currentPage }" id="currentPageHidden"> 
					<input type="hidden" id="pageSize" value="${pageSize }" id="pageSizeHidden"> 
					<input type="hidden" id="queryName" value="${name}" />
					<input type="hidden" id="queryHospitalId" value="${hospitalId}" />
					<input type="hidden" id="basicPageTypeIds" value="${basic.pageTypeIds}" />
					<form class="form-horizontal" action="${path}/basic/updateMrPrinterType" method="post" >
						<input type="hidden" name="status" value="${basic.status }" />
						<input type="hidden" id="basicId" name="printTypeId" value="${basic.printTypeId}"/>
						<table style="margin-top:5px;text-align: center">
							<tr>
								<td width="90px">编码:</td>
								<td >
								<div class="form-group">
										<input type="text" name="code" class="form-control" value="${basic.code}"/>
									</div>
									
								</td>
									
							</tr>
							<tr>
								<td width="90px">检索码:</td>
								<td >
								<div class="form-group">
										<input type="text" name="indexCode" class="form-control" value="${basic.indexCode }"/>
									</div>
								</td>
							</tr>
							<tr>
							<td width="90px">名称:</td>
								<td>
								<div class="form-group">
										<input type="text" name="name" class="form-control" value="${basic.name}"/>
									</div>
									</td>
							</tr>
							<tr>
							<td width="90px">英文名称:</td>
								<td>
								<div class="form-group">
										<input type="text" name="enName" class="form-control" value="${basic.enName }" />
									</div>
									</td>
							</tr>
							<tr>
							<td width="90px">所属医院:</td>
								<td>
								<div class="form-group">
									<select name="hospitalId" class="form-control" id="hospitalId">
										<c:forEach var="hospital" items="${hospitals}">
											<option value="${hospital.id}" <c:if test="${hospital.id == basic.hospitalId}">selected="selected"</c:if>>${hospital.name}</option>
										</c:forEach>
									</select>
								</div>
								</td>
							</tr>
							<tr>
							<td width="90px">标签类型:</td>
								<td>
								<div class="form-group">
									<select name="pageTypeIds" class="selectpicker" multiple data-live-search="true" id="pageTypeId" title="请选择">
										<c:forEach var="pageType" items="${pageTypeList }"> 
											<option value="${pageType.id }">${pageType.name}</option>
										</c:forEach>
									</select>
								</div>
								</td>
							</tr>
							<tr>
							<td width="90px">备注:</td>
							<td>
								<div class="form-group">
									<textarea name="comment" rows="5" cols="6" class="form-control">${basic.comment}</textarea>
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
<script type="text/javascript" src="${path}/static/js/basic/mrprinttypeform.js"></script>
</html>