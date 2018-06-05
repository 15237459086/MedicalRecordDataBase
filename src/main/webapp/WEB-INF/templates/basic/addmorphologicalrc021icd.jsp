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
						<h3>新增全国版RC021-ICD-10形态学编码信息</h3>
					</div>
					<input type="hidden" id="path" value="${path}"/>
					<form class="navbar-form" action="${path}/morphological/insertMorphologicalRc021Icd" method="post" style="width:100%;padding: 0">
						<input type="hidden" name="status" value="${basic.status }" />
						<table class="table table-condensed table-bordered table-striped table-hover" style="margin-top:5px;text-align: center" >
							<tr>
								<td>编码</td>
								<td >
								<div class="form-group">
										<input type="text" name="code" id="basicCode" class="form-control"/>
									</div>
									
								</td>
								<td>名称</td>
								<td>
								<div class="form-group">
										<input type="text" name="name" class="form-control"/>
									</div>
								</td>
							</tr>

						<tr>
							<td>检索码</td>
							<td>
								<div class="form-group">
									<input type="text" name="indexCode" class="form-control"/>
								</div>
							</td>
							<td>英文名称</td>
							<td>
								<div class="form-group">
									<input type="text" name="enName" class="form-control"/>
								</div>
							</td>

						</tr>
						<tr>
							<td>别名</td>
							<td>
								<div class="form-group">
									<input type="text" name="aliasName" class="form-control"/>
								</div>
							</td>
							<td>别名索引</td>
							<td>
								<div class="form-group">
									<input type="text" name="aliasNameIndex" class="form-control"/>
								</div>
							</td>
						</tr>
	
							<tr>
								<td>备注</td>
								<td colspan="5">
								<div class="form-group">
									<textarea rows="5" cols="50" class="form-control" name="comment"></textarea>
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
<script type="text/javascript" src="${path}/static/js/basic/morphologicalRc021Icdform.js"></script>

</html>