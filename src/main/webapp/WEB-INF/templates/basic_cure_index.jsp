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
	   <h3>治疗数据</h3>
	   <h4 class="li_t"><a onclick="loadContent('${basePath }basic/basic_cure_page?tableName=BloodType')">ABO血型管理</a></h4>
	   <h4 class="li_t"><a onclick="loadContent('${basePath }basic/basic_cure_page?tableName=RhBloodType')">RH血型管理</a></h4>
	   <h4 class="li_t"><a onclick="loadContent('${basePath }basic/basic_cure_page?tableName=BodyPart')">身体部位管理</a></h4>
	   <h4 class="li_t"><a onclick="loadContent('${basePath }basic/basic_cure_page?tableName=DiagnosticCoincidenceType')">诊断符合管理</a></h4>
	   <h4 class="li_t"><a onclick="loadContent('${basePath }basic/basic_cure_page?tableName=DiagnoseType')">诊断类型管理</a></h4>
	   <h4 class="li_t"><a onclick="loadContent('${basePath }basic/basic_cure_page?tableName=TreatmentResult')">治疗结果管理</a></h4>
	   <h4 class="li_t"><a onclick="loadContent('${basePath }basic/basic_cure_page?tableName=InHospitalizationDiseaseState')">诊断状况管理</a></h4>
	   <h4 class="li_t"><a onclick="loadContent('${basePath }basic/basic_cure_page?tableName=RehospitalizationAim')">再住院目的管理</a></h4>
	   <h4 class="li_t"><a onclick="loadContent('${basePath }basic/basic_cure_page?tableName=HospitalizationDealthReason')">死亡原因管理</a></h4>
	  </div>
	 </div>
	<div id="list_NR">
		<iframe id="mainContent" style="border: 0px; overflow-x: hidden; min-height: 500px;" width="100%"  scrolling="no" src="">
				
		</iframe>
	</div>
</div>
