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
	   <h3>打印设置</h3>
	   <h4 class="li_t"><a onclick="loadContent('${basePath }basic/basic_encoding_page?tableName=MrPageType')">编页标签管理</a></h4>
	   <h4 class="li_t"><a onclick="loadContent('${basePath }basic/basic_encoding_page?tableName=MrPrinterType')">打印类型管理</a></h4>
	   <h4 class="li_t"><a onclick="loadContent('${basePath }print/print_type_page')">打印内容设置</a></h4>
	  </div>
	 </div>
	<div id="list_NR">
		<iframe id="mainContent" style="border: 0px; overflow-x: hidden; min-height: 500px;" width="100%"  scrolling="no" src="">
				
		</iframe>
	</div>
</div>
