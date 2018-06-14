
$(function(){
	/*$("select").each(function(){
		$(this).append("<option value=''>---请选择---</option>");
	});
*/
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
		url: basePath + "icd/query_icd_disease",
		dataType: "json",
		data:submitData,
		success: function( data ) {
			var success = data['success'];
			if(success){
				
				var params = data['data'];
				var totalCounts = params['totalCounts'];
				if(totalCounts > 0){
					layer.msg("查询成功");
					var diseases = params['queryDatas'];
					addRows(diseases);
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
function addRows(diseases){
	for(var index in diseases){
		var disease = diseases[index];
		var add_content=$("#template_tr").clone();
		add_content.removeAttr("hidden");
		add_content.attr("id",disease.code);
		add_content.find("span[class='code']").html(disease.code);
		add_content.find("span[class='name']").html(disease.name);
		add_content.find("span[class='index_code']").html(disease.index_code);
		$("#query_show_table tbody").append(add_content);
    } 
	
}


//显示新建数据Layer
var layerCreateDiseaseIndex
function layerCreatDisease(){
	
	var add_content=$("#create_disease_div").clone();
	add_content.find("form").attr("id","crate_disease_form");
	var title = "新建ICD_10";
	layerCreateDiseaseIndex = layer.open({
		  type: 1,
		  title:title,
		  skin: 'layui-layer-rim', //加上边框
		  area: ['740px', '400px'], //宽高
		  content: add_content.html(),
		  success: function(layero, index){
			 /* var createUserBtnOjbs = $("#crate_role_form .ceate_role_btn");
			  createUserBtnOjbs.each(function(){
				  var obj = $(this);
				  $(this).click(function() {
					 createRoleFormSubmit();
				  });
				
				  
			  });*/
			  var validator = $("#crate_disease_form").validate({
					errorElement: "title",
					ignoreTitle: true,
					submitHandler : function(){
						createDiseaseFormSubmit();
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
	$("#crate_disease_form").submit();
}


//提交新建数据
function createDiseaseFormSubmit(){
	layer.load(1);
	var basePath = $("#basePath").val();
	var submitData = $('#crate_disease_form').serialize();
	$.ajax({
		url: basePath + "icd/create_icd_disease",
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
					layer.close(layerCreateDiseaseIndex);
					var disease = data['data'];
					addRow(disease);
					
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
function addRow(disease){
	var add_content=$("#template_tr").clone();
	add_content.removeAttr("hidden");
	add_content.attr("id",disease.code);
	add_content.find("span[class='code']").html(disease.code);
	add_content.find("span[class='name']").html(disease.name);
	add_content.find("span[class='index_code']").html(disease.indexCode);
	$("#query_show_table tbody").append(add_content);
}

//显示新建数据Layer
var layerUpdateDiseaseIndex
function layerUpdateDisease(obj){
	var basePath = $("#basePath").val();
	var content = $(obj).parent().parent();
	var code = content.attr("id");
	
	
	var add_content=$("#update_disease_div").clone();
	add_content.find("form").attr("id","update_disease_form");
	var title = "编辑ICD_10";
	
	layerUpdateDiseaseIndex = layer.open({
		  type: 1,
		  title:title,
		  skin: 'layui-layer-rim', //加上边框
		  area: ['740px', '400px'], //宽高
		  content: add_content.html(),
		  success: function(layero, index){
			  $.ajax({
					url: basePath + "icd/show_icd_disease",
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
								var disease = data['data'];
								$("#update_disease_form input[name='code']").val(disease.code);
								$("#update_disease_form input[name='name']").val(disease.name);
								$("#update_disease_form input[name='enName']").val(disease.enName);
								$("#update_disease_form input[name='indexCode']").val(disease.indexCode);
								$("#update_disease_form input[name='aliasName']").val(disease.aliasName);
								$("#update_disease_form input[name='aliasNameIndex']").val(disease.aliasNameIndex);
								$("#update_disease_form input[name='fitManCodeFlag'][value='"+disease.fitManCodeFlag+"']").attr("checked",true);
								$("#update_disease_form input[name='fitWomanCodeFlag'][value='"+disease.fitWomanCodeFlag+"']").attr("checked",true);
								$("#update_disease_form input[name='unDeathFlag'][value='"+disease.unDeathFlag+"']").attr("checked",true);
								$("#update_disease_form input[name='unPrimaryFlag'][value='"+disease.unPrimaryFlag+"']").attr("checked",true);
								$("#update_disease_form input[name='attentionFlag'][value='"+disease.attentionFlag+"']").attr("checked",true);
								$("#update_disease_form input[name='attentionComment']").val(disease.attentionComment);
								$("#update_disease_form input[name='comment']").val(disease.comment);
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
			  var validator = $("#update_disease_form").validate({
					errorElement: "title",
					ignoreTitle: true,
					submitHandler : function(){
						updateDiseaseFormSubmit();
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
	$("#update_disease_form").submit();
}

function updateDiseaseFormSubmit(){
	layer.load(1);
	var basePath = $("#basePath").val();
	var submitData = $('#update_disease_form').serialize();
	$.ajax({
		url: basePath + "icd/update_icd_disease",
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
					layer.close(layerUpdateDiseaseIndex);
					var disease = data['data'];
					updateRow(disease);
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
function updateRow(disease){
	var add_content=$("#query_show_table tr[id='"+disease.code+"']")
	add_content.find("span[class='code']").html(disease.code);
	add_content.find("span[class='name']").html(disease.name);
	add_content.find("span[class='index_code']").html(disease.indexCode);
}

