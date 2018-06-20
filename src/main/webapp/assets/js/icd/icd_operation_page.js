function init(baseInfoJson){
	$("select").each(function(){
		$(this).append("<option value=''>---请选择---</option>");
	});
	
	var opsMarks = baseInfoJson['opsMarks'];//手术标识
	$("select[name='operationMarkCode']").each(function(){
		var options = "";
		for(var index in opsMarks){
			var opsMark = opsMarks[index];
	    	options+="<option value='"+opsMark.code+"'>"+opsMark.name+"</option>"
	    } 
       $(this).append(options);
	});
	
	var incisionLevels = baseInfoJson['incisionLevels'];//切口等级
	$("select[name='incisionLevelCode']").each(function(){
		var options = "";
		for(var index in incisionLevels){
			var incisionLevel = incisionLevels[index];
	    	options+="<option value='"+incisionLevel.code+"'>"+incisionLevel.name+"</option>"
	    } 
       $(this).append(options);
	});
	
	
	var opsLevels = baseInfoJson['opsLevels'];//手术等级
	$("select[name='operationLevelCode']").each(function(){
		var options = "";
		for(var index in opsLevels){
			var opsLevel = opsLevels[index];
	    	options+="<option value='"+opsLevel.code+"'>"+opsLevel.name+"</option>"
	    } 
       $(this).append(options);
	});
	
	var basePath = $("#basePath").val();
	
	var validator = $("#queryForm").validate({
		errorElement: "title",
		ignoreTitle: true,
		submitHandler : function(){
			queryFormSubmit();
			/*return false;*/
		},
		rules:{
			code: {
                minlength: 2,
                maxlength: 20
            },
            name: {
                minlength: 2,
                maxlength: 20
            },
            indexCode: {
                minlength: 2,
                maxlength: 20
            }
			
		},
		
	});
}
$(function(){
	
});




/*点击查询按钮*/
function queryBtnClick(){
	$("input[name='currentPage']").val(1);
	$("#queryForm").submit();
}

/*提交查询*/
function queryFormSubmit(){
	var submitData = $('#queryForm').serialize();
	var basePath = $("#basePath").val();
	layer.load(1);
	
	clearPage();
	$.ajax({
		url: basePath + "icd/query_icd_operation",
		dataType: "json",
		data:submitData,
		success: function( data ) {
			var success = data['success'];
			if(success){
				
				var params = data['data'];
				var totalCounts = params['totalCounts'];
				if(totalCounts > 0){
					layer.msg("查询成功");
					var operations = params['queryDatas'];
					addRows(operations);
					var pageSize = params['pageSize'];
					var currentPage = params['currentPage'];
					initPage(parseInt(totalCounts),parseInt(pageSize),parseInt(currentPage));
				}else{
					layer.msg("查询结果为空");
				}
				
			}else{
				layer.msg("查询失败");
			}
			console.log(data);
			
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			layer.msg("未知错误，请联系管理员");
		},
		complete:function(XMLHttpRequest, textStatus){
			layer.closeAll('loading');
		}
	});
	
};

/*清空列表和分页控件*/
function clearPage(){
	$("#template_tr").siblings("tr").remove();
	$("#page_plus").html("");
	$("#totalPage").html("0");
    $("#currentPage").html("0/0");
}


/*初始化分页控件*/
function initPage(totalCounts,pageSize,currentPage){
	 var visiblePages = 5;
	 var totalPages =  totalCounts%pageSize==0?(totalCounts/pageSize):(parseInt(totalCounts/pageSize)+1);
	 if(totalCounts < 1){
		$("#page_plus").html("");
		$("#totalPage").html("0");
        $("#currentPage").html("0/0");
	 }else{
		 $('#page_plus').jqPaginator({

	        totalCounts: totalCounts,
	        pageSize:pageSize,
	        visiblePages: visiblePages,
	        currentPage: currentPage,

	        first:'<li class="first"><a href="javascript:void(0);">首页</a></li>',
	        prev: '<li class="prev"><a href="javascript:void(0);">上一页</a></li>',
	        next: '<li class="next"><a href="javascript:void(0);">下一页</a></li>',
	        last: '<li class="last"><a href="javascript:void(0);">末页</a></li>',
	        page: '<li class="page"><a href="javascript:void(0);">{{page}}</a></li>',
	        onPageChange: function (num,type) {

	     		if(type !='init'){
	     			$("input[name='currentPage']").val(num);
	     			queryFormSubmit();
				}
	            $("#totalPage").html(totalCounts);
	            $("#currentPage").html(num+"/"+totalPages);
	        }
	    });
	 }
}


