$(function() {
	$('#pageTypeId').selectpicker({
		width:'350px'
	});
			
	var basicId = $("#basicId").val();
	if(basicId!=""){
		var pageTypeIds = $("#basicPageTypeIds").val();
		  var ids = new Array();
		  ids = pageTypeIds.split(",");
		$('#pageTypeId').selectpicker('val',ids);
	}
	
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
            },"indexCode": {
                validators: {
               	
                   stringLength: {
                       min:1,
                       max: 200,
                       message: '检索码不能超过200个字符'
                   }
               }
           },"enName": {
                validators: {
               	
                   stringLength: {
                       min:1,
                       max: 200,
                       message: '英文名称不能超过200个字符'
                   }
               }
           },"hospitalId": {
        	   validators: {
        		   notEmpty: {
                       message: '请选择所属医院'
                   }
        	   }
           },"comment": {
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
		            		if(basicId!=null &&　basicId!=""){
		            			   var currentPageCount = $("#currentPage").val();
		            			   var pageCount =$("#pageSize").val();
		            			   var queryName = $("#queryName").val();
		            			   var hospitalId = $("#queryHospitalId").val();
		                 		   location.href = path+"/basic/getMrPrinterTypes?currentPage="+currentPageCount+"&pageSize="+pageCount+"&name="+queryName+"&hospitalId="+hospitalId;
		            		}else{
		              		   location.href = path+"/basic/getMrPrinterTypes";
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
		location.href=path+"/basic/getMrPrinterTypes";
	});
	
	$("#hospitalId").change(function(){
		var hospitalId = $("#hospitalId").val();
		if(hospitalId!=null &&　hospitalId!=""){
			$.ajax({
				type : "post",
				url : path+"/basic/getPageTypeListByHospitalId",
				data : {
					hospitalId : hospitalId
				},
				success : function(data) {
					if (data.success == true) {
						$("#pageTypeId").empty();
						var printType = data.data;
							for (var i = 0; i < printType.length; i++) {
								$("#pageTypeId").append("<option value='" + printType[i].id
												+ "'>" + printType[i].name
												+ "</option>");
							}
							$('#pageTypeId').selectpicker('refresh');
					}
				}
			});
		}else{
			$("#pageTypeId").empty();
			$('#pageTypeId').selectpicker('refresh');
		}
		
	});
});