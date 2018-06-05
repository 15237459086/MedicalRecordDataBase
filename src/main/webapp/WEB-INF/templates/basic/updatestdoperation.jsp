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
						<h3>编辑手术信息</h3>
					</div>
					<input type="hidden" id="path" value="${path}"/>
					<input type="hidden" id="currentPage" value="${currentPage }" id="currentPageHidden"> 
					<input type="hidden" id="pageSize" value="${pageSize }" id="pageSizeHidden"> 
					<input type="hidden" id="queryName" value="${name}" />
					<input type="hidden" id="queryIndexCode" value="${indexCode}" />
					<input type="hidden" id="querycode" value="${code}" />
					<form class="navbar-form" action="${path}/basic/updateStdOperation" method="post" style="width:100%;padding:0">
						<input type="hidden" name="status" value="${basic.status }" />
						<table class="table table-condensed table-bordered table-striped table-hover" style="margin-top:5px;text-align: center" >
							<tr>
								<td class="tdLable1">编码</td>
								<td >
								<div class="form-group">
										<input type="text" name="code" id="basicCode" class="form-control" readonly = "readonly" value="${basic.code}"/>
									</div>
									
								</td>
								<td class="tdLable1">名称</td>
								<td>
								<div class="form-group">
										<input type="text" name="name" class="form-control" value="${basic.name}"/>
									</div>
								</td>
							</tr>

						<tr>
							<td class="tdLable1">检索码</td>
							<td>
								<div class="form-group">
									<input type="text" name="indexCode" class="form-control"
										value="${basic.indexCode}" />
								</div>
							</td>
							<td class="tdLable1">英文名称</td>
							<td>
								<div class="form-group">
									<input type="text" name="enName" class="form-control"
										value="${basic.enName}" />
								</div>
							</td>

						</tr>
						
						<tr>
							<td class="tdLable1">别名</td>
							<td>
								<div class="form-group">
									<input type="text" name="aliasName" class="form-control" value="${basic.aliasName}" />
								</div>
							</td>
							<td class="tdLable1">别名索引</td>
							<td>
								<div class="form-group">
									<input type="text" name="aliasNameIndex" class="form-control" value="${basic.aliasNameIndex}" />
								</div>
							</td>
						</tr>
						
						<tr>
							<td class="tdLable1">编码属性</td>
								<td>
								<div class="form-group">
									<select name="attributesId" class="form-control" style="width:235px;"> 
										<option value="">请选择</option>
										<c:forEach var="stdAttributeCode" items="${basicMap.stdAttributeCodes }">
											<option value="${stdAttributeCode.id}" <c:if test="${stdAttributeCode.id==basic.attributesId}">selected="selected"</c:if>>${stdAttributeCode.name}</option>
										</c:forEach>
									</select>
								</div>
							</td>
							<td class="tdLable1">切口等级</td>
								<td>
								<div class="form-group">
									<select name="stdIncisionLevelId" class="form-control" style="width:235px;"> 
										<option value="">请选择</option>
										<c:forEach var="stdIncisionLevel" items="${basicMap.incisionLevels}">
											<option value="${stdIncisionLevel.id}" <c:if test="${stdIncisionLevel.id==basic.stdIncisionLevelId}">selected="selected"</c:if>>${stdIncisionLevel.name}</option>
										</c:forEach>
									</select>
								</div>
							</td>
						</tr>
						
					   <tr>
							<td class="tdLable1">手术等级</td>
								<td>
								<div class="form-group">
									<select name="stdOpsLevelId" class="form-control" style="width:235px;"> 
										<option value="">请选择</option>
										<c:forEach var="opsLevel" items="${basicMap.opsLevels }">
											<option value="${opsLevel.id}" <c:if test="${opsLevel.id==basic.stdOpsLevelId}">selected="selected"</c:if>>${opsLevel.name}</option>
										</c:forEach>
									</select>
								</div>
							</td>
							<td class="tdLable1">手术标识</td>
								<td>
								<div class="form-group">
									<select name="stdOpsPerationMarkId" class="form-control" style="width:235px;"> 
										<option value="">请选择</option>
										<c:forEach var="opsMark" items="${basicMap.opsMarks}">
											<option value="${opsMark.id}" <c:if test="${opsMark.id==basic.stdOpsPerationMarkId}">selected="selected"</c:if>>${opsMark.name}</option>
										</c:forEach>
									</select>
								</div>
							</td>
						</tr>

						<tr>
							<td class="tdLable1">省级疾病标准码</td>
							<td>
							<div class="form-group">
								<input type="text" name="stdProvinceCode" class="form-control" value="${basic.stdProvinceCode}" />
							</div>
							</td>
							<td class="tdLable1">地级疾病标准码</td>
							<td>
							<div class="form-group">
								<input type="text" name="stdRegionCode" class="form-control" value="${basic.stdRegionCode}" />
							</div>
							</td>
						</tr>

						<tr>
							<td class="tdLable1">国际疾病库版本</td>
							<td>
								<div class="form-group">
									<input type="text" name="interDiseaseVersion" class="form-control" value="${basic.interDiseaseVersion}" />
								</div>
							</td>
							<td class="tdLable1">备注</td>
							<td>
								<div class="form-group">
									<textarea rows="5" cols="27" class="form-control" name="comment">${basic.comment}</textarea>
								</div>
							</td>
						</tr>

						<tr>
						   	 <td colspan="6" align="center">
						   		 <div id="info" style="color:red"></div>
						   	 </td>
								
							</tr>
						    <tr>
						   	 <td colspan="6"  align="center">
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
<script type="text/javascript" src="${path}/static/js/basic/stdoperationform.js"></script>

</html>