/*添加列表行*/
function addRows(operations){
	for(var index in operations){
		var operation = operations[index];
		var add_content=$("#template_tr").clone();
		add_content.removeAttr("hidden");
		add_content.attr("id",operation.code);
		add_content.find("span[class='code']").html(operation.code);
		add_content.find("span[class='name']").html(operation.name);
		add_content.find("span[class='index_code']").html(operation.index_code);
		$("#query_show_table tbody").append(add_content);
    } 
	
}


//显示新建数据Layer
var layerCreateOperationIndex
function layerCreatOperation(){
	
	var add_content=$("#create_disease_div").clone();
	add_content.find("form").attr("id","crate_operation_form");
	var title = "新建ICD_9_CM";
	layerCreateOperationIndex = layer.open({
		  type: 1,
		  title:title,
		  skin: 'layui-layer-rim', //加上边框
		  area: ['740px', '400px'], //宽高
		  content: add_content.html(),
		  success: function(layero, index){
			  $("#crate_operation_form select[data-type='code_name']").each(function(){
					
			       $(this).change(function(){
				   		var eventObj = $(this);
				   		var nameObjName = eventObj.attr("name").replace("Code", "Name");
				   		
				   		if(eventObj.val()!=""){
				   			var name=eventObj.find("option:selected").text();
				   			eventObj.next("input[name='"+nameObjName+"']").val(name);
				   		}else{
				   			eventObj.next("input[name='"+nameObjName+"']").val("");
				   		}
				   	});
			      
				});
			  
			  
			  var validator = $("#crate_operation_form").validate({
					errorElement: "title",
					ignoreTitle: true,
					submitHandler : function(){
						createOperationFormSubmit();
					},
					rules:{
						code: {
							required: true,
			                minlength: 1,
			                maxlength: 20
			            },
			            name: {
			            	required: true,
			                minlength: 1,
			                maxlength: 20
			            }
						
					},
					
				});
			  
		  }
		});
}

function createBtnClick(){
	$("#crate_operation_form").submit();
}


//提交新建数据
function createOperationFormSubmit(){
	layer.load(1);
	var basePath = $("#basePath").val();
	var submitData = $('#crate_operation_form').serialize();
	$.ajax({
		url: basePath + "icd/create_icd_operation",
		type: "POST",
		dataType: "json",
		data:submitData,
		success: function( data ) {
			var success = data['success'];
			if(success){
				var stateCode = data['stateCode'];
				var stateMessage = data['stateMessage'];
				if("1" == stateCode){
					layer.msg(stateMessage);
					layer.close(layerCreateOperationIndex);
					var operation = data['data'];
					addRow(operation);
					
				}else if("2" == stateCode){
					layer.msg(stateMessage);
				}else{
					layer.msg(stateMessage);
				}
			}else{
				layer.msg("操作错误，请重试！");
			}
			console.log(data);
			
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			layer.msg("未知错误，请联系管理员");
		},
		complete:function(XMLHttpRequest, textStatus){
			layer.closeAll('loading');
		}
	});
}

/*添加列表行*/
function addRow(operation){
	var add_content=$("#template_tr").clone();
	add_content.removeAttr("hidden");
	add_content.attr("id",operation.code);
	add_content.find("span[class='code']").html(operation.code);
	add_content.find("span[class='name']").html(operation.name);
	add_content.find("span[class='index_code']").html(operation.indexCode);
	$("#query_show_table tbody").append(add_content);
}


