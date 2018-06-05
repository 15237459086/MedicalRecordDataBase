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
						<h3>编辑国家疾病分类信息</h3>
					</div>
					<input type="hidden" id="path" value="${path}"/>
					<input type="hidden" id="currentPage" value="${currentPage }" id="currentPageHidden"> 
					<input type="hidden" id="pageSize" value="${pageSize }" id="pageSizeHidden"> 
					<input type="hidden" id="queryName" value="${name}" />
					<input type="hidden" id="queryIndexCode" value="${indexCode}" />
					<input type="hidden" id="querycode" value="${code}" />
					<form class="navbar-form" action="${path}/basic/updateStdDisease" method="post" style="width:100%;padding: 0">
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
							<td class="tdLable1">编码属性</td>
								<td>
								<div class="form-group">
									<select name="attributeId" class="form-control" style="width:210px;"> 
										<option value="">请选择</option>
										<c:forEach var="stdAttributeCode" items="${attributeCodeList }">
											<option value="${stdAttributeCode.id}" <c:if test="${stdAttributeCode.id==basic.attributeId}">selected="selected"</c:if>>${stdAttributeCode.name}</option>
										</c:forEach>
									</select>
								</div>
							</td>
							<td class="tdLable1">国际疾病库版本</td>
							<td>
								<div class="form-group">
									<input type="text" name="interDiseaseVersion" class="form-control" value="${basic.interDiseaseVersion}" />
								</div>
							</td>
						</tr>

						<tr>
							<td class="tdLable1">省级疾病标准码</td>
							<td>
							<div class="form-group">
								<input type="text" name="provinceCode" class="form-control" value="${basic.provinceCode}" />
							</div>
							</td>
							<td class="tdLable1">地级疾病标准码</td>
							<td>
							<div class="form-group">
								<input type="text" name="regionCode" class="form-control" value="${basic.regionCode}" />
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
							<td class="tdLable1">适合男性编码标识</td>
								<td>
								<div class="form-group">
								<c:choose>
								 	<c:when test="${basic.fitManCodeFlag==null or basic.fitManCodeFlag=='0'}">
								 		<input type="checkbox" name="fitManCodeFlag" id="fitManCodeFlag">
								 	</c:when>
								 	<c:otherwise>
								 		<input type="checkbox" name="fitManCodeFlag" checked="checked" id="fitManCodeFlag" value="1">
								 	</c:otherwise>
								 </c:choose>
								</div>
								</td>
								<td class="tdLable1">适合女性编码标识</td>
								<td>
								<div class="form-group">
								 <c:choose>
								 	<c:when test="${basic.womanCodeFlag==null or basic.womanCodeFlag=='0'}">
								 		<input type="checkbox" name="womanCodeFlag" id="womanCodeFlag">
								 	</c:when>
								 	<c:otherwise>
								 		<input type="checkbox" name="womanCodeFlag" checked="checked" id="womanCodeFlag" value="1">
								 	</c:otherwise>
								 </c:choose>
								</div>
								</td>
								
							</tr>
							<tr>
							<td class="tdLable1">非死亡标识</td>
								<td>
								<div class="form-group">
								 <c:choose>
								 	<c:when test="${basic.undeathFlag==null or basic.undeathFlag=='0'}">
								 		<input type="checkbox" name="undeathFlag" id="undeathFlag">
								 	</c:when>
								 	<c:otherwise>
								 		<input type="checkbox" name="undeathFlag" checked="checked" id="undeathFlag" value="1">
								 	</c:otherwise>
								 </c:choose>
								</div>
								</td>
								<td class="tdLable1">非主要诊断标识</td>
								<td>
								<div class="form-group">
								 <c:choose>
								 	<c:when test="${basic.unPrimaryFlag==null or basic.unPrimaryFlag=='0'}">
								 		<input type="checkbox" name="unPrimaryFlag" id="unPrimaryFlag">
								 	</c:when>
								 	<c:otherwise>
								 		<input type="checkbox" name="unPrimaryFlag" checked="checked" id="unPrimaryFlag" value="1">
								 	</c:otherwise>
								 </c:choose>
								</div>
								</td>
							</tr>
							
							<tr>
								<td class="tdLable1">慎用诊断标识</td>
								<td>
								<div class="form-group">
								 <c:choose>
								 	<c:when test="${basic.attentionFlag==null or basic.attentionFlag=='0'}">
								 		<input type="checkbox" name="attentionFlag" id="attentionFlag">
								 	</c:when>
								 	<c:otherwise>
								 		<input type="checkbox" name="attentionFlag" checked="checked" id="attentionFlag" value="1">
								 	</c:otherwise>
								 </c:choose>
								</div>
								</td>
								<td class="tdLable1">慎用诊断原因</td>
								<td>
								<div class="form-group">
									<textarea rows="5" cols="20" class="form-control" name="attentionComment">${basic.attentionComment}</textarea>
								</div>
								</td>
							</tr>
							
							<tr>
							<td class="tdLable1">临床诊断</td>
								<td>
								<div class="form-group">
									<input type="text" name="clinicalDiagnosis" class="form-control" value="${basic.clinicalDiagnosis}" />
								</div>
								</td>
								<td class="tdLable1">临床诊断索引</td>
								<td>
								<div class="form-group">
									<input type="text" name="diagnosisIndex" class="form-control" value="${basic.diagnosisIndex}" />
								</div>
								</td>
							</tr>
	
							<tr>
								<td class="tdLable1">备注</td>
								<td colspan="5">
								<div class="form-group">
									<textarea rows="5" cols="60" class="form-control" name="comment">${basic.comment}</textarea>
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
<script type="text/javascript" src="${path}/static/js/basic/diseaseform.js"></script>

</html>