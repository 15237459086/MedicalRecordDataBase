<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/base_resource.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="${basePath}assets/multiselect-master/css/style.css" />
<script type="text/javascript" src="${basePath}assets/js/iframe.js"></script>
<script type="text/javascript" src="${basePath}assets/multiselect-master/js/multiselect.js"></script>
<style type="text/css">
    	.div_setDate{
    		width: 100%; 
    		padding: 3px 0px 3px 2px;
    		border: 1px solid rgb(242, 242, 242);
    	}
    	
    	.div_setMonth{
    		background-color: rgb(229, 229, 229);
    		width: 100%;
    		height: 30px;
    	}
    	
    	.div_setMonth ul{
    		height: 30px;
    		text-align: center;
    	}
    	
    	.div_setMonth ul li{
    		float: left;
    		border: 1px solid rgb(242, 242, 242);
    		width: 28px;
    		line-height: 30px;
    		cursor: pointer;
    	}
    	
    	.label_a{
    		width: 60px;
			height: 32px;
			float: left;
			margin: 5px 2px auto 5px;
			line-height: 32px;
			font-family: "微锟斤拷锟脚猴拷";
			font-size: 14px;
			color: #fff;
			cursor:pointer;
			text-align: center;
			background: #039b8e;
			border-radius: 5px;
    	}
    	
    	.div_year{
    		text-align: center;
    		margin: 0 auto;
    		width: 250px;
    	}
    	
    	.currentDate{
    		float: left;
    		margin-left: 8px;
    		margin-right: 8px;
    		line-height: 43px;
    		font-weight: bold;
    	}
    	
    	.div_year_parent{
    		width: 100%; 
    		height: 43px; 
    	}
    	
    	.red{
    		color: rgb(244, 87, 86);
    	}
    </style>
<div class="loc">
	<h3>节假日设置</h3>
	<ul class="loc_loc"><li> 当前位置：节假日数据 > 节假日设置</li>
	</ul>
	
</div>
<div class="list_con_table">
	<input type="hidden" id="basePath" value="${basePath }"/>
	<div class="div_year_parent">
		<div class="div_year">
			<a class="label_a" onclick="lastYear()">上一年</a>
			<div class="currentDate" id="currentDate"></div>
			<a class="label_a" onclick="nextYear()">下一年</a>
			<input type="button" style="margin-top: 10px;" value="初始化" onclick="initHoliday()"/>
		</div>
	</div>
	<div id="setDateParent">
		<ul>
			<li title=""></li>
		</ul>
	</div>
</div>

