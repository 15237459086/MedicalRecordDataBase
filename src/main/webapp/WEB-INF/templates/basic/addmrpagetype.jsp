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
						<h3>新增病案资源标签类型</h3>
					</div>
					<input type="hidden" id="path" value="${path}"/>
					<form class="form-horizontal" action="${path}/basic/insertMrPageType" method="post" >
						<input type="hidden" name="status" value="1" />
						<input type="hidden" id="basicId"/>
						<table style="margin-top:5px;text-align: center">
							<tr>
								<td width="90px">编码:</td>
								<td >
								<div class="form-group">
										<input type="text" name="code" class="form-control"/>
									</div>
									
								</td>
									
							</tr>
							<tr>
							<td width="90px">名称:</td>
								<td>
								<div class="form-group">
										<input type="text" name="name" class="form-control"/>
									</div>
									</td>
							</tr>
							<tr>
							<td width="90px">英文名称:</td>
								<td>
								<div class="form-group">
										<input type="text" name="enName" class="form-control"/>
									</div>
									</td>
							</tr>
							<tr>
							<td width="90px">检索码:</td>
								<td>
								<div class="form-group">
										<input type="text" name="indexCode" class="form-control"/>
									</div>
									</td>
							</tr>
							<tr>
							<td width="90px">排序:</td>
								<td>
								<div class="form-group">
										<input type="text" name="sortCode" class="form-control"/>
									</div>
									</td>
							</tr>
							<tr>
							<td width="90px">所属医院:</td>
								<td>
								<div class="form-group">
									<select name="hospitalId" class="form-control" id="hospitalId">
										<option value="">请选择</option>
										<c:forEach var="hospital" items="${hospitals}">
											<option value="${hospital.id}">${hospital.name}</option>
										</c:forEach>
									</select>
								</div>
								</td>
							</tr>
							<tr>
									<td width="90px">备注:</td>
									<td>
										<div class="form-group">
											<textarea name="comment"  rows="5" cols="6" class="form-control"></textarea>
										</div>
									</td>
								</tr>
		                    <tr>	
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
<script type="text/javascript" src="${path}/static/js/basic/mrpagetypeform.js"></script>
</html>