<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("basePath", basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
	function loadContent(url) {
		$("#mainContent").attr("src", url);
	}
</script>
<div id="list_main">
	<div id="list_DH">
	  <div class="list_menu2">
	   <h3>手术数据</h3>
	   <h4 class="li_t"><a onclick="loadContent('${basePath }basic/basic_operate_page?tableName=StdIncisionLevel')">切口等级管理</a></h4>
	   <h4 class="li_t"><a onclick="loadContent('${basePath }basic/basic_operate_page?tableName=StdCicatrizationType')">愈合类别管理</a></h4>
	   <h4 class="li_t"><a onclick="loadContent('${basePath }basic/basic_operate_page?tableName=StdOpsLevel')">手术级别管理</a></h4>
	   <h4 class="li_t"><a onclick="loadContent('${basePath }basic/basic_operate_page?tableName=StdAnaesthesiaWay')">麻醉方式管理</a></h4>
	   <h4 class="li_t"><a onclick="loadContent('${basePath }basic/basic_operate_page?tableName=StdAnaesthesiaLevel')">麻醉（ASA）分级管理</a></h4>
	   
	   
	   
	  
	  </div>
	 </div>
	<div id="list_NR">
		<iframe id="mainContent" style="border: 0px; overflow-x: hidden; min-height: 500px;" width="100%"  scrolling="no" src="">
				
		</iframe>
	</div>
</div>
