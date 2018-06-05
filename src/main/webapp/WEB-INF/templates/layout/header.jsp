<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("basePath", basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="header_top">
	<div class="header_top_ul">
		<img src="${basePath }assets/images/logo.png" />
		<div class="h_right">
			<ul>
				<li><a href="${basePath }index">首页</a>&nbsp;
					<%-- <shiro:authenticated>
						|&nbsp;<a>当前用户：${currentUser.user_name }</a>
						|&nbsp;<a href="${basePath }login_out">退出登陆</a>
					</shiro:authenticated> --%>
					
					
				</li>
				<li>
					<form name="formsearch" action="">
						<input type="hidden" name="kwtype" value="1" /> <input name="q"
							type="text" class="search-keyword" id="search-keyword" value=""
							onFocus="if(this.value==''){this.value='';}"
							onblur="if(this.value==''){this.value='';}" />
						<button type="submit" class="search-submit"></button>
					</form>
				</li>
			</ul>
		</div>
	</div>
</div>

<!------导航条--------->
<div id="nav">
 <ul class="multiUl">
  <li><a href="${basePath }index">首页</a></li>
  <li><a href="${basePath }basic/basic_encoding_index">基本数据</a></li>
  <li><a href="${basePath }holiday/holiday_index">节假日数据</a></li>
  <li><a href="${basePath }quality_control/quality_control_index">质控数据</a></li>
  <li><a href="${basePath }index">ICD数据</a></li>
  <li><a href="${basePath }print/print_index">打印设置</a></li>
 </ul>
</div>