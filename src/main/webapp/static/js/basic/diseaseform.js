$(function() {
	$('#fitManCodeFlag').click(function () {
        var fitManCodeFlag = $("#fitManCodeFlag");
        var checked = fitManCodeFlag.prop('checked');
        if (checked) {
        	fitManCodeFlag.prop('checked',true);
        	fitManCodeFlag.val("1");
        } else {
        	fitManCodeFlag.prop('checked',false);
        	fitManCodeFlag.val("");
        }
      });
	
	$('#womanCodeFlag').click(function () {
        var womanCodeFlag = $("#womanCodeFlag");
        var checked = womanCodeFlag.prop('checked');
        if (checked) {
        	womanCodeFlag.prop('checked',true);
        	womanCodeFlag.val("1");
        } else {
        	womanCodeFlag.prop('checked',false);
        	womanCodeFlag.val("");
        }
      });
	$('#undeathFlag').click(function () {
        var undeathFlag = $("#undeathFlag");
        var checked = undeathFlag.prop('checked');
        if (checked) {
        	undeathFlag.prop('checked', true);
        	undeathFlag.val("1");
        } else {
        	undeathFlag.prop('checked',false);
        	undeathFlag.val("");
        }
      });
	
      $('#unPrimaryFlag').click(function () {
          var unPrimaryFlag = $("#unPrimaryFlag");
          var checked = unPrimaryFlag.prop('checked');
          if (checked) {
        	  unPrimaryFlag.prop('checked', true);
        	  unPrimaryFlag.val("1");
          } else {
        	  unPrimaryFlag.prop('checked', false);
        	  unPrimaryFlag.val("");
          }
        });
        $('#attentionFlag').click(function () {
            var attentionFlag = $("#attentionFlag");
            var checked = attentionFlag.prop('checked');
            if (checked) {
            	attentionFlag.prop('checked', true);
            	attentionFlag.val("1");
            } else {
            	attentionFlag.prop('checked',false);
            	attentionFlag.val("");
            }
          });
      
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
                        notEmpty: {
                            message: '检索码不能为空'
                        },
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
                "attributeId": {
                    validators: {
                    	 notEmpty: {
                             message: '请选择编码属性'
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
                "provinceCode": {
                    validators: {
                        stringLength: {
                            min:1,
                            max:200,
                            message: '长度不能超过200个字符'
                        }
                    }
                }, "regionCode": {
                    validators: {
                        stringLength: {
                            min:1,
                            max:200,
                            message: '长度不能超过200个字符'
                        }
                    }
                }, "interDiseaseVersion": {
                    validators: {
                        stringLength: {
                            min:1,
                            max:200,
                            message: '长度不能超过200个字符'
                        }
                    }
                },
                "attentionComment": {
                    validators: {
                        stringLength: {
                            min:1,
                            max:1500,
                            message: '诊断原因不能超过1500个字符'
                        }
                    }
                },
                "clinicalDiagnosis": {
                    validators: {
                        stringLength: {
                            min:1,
                            max:200,
                            message: '临床诊断不能超过200个字符'
                        }
                    }
                },
                "diagnosisIndex": {
                    validators: {
                        stringLength: {
                            min:1,
                            max:200,
                            message: '临床诊断索引不能超过200个字符'
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
	                 		   location.href = path+"/basic/getDiseases?currentPage="+currentPageCount+"&pageSize="+pageCount
	                 		   +"&name="+queryName+"&code="+querycode+"&indexCode="+indexCode;
	            		}else{
	              		   location.href = path+"/basic/getDiseases";
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
		location.href=path+"/basic/getDiseases";
	});
	
});