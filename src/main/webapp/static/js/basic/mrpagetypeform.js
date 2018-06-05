$(function() {
	
	$('form').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	"code": {
                validators: {
                    notEmpty: {
                        message: '编码不能为空'
                    },
                    stringLength: {
                        min: 1,
                        max: 20,
                        message: '编码不能超过20个字符'
                    }
                    
                }
            },
            "name": {
                validators: {
                	 notEmpty: {
                         message: '名称不能为空'
                     },
                    stringLength: {
                        min:1,
                        max: 200,
                        message: '名称不能超过200个字符'
                    }
                }
            },
            "indexCode":{
            	validators:{
            		notEmpty:{
            			message:'检索码不能为空'
            		},
                    stringLength: {
                        min:1,
                        max: 200,
                        message: '检索码不能超过200个字符'
                    }
            	}
            },"sortCode":{
            	validators:{
            		notEmpty:{
            			message:'排序码不能为空'
            		},
                    stringLength: {
                        min:1,
                        max: 200,
                        message: '排序码不能超过200个字符'
                    }
            	}
            },
            "hospitalId":{
            	validators:{
            		notEmpty:{
            			message:'请选择医院'
            		}
            	}
            }
        }
    });
	
	var pageTypeId = $("#basicId").val();
	
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
	            		if(pageTypeId!=null &&　pageTypeId!=""){
	            			   var currentPageCount = $("#currentPage").val();
	            			   var pageCount =$("#pageSize").val();
	            			   var queryName = $("#queryName").val();
	            			   var hospitalId = $("#queryHospitalId").val();
	                 		   location.href = path+"/basic/getMrPageTypes?currentPage="+currentPageCount+"&pageSize="+pageCount+"&name="+queryName+"&hospitalId="+hospitalId;
	            		}else{
	              		   location.href = path+"/basic/getMrPageTypes";
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
		location.href=path+"/basic/getMrPageTypes";
	});
	
});