/**
 * 选择提示信息框
 * @param callback 不带参数的方法名
 */
function confirm(title,content,sureCallback,cancleCallback){
	   $.confirm({
		   icon:"fa fa-warning",
			title:title,
			type: 'blue',
			content:content,
			 buttons:{
				 "确定": {
					 btnClass: 'btn-info',
					 action: function(){
						 sureCallback();
					 }
				 },
			     "取消":{
			    	 btnClass: 'btn-danger',
			    	 action:function(){
			    		 cancleCallback();
			    	 }
			     }
			 }
		});
}


function showWarnMsg(title,content){
	$.alert({
		 icon: 'fa fa-warning',
		type: 'blue',
		title:title,
		content:content,
		 buttons:{
			 "确定": {
				 btnClass: 'btn-warning'
			 }
		 }
	});
}


function showfailMsg(title,content){
	$.alert({
		 icon: 'fa fa-error',
		type: 'blue',
		title:title,
		content:content,
		 buttons:{
				"确定": {
					 btnClass: 'btn-danger'
				 }
		 }
	});
}