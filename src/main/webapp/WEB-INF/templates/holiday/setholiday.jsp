<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../list.inc"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
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
    		width: 22px;
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
    		background-color: rgb(253, 203, 155);
    	}
    	
    	.red{
    		color: rgb(244, 87, 86);
    	}
    </style>
</head>
<body>
<jsp:include page="../top.jsp"></jsp:include>
	<div style="width: 100%; height:100%;">
		<jsp:include page="../left.jsp"></jsp:include>
		<div style="width:100%; height: 100%;">
			<div id="list_NR" style="float: left;">
				<div class="loc">
					<h3>设置假期</h3>
				</div>
				<div style="width: 100%;height: 100%">
				<div id="holidayValue" style="display: none">${holidays }</div>
        	<div class="div_year_parent">
        		<div class="div_year">
        			<a class="label_a" onclick="lastYear()">上一年</a>  
        			<div class="currentDate" id="currentDate" ></div>
				 	<a class="label_a" onclick="nextYear()">下一年</a>
        		</div>
        	</div>
	        <div id="setDateParent">
	        <ul><li title=""></li></ul>
	        </div>
        </div>
        	</div>
        </div>
        
</div>

<!--JS部分-->
<script type="text/javascript">
	var currentYear = "";
	var holidays = eval($("#holidayValue").text());
	$(function() {
		var myDate = new Date();
		currentYear = myDate.getFullYear();
		
		showYearlyCalendar(currentYear);
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
				content+=monthDays(31,yearMonth);
				break;
				
			case 2:
				if(isLeapYear(currentYear)) {
					content+=monthDays(29,yearMonth);
				}else{
					content+=monthDays(28,yearMonth);
				}
				break;
			
			case 3:
				content+=monthDays(31,yearMonth);
				break;
			
			case 4:
				content+=monthDays(30,yearMonth);
				break;
				
			case 5:
				content+=monthDays(31,yearMonth);
				break;
				
			case 6:
				content+=monthDays(30,yearMonth);
				break;
				
			case 7:
				content+=monthDays(31,yearMonth);
				break;
				
			case 8:
				content+=monthDays(31,yearMonth);
				break;
				
			case 9:
				content+=monthDays(30,yearMonth);
				break;
				
			case 10:
				content+=monthDays(31,yearMonth);
				break;
				
			case 11:
				content+=monthDays(30,yearMonth);
				break;
				
			case 12:
				content+=monthDays(31,yearMonth);
				break;
			}
		}
		
		$("#setDateParent").html("");
		$("#setDateParent").html(content);
	}
	
	function monthDays (thisMonthDays,yearMonth) {
		var content = "";
		for(var j = 1; j <= thisMonthDays; j++) {
			var day = j<10 ? "0"+j : j;
			if(holidays!=null && holidays!=""){
					var n = parseInt(0);
				　　$.each(holidays, function(i, item){ 
					var holidayDate = item.holidaysDate;
					var date = new Array();
						date = holidayDate.split("-");
					if(date[0]+"年-"+date[1]+"月"==yearMonth && date[2]==day){
						content+="<li onclick='setColor(event)' title='"+item.id+"' class='red'>"+day+"</li>";
					}else{
						n = n+1;
					}
					　});
				if(n==holidays.length){
					content+="<li onclick='setColor(event)' title=''>"+day+"</li>";
				}
			}else{
				content+="<li onclick='setColor(event)' title=''>"+day+"</li>";
			}
		
		}
		content+="</ul>";
		content+="</div>";
		return content;
	}
	
	function lastYear(){
		currentYear = currentYear-1;	
		showYearlyCalendar(currentYear);
	}
	
	function nextYear(){
		currentYear = currentYear+1;
		showYearlyCalendar(currentYear);
	}
	
	function setColor(event){
		var $targetObject = $(event.currentTarget);
		$targetObject.toggleClass("red");
		var day = $targetObject.text();
		var yearMonth = $targetObject[0].parentNode.parentNode.previousSibling.innerText.replace("年","").replace("月","");
		var id = $targetObject[0].title;
		var date = yearMonth+"-"+day;
		$.ajax({
            type: "POST",
            
           url:"<%=path%>/holiday/setHoliday?date="+date+"&id="+id,
            success: function(data) {
            	if (data.success==true) {
            		$targetObject[0].title = data.msg;
            	}
            }
        }); 
	}
	
	//判断是否为润年
	function isLeapYear(year) {  return (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0);  }
</script>

</body>
</html>




