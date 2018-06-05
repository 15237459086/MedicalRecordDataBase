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
                            max: 200,
                            message: '编码不能超过200个字符'
                        }
                      }
                },
            	"indexCode": {
                    validators: {
                        stringLength: {
                            min: 1,
                            max: 200,
                            message: '检索码不能超过200个字符'
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
                "enName": {
                    validators: {
                        stringLength: {
                            min:1,
                            max: 200,
                            message: '英文不能超过200个字符'
                        }
                    }
                },
                "aliasName": {
                    validators: {
                        stringLength: {
                            min:1,
                            max:200,
                            message: '别名不能超过200个字符'
                        }
                    }
                },
                "aliasNameIndex": {
                    validators: {
                        stringLength: {
                            min:1,
                            max:200,
                            message: '别名索引不能超过200个字符'
                        }
                    }
                },
                "comment": {
                    validators: {
                        stringLength: {
                            min:1,
                            max:1500,
                            message: '备注不能超过1500个字符'
                        }
                    }
                }
            }
        });
        var code = $("#basicCode").val();	
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
	            		
	            		if(code!=null &&　code!=""){
	            			   var currentPageCount = $("#currentPage").val();
	            			   var pageCount =$("#pageSize").val();
	            			   var queryName = $("#queryName").val();
	            			   var indexCode = $("#queryIndexCode").val();
	            			   var querycode = $("#querycode").val();
	                 		   location.href = path+"/morphological/getMorphologicalRc021Icds?currentPage="+currentPageCount+"&pageSize="+pageCount
	                 		   +"&name="+queryName+"&code="+querycode+"&indexCode="+indexCode;
	            		}else{
	              		   location.href = path+"/morphological/getMorphologicalRc021Icds";
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
		location.href=path+"/morphological/getMorphologicalRc021Icds";
	});
	
});