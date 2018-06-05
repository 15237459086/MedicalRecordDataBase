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
						<h3>新增国家疾病分类信息</h3>
					</div>
					<input type="hidden" id="path" value="${path}"/>
					<form class="navbar-form" action="${path}/basic/insertStdDisease" method="post" style="width:100%;padding: 0">
						<input type="hidden" name="status" value="1" />
						<table class="table table-condensed table-bordered table-striped table-hover" style="margin-top:5px;text-align: center" >
							<tr>
								<td class="tdLable1">编码</td>
								<td >
								<div class="form-group">
										<input type="text" name="code" id="basicCode" class="form-control"/>
									</div>
									
								</td>
								<td class="tdLable1">名称</td>
								<td>
								<div class="form-group">
										<input type="text" name="name" class="form-control"/>
									</div>
								</td>
								
							</tr>
						<tr>
							<td class="tdLable1">检索码</td>
								<td>
								<div class="form-group">
									<input type="text" name="indexCode" class="form-control"/>
								</div>
								</td>
							<td class="tdLable1">英文名称</td>
							<td>
								<div class="form-group">
									<input type="text" name="enName" class="form-control"/>
								</div>
							</td>
						</tr>
						
						<tr>
							<td class="tdLable1">编码属性</td>
								<td>
									<div class="form-group">
										<select name="attributeId" class="form-control" style="width:236px;"> 
											<option value="">请选择</option>
											<c:forEach var="stdAttributeCode" items="${attributeCodeList }">
												<option value="${stdAttributeCode.id}">${stdAttributeCode.name}</option>
											</c:forEach>
									</select>
									</div>
							</td>
							<td class="tdLable1">国际疾病库版本</td>
							<td>
								<div class="form-group">
									<input type="text" name="interDiseaseVersion" class="form-control"/>
								</div>
							</td>	
						
						</tr>
						
						<tr>
							<td class="tdLable1">省级疾病标准码</td>
							<td>
							<div class="form-group">
								<input type="text" name="provinceCode" class="form-control"/>
							</div>
							</td>
							<td class="tdLable1">地级疾病标准码</td>
							<td>
							<div class="form-group">
								<input type="text" name="regionCode" class="form-control"/>
							</div>
							</td>
						</tr>
						
						<tr>
							<td class="tdLable1">别名</td>
							<td>
								<div class="form-group">
									<input type="text" name="aliasName" class="form-control"/>
								</div>
							</td>
							<td class="tdLable1">别名索引</td>
							<td>
								<div class="form-group">
									<input type="text" name="aliasNameIndex" class="form-control"/>
								</div>
							</td>
						</tr>
	
							<tr>
							<td class="tdLable1">适合男性编码标识</td>
							<td>
								<div class="form-group">
									<input type="checkbox" name="fitManCodeFlag" id="fitManCodeFlag">
								</div>
							</td>
							<td class="tdLable1">适合女性编码标识</td>
							<td>
								<div class="form-group">
									<input type="checkbox" name="womanCodeFlag" id="womanCodeFlag">
								</div>
							</td>

						</tr>
							
						<tr>
							<td class="tdLable1">非死亡标识</td>
								<td>
								<div class="form-group">
								 	<input type="checkbox" name="undeathFlag" id="undeathFlag">
								</div>
							</td>
							<td class="tdLable1">非主要诊断标识</td>
								<td>
								<div class="form-group">
								 		<input type="checkbox" name="unPrimaryFlag" id="unPrimaryFlag">
								</div>
							</td>
						</tr>
							
							<tr>
								<td class="tdLable1">慎用诊断标识</td>
								<td>
								<div class="form-group">
								 	<input type="checkbox" name="attentionFlag" id="attentionFlag">
								</div>
								</td>
								<td class="tdLable1">慎用诊断原因</td>
								<td>
								<div class="form-group">
									<textarea rows="5" cols="20" class="form-control" name="attentionComment"></textarea>
								</div>
								</td>
							</tr>
							<tr>
							<td class="tdLable1">临床诊断</td>
								<td>
								<div class="form-group">
									<input type="text" name="clinicalDiagnosis" class="form-control"/>
								</div>
								</td>
								<td class="tdLable1">临床诊断索引</td>
								<td>
								<div class="form-group">
									<input type="text" name="diagnosisIndex" class="form-control"/>
								</div>
								</td>
							</tr>
	
							<tr>
								<td class="tdLable1">备注</td>
								<td colspan="5">
								<div class="form-group">
									<textarea rows="5" cols="60" class="form-control" name="comment"></textarea>
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