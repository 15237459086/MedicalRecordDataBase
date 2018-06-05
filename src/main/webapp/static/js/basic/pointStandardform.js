$(function() {
        $('form').bootstrapValidator({
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
            	"project": {
                    validators: {
                        notEmpty: {
                            message: '项目不能为空'
                        },
                        stringLength: {
                            min: 1,
                            max: 169,
                            message: '项目不能超过169个字符'
                        }
                      }
                },
            	"score": {
                    validators: {
                    	numeric: {message: '分数只能输入数字'},
                        stringLength: {
                            min: 1,
                            max: 32,
                            message: '分数不能超过32个字符'
                        }
                        
                    }
                }
            }
        });
    var id = $("#basicId").val();
	var path = $("#path").val();
	
	$("#submit").click(function(){
		var bootstrapValidator = $("form").data('bootstrapValidator');
		bootstrapValidator.validate();
		if(bootstrapValidator.isValid()){
			$("#submit").attr("disabled", true);
			$.ajax({
	            type: "POST",
	           url:$("form").attr("action"),
	            data:$('form').serialize(),
	            success: function(data) {
	            	if (data.success==true) {
	            		if(id!=null &&　id!=""){
	            			   var currentPageCount = $("#currentPage").val();
	            			   var pageCount =$("#pageSize").val();
	            			   var queryName = $("#queryName").val();
	                 		   location.href = path+"/pointStandard/getPointStandards?currentPage="+currentPageCount+"&pageSize="+pageCount
	                 		   +"&name="+queryName;
	            		}else{
	              		   location.href = path+"/pointStandard/getPointStandards";
	            		}
	    			} else {
	    				$("#info").text("操作执行失败，请重试");
	    				$("#submit").attr("disabled", false);
	    			}
	            }
	        }); 
		}
		
	});
	
	$("#back").click(function(){
		location.href=path+"/pointStandard/getPointStandards";
	});
	
});