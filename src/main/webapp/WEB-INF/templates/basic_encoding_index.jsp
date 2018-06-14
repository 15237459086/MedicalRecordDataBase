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
	   <h3>基本数据</h3>
	   <h4 class="li_t"><a onclick="loadContent('${basePath }basic/basic_encoding_page?tableName=Sex')">性别管理</a></h4>
	   <h4 class="li_t"><a onclick="loadContent('${basePath }basic/basic_encoding_page?tableName=Marriage')">婚姻管理</a></h4>
	   <h4 class="li_t"><a onclick="loadContent('${basePath }basic/basic_encoding_page?tableName=Profession')">职业管理</a></h4>
	   <h4 class="li_t"><a onclick="loadContent('${basePath }basic/basic_encoding_page?tableName=RelativeRelation')">亲属关系管理</a></h4>
	   <h4 class="li_t"><a onclick="loadContent('${basePath }basic/basic_encoding_page?tableName=Nationality')">国籍管理</a></h4>
	   <h4 class="li_t"><a onclick="loadContent('${basePath }basic/basic_encoding_page?tableName=Nation')">民族管理</a></h4>
	   <h4 class="li_t"><a onclick="loadContent('${basePath }basic/basic_encoding_page?tableName=MedicalPaymentType')">付费方式管理</a></h4>
	   <h4 class="li_t"><a onclick="loadContent('${basePath }basic/basic_encoding_page?tableName=IdentityDocumentType')">证件类型管理</a></h4>
	   <h4 class="li_t"><a onclick="loadContent('${basePath }basic/basic_encoding_page?tableName=InHospitalType')">入院方式管理</a></h4>
	   <h4 class="li_t"><a onclick="loadContent('${basePath }basic/basic_encoding_page?tableName=InHospitalizationState')">入院病情管理</a></h4>
	   <h4 class="li_t"><a onclick="loadContent('${basePath }basic/basic_encoding_page?tableName=OutHospitalType')">离院方式管理</a></h4>
	   
	   
	  
	  </div>
	 </div>
	<div id="list_NR">
		<iframe id="mainContent" style="border: 0px; overflow-x: hidden; min-height: 500px;" width="100%"  scrolling="no" src="">
				
		</iframe>
	</div>
</div>