function layerShow(obj){
	var basePath = $("#basePath").val();
	var content = $(obj).parent().parent();
	var code = content.attr("id");
	
	
	var add_content=$("#show_operation_div").clone();
	add_content.find("form").attr("id","show_form");
	var title = "预览ICD_9_CM";
	
	layer.open({
		  type: 1,
		  title:title,
		  skin: 'layui-layer-rim', //加上边框
		  area: ['740px', '400px'], //宽高
		  content: add_content.html(),
		  success: function(layero, index){
			  $.ajax({
					url: basePath + "icd/show_icd_operation",
					type: "GET",
					dataType: "json",
					data:{code:code},
					success: function( data ) {
						var success = data['success'];
						if(success){
							var stateCode = data['stateCode'];
							var stateMessage = data['stateMessage'];
							if("1" == stateCode){
								/*layer.close(layerCreateDiseaseIndex);*/
								var operation = data['data'];
								$("#show_form input[name='code']").val(operation.code);
								$("#show_form input[name='name']").val(operation.name);
								$("#show_form input[name='enName']").val(operation.enName);
								$("#show_form input[name='indexCode']").val(operation.indexCode);
								$("#show_form input[name='aliasName']").val(operation.aliasName);
								$("#show_form input[name='aliasNameIndex']").val(operation.aliasNameIndex);
								$("#show_form input[name='operationMarkName']").val(operation.operationMarkName);
								$("#show_form input[name='incisionLevelName']").val(operation.incisionLevelName);
								$("#show_form input[name='operationLevelName']").val(operation.operationLevelName);
								$("#show_form input[name='comment']").val(operation.comment);
								
								/*$("#update_disease_form input[name='fitManCodeFlag'][value='"+disease.fitManCodeFlag+"']").attr("checked",true);
								$("#update_disease_form input[name='fitWomanCodeFlag'][value='"+disease.fitWomanCodeFlag+"']").attr("checked",true);
								$("#update_disease_form input[name='unDeathFlag'][value='"+disease.unDeathFlag+"']").attr("checked",true);
								$("#update_disease_form input[name='unPrimaryFlag'][value='"+disease.unPrimaryFlag+"']").attr("checked",true);
								$("#update_disease_form input[name='attentionFlag'][value='"+disease.attentionFlag+"']").attr("checked",true);
								$("#update_disease_form input[name='attentionComment']").val(disease.attentionComment);*/
								/*$("#update_disease_form input[name='comment']").val(disease.comment);*/
								/*addRow(basicData);*/
							}else{
								layer.msg(stateMessage);
							}
						}else{
							layer.msg("操作错误，请重试！");
						}
						console.log(data);
						
					},
					error:function(XMLHttpRequest, textStatus, errorThrown){
						layer.msg("未知错误，请联系管理员");
					},
					complete:function(XMLHttpRequest, textStatus){
						layer.closeAll('loading');
					}
				});
			  var validator = $("#update_operation_form").validate({
					errorElement: "title",
					ignoreTitle: true,
					submitHandler : function(){
						updateOperationFormSubmit();
					},
					rules:{
						code: {
							required: true,
			                minlength: 1,
			                maxlength: 20
			            },
			            name: {
			            	required: true,
			                minlength: 1,
			                maxlength: 20
			            }
						
					},
					
				});
			  
		  }
		});
}