<script type="text/javascript">
	var currentYear = "";
	$(function() {
		
		var myDate = new Date();
		currentYear = myDate.getFullYear();
		paddingHoliday(currentYear);
		
	});

	function showYearlyCalendar(currentYear) {
		$("#currentDate").text(currentYear);
		
		var content = "";
		for(var i = 1; i <= 12; i++) {
			var month = i < 10 ? "0"+i : i;
			var yearMonth = currentYear+"年-"+(month)+"月";
			content+="<div class='div_setDate'>"+yearMonth+"</div>";
			content+="<div class='div_setMonth'>";
			content+="<ul >";
			
			switch (i) {
			case 1:
				content+=monthDays(31,month);
				break;
				
			case 2:
				if(isLeapYear(currentYear)) {
					content+=monthDays(29,month);
				}else{
					content+=monthDays(28,month);
				}
				break;
			
			case 3:
				content+=monthDays(31,month);
				break;
			
			case 4:
				content+=monthDays(30,month);
				break;
				
			case 5:
				content+=monthDays(31,month);
				break;
				
			case 6:
				content+=monthDays(30,month);
				break;
				
			case 7:
				content+=monthDays(31,month);
				break;
				
			case 8:
				content+=monthDays(31,month);
				break;
				
			case 9:
				content+=monthDays(30,month);
				break;
				
			case 10:
				content+=monthDays(31,month);
				break;
				
			case 11:
				content+=monthDays(30,month);
				break;
				
			case 12:
				content+=monthDays(31,month);
				break;
			}
		}
		$("#setDateParent").html(content);
	}
	
	function monthDays (thisMonthDays,manth) {
		var content = "";
		for(var j = 1; j <= thisMonthDays; j++) {
			var day = j<10 ? "0"+j : j;
			/* if(holidays!=null && holidays!=""){
					var n = parseInt(0);
				　　$.each(holidays, function(i, item){ 
					var holidayDate = item.holidaysDate;
					var date = new Array();
						date = holidayDate.split("-");
					if(date[0]+"年-"+date[1]+"月"==yearMonth && date[2]==day){
						content+="<li onclick='setColor(event)' data= title='"+item.id+"' class='red'>"+day+"</li>";
					}else{
						n = n+1;
					}
					　});
				if(n==holidays.length){
					content+="<li onclick='setColor(event)' title=''>"+day+"</li>";
				}
			}else{
				content+="<li onclick='setColor(event)' title=''>"+day+"</li>";
			} */
			content+="<li onclick='setColor(event)' title='"+currentYear+"-"+manth+"-"+day+"'>"+day+"</li>";
		
		}
		content+="</ul>";
		content+="</div>";
		return content;
	}
	
	function lastYear(){
		currentYear = currentYear-1;
		$("#setDateParent").html("");
		paddingHoliday(currentYear);
	}
	
	function nextYear(){
		currentYear = currentYear+1;
		$("#setDateParent").html("");
		paddingHoliday(currentYear);
	}
	
	function setColor(event){
		var basePath = $("#basePath").val();
		var $targetObject = $(event.currentTarget);
		var obj = $($targetObject[0]);
		var tag = 0;
		if(obj.hasClass("red")){
			tag="0";
		}else{
			tag="1";
		}
		
		var date = $targetObject[0].title;
		$.ajax({
           	type: "POST",
           	url:basePath+"holiday/set_holiday",
           	data:{date:date,tag:tag},
            success: function(data) {
            	var success = data['success'];
            	var stateCode = data['stateCode'];
            	var stateMessage = data['stateMessage'];
            	if (success) {
            		if(stateCode =="1"){
            			if(tag =="1"){
            				obj.addClass("red");
            			}else{
            				obj.removeClass("red");
            			}
            			
            		}else{
            			layer.msg(stateMessage);
            		}
            	}
            },
            error:function(XMLHttpRequest, textStatus, errorThrown){
				layer.msg("未知错误，请联系管理员");
			}
        }); 
	}
	
	function paddingHoliday(currentYear){
		var basePath = $("#basePath").val();
		$.ajax({
           	type: "get",
           	url:basePath+"holiday/query_holiday",
           	data:{year:currentYear},
            success: function(data) {
            	var holidays = data['data'];
            	console.log(holidays);
            	showYearlyCalendar(currentYear);
				iframeAutoHeight("mainContent");
            	for(var index in holidays){
            		var holiday = holidays[index];
            		$("li[title='"+holiday+"']").addClass("red");
            	}
            	
            },
            error:function(XMLHttpRequest, textStatus, errorThrown){
				layer.msg("未知错误，请联系管理员");
			}
        }); 
	
	}
	
	function initHoliday(){
		 if(!window.confirm("确定要初始化吗？")){
		 	return;
		 }
		var basePath = $("#basePath").val();
		var initYear = $("#currentDate").html();
		layer.load(1);
		/* layer.msg(currentYear); */
		/* alert(currentYear); */
		$.ajax({
           	type: "POST",
           	url:basePath+"holiday/init_holiday",
           	data:{year:initYear},
            success: function(data) {
            	var holidays = data['data'];
            	console.log(holidays);
            	var success = data['success'];
            	var stateCode = data['stateCode'];
            	var stateMessage = data['stateMessage'];
            	if (success) {
            		$("li").removeClass("red");
            		for(var index in holidays){
	            		var holiday = holidays[index];
	            		$("li[title='"+holiday+"']").addClass("red");
	            	}
	            	layer.msg("初始化完成");
            	}else{
            		layer.msg("初始化错误");
            	}
            },
            error:function(XMLHttpRequest, textStatus, errorThrown){
				layer.msg("未知错误，请联系管理员");
			},complete:function(XMLHttpRequest, textStatus){
				layer.closeAll('loading');
			}
        }); 
	}
	
	//判断是否为润年
	function isLeapYear(year) {  return (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0);  }
</script>