//显示编辑数据Layer
var layerUpdateOperationIndex
function layerUpdateOperation(obj){
	var basePath = $("#basePath").val();
	var content = $(obj).parent().parent();
	var code = content.attr("id");
	
	
	var add_content=$("#update_operation_div").clone();
	add_content.find("form").attr("id","update_operation_form");
	var title = "编辑ICD_9_CM";
	
	layerUpdateOperationIndex = layer.open({
		  type: 1,
		  title:title,
		  skin: 'layui-layer-rim', //加上边框
		  area: ['740px', '400px'], //宽高
		  content: add_content.html(),
		  success: function(layero, index){
			  $.ajax({
					url: basePath + "icd/show_icd_operation",
					type: "GET",
					dataType: "json",
					data:{code:code},
					success: function( data ) {
						var success = data['success'];
						if(success){
							var stateCode = data['stateCode'];
							var stateMessage = data['stateMessage'];
							if("1" == stateCode){
								/*layer.close(layerCreateDiseaseIndex);*/
								var operation = data['data'];
								$("#update_operation_form input[name='code']").val(operation.code);
								$("#update_operation_form input[name='name']").val(operation.name);
								$("#update_operation_form input[name='enName']").val(operation.enName);
								$("#update_operation_form input[name='indexCode']").val(operation.indexCode);
								$("#update_operation_form input[name='aliasName']").val(operation.aliasName);
								$("#update_operation_form input[name='aliasNameIndex']").val(operation.aliasNameIndex);
								$("#update_operation_form input[name='comment']").val(operation.comment);
								$("#update_operation_form select[name='operationMarkCode']").each(function(){
									
							       $(this).change(function(){
								   		var eventObj = $(this);
								   		var nameObjName = eventObj.attr("name").replace("Code", "Name");
								   		
								   		if(eventObj.val()!=""){
								   			var name=eventObj.find("option:selected").text();
								   			eventObj.next("input[name='"+nameObjName+"']").val(name);
								   		}else{
								   			eventObj.next("input[name='"+nameObjName+"']").val("");
								   		}
								   	});
							       var eventObj = $(this);
								   var nameObjName = eventObj.attr("name").replace("Code", "Name");
							       if(operation.operationMarkCode){
							    	   var selectOption = eventObj.find("option[value='"+operation.operationMarkCode+"']")
										if(selectOption.length > 0){
											selectOption.attr("selected",true);
										}else{
											eventObj.append("<option selected='selected' value='"+operation.operationMarkCode+"'>"+operation.operationMarkName+"</option>");
										}
							       }
							       eventObj.next("input[name='"+nameObjName+"']").val(operation.operationMarkName);
								});
								
								$("#update_operation_form select[name='incisionLevelCode']").each(function(){
									
								       $(this).change(function(){
									   		var eventObj = $(this);
									   		var nameObjName = eventObj.attr("name").replace("Code", "Name");
									   		
									   		if(eventObj.val()!=""){
									   			var name=eventObj.find("option:selected").text();
									   			eventObj.next("input[name='"+nameObjName+"']").val(name);
									   		}else{
									   			eventObj.next("input[name='"+nameObjName+"']").val("");
									   		}
									   	});
								       var eventObj = $(this);
									   var nameObjName = eventObj.attr("name").replace("Code", "Name");
								       if(operation.incisionLevelCode){
								    	   var selectOption = eventObj.find("option[value='"+operation.incisionLevelCode+"']")
											if(selectOption.length > 0){
												selectOption.attr("selected",true);
											}else{
												eventObj.append("<option selected='selected' value='"+operation.incisionLevelCode+"'>"+operation.incisionLevelName+"</option>");
											}
								       }
								       eventObj.next("input[name='"+nameObjName+"']").val(operation.incisionLevelName);
								});
								
								
								$("#update_operation_form select[name='operationLevelCode']").each(function(){
									
								       $(this).change(function(){
									   		var eventObj = $(this);
									   		var nameObjName = eventObj.attr("name").replace("Code", "Name");
									   		
									   		if(eventObj.val()!=""){
									   			var name=eventObj.find("option:selected").text();
									   			eventObj.next("input[name='"+nameObjName+"']").val(name);
									   		}else{
									   			eventObj.next("input[name='"+nameObjName+"']").val("");
									   		}
									   	});
								       var eventObj = $(this);
									   var nameObjName = eventObj.attr("name").replace("Code", "Name");
								       if(operation.operationLevelCode){
								    	   var selectOption = eventObj.find("option[value='"+operation.operationLevelCode+"']")
											if(selectOption.length > 0){
												selectOption.attr("selected",true);
											}else{
												eventObj.append("<option selected='selected' value='"+operation.operationLevelCode+"'>"+operation.operationLevelName+"</option>");
											}
								       }
								       eventObj.next("input[name='"+nameObjName+"']").val(operation.operationLevelName);
									});
								/*$("#update_disease_form input[name='fitManCodeFlag'][value='"+disease.fitManCodeFlag+"']").attr("checked",true);
								$("#update_disease_form input[name='fitWomanCodeFlag'][value='"+disease.fitWomanCodeFlag+"']").attr("checked",true);
								$("#update_disease_form input[name='unDeathFlag'][value='"+disease.unDeathFlag+"']").attr("checked",true);
								$("#update_disease_form input[name='unPrimaryFlag'][value='"+disease.unPrimaryFlag+"']").attr("checked",true);
								$("#update_disease_form input[name='attentionFlag'][value='"+disease.attentionFlag+"']").attr("checked",true);
								$("#update_disease_form input[name='attentionComment']").val(disease.attentionComment);*/
								/*$("#update_disease_form input[name='comment']").val(disease.comment);*/
								/*addRow(basicData);*/
							}else{
								layer.msg(stateMessage);
							}
						}else{
							layer.msg("操作错误，请重试！");
						}
						console.log(data);
						
					},
					error:function(XMLHttpRequest, textStatus, errorThrown){
						layer.msg("未知错误，请联系管理员");
					},
					complete:function(XMLHttpRequest, textStatus){
						layer.closeAll('loading');
					}
				});
			  var validator = $("#update_operation_form").validate({
					errorElement: "title",
					ignoreTitle: true,
					submitHandler : function(){
						updateOperationFormSubmit();
					},
					rules:{
						code: {
							required: true,
			                minlength: 1,
			                maxlength: 20
			            },
			            name: {
			            	required: true,
			                minlength: 1,
			                maxlength: 20
			            }
						
					},
					
				});
			  
		  }
		});
}
function updateBtnClick(){
	$("#update_operation_form").submit();
}

function updateOperationFormSubmit(){
	layer.load(1);
	var basePath = $("#basePath").val();
	var submitData = $('#update_operation_form').serialize();
	$.ajax({
		url: basePath + "icd/update_icd_operation",
		type: "POST",
		dataType: "json",
		data:submitData,
		success: function( data ) {
			var success = data['success'];
			if(success){
				var stateCode = data['stateCode'];
				var stateMessage = data['stateMessage'];
				if("1" == stateCode){
					layer.msg(stateMessage);
					layer.close(layerUpdateOperationIndex);
					var operation = data['data'];
					updateRow(operation);
				}else if("2" == stateCode){
					layer.msg(stateMessage);
				}else{
					layer.msg(stateMessage);
				}
			}else{
				layer.msg("操作错误，请重试！");
			}
			console.log(data);
			
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			layer.msg("未知错误，请联系管理员");
		},
		complete:function(XMLHttpRequest, textStatus){
			layer.closeAll('loading');
		}
	});
}

/修改列表行*/
function updateRow(operation){
	var add_content=$("#query_show_table tr[id='"+operation.code+"']")
	add_content.find("span[class='code']").html(operation.code);
	add_content.find("span[class='name']").html(operation.name);
	add_content.find("span[class='index_code']").html(operation.indexCode);
}

