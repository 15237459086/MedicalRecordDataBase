
$(function(){
	$("select").each(function(){
		$(this).append("<option value=''>---请选择---</option>");
	});

	var basePath = $("#basePath").val();
	$.ajax({
		url: basePath + "quality_control/quality_control_first_level",
		type: "GET",
		dataType: "json",
		success: function( datas ) {
			console.log(datas);
			init(datas);
			
		}
	});
});

function init(datas){
	var qualityControlItems = datas['data'];
	clearPage();
	$("select[name='firstLevelCode']").each(function(){
		var options = "";
		for(var index in qualityControlItems){
			var qualityControlItem = qualityControlItems[index];
	    	options+="<option value='"+qualityControlItem.code+"'>"+qualityControlItem.project+"</option>"
	    } 
       $(this).append(options);
       $(this).change(function(){
    	   clearPage();
    	   $("select[name='secondLevelCode'] option[value!='']").remove();
    	   $("#select[name='secondLevelCode']").change();
	   		var eventObj = $(this);
	   		if(eventObj.val()!=""){
	   			fillSecondLevel(eventObj.val());
	   		}
	   });
	});
	addRows(qualityControlItems);
}


function fillSecondLevel(upOneLevelCode){
	var basePath = $("#basePath").val();
	$.ajax({
		url: basePath + "quality_control/quality_control_item_by_up_level_code",
		type: "GET",
		data:{upOneLevelCode:upOneLevelCode},
		dataType: "json",
		success: function( datas ) {
			console.log(datas);
			var qualityControlPoints = datas['data'];
			
			$("select[name='secondLevelCode']").each(function(){
				var options = "";
				for(var index in qualityControlPoints){
					var qualityControlPoint = qualityControlPoints[index];
			    	options+="<option title='"+(qualityControlPoint.score==undefined?"":qualityControlPoint.score)+"' value='"+qualityControlPoint.code+"'>"+qualityControlPoint.project+"</option>";
			    }
		       $(this).append(options);
		       $(this).change(function(){
		    	    clearPage();
			   		var eventObj = $(this);
			   		$("select[name='thirdLevelCode'] option[value!='']").remove();
			    	$("select[name='thirdLevelCode']").change();
			   		if(eventObj.val()!=""){
			   			fillThirdLevel(eventObj.val());
			   		}
			   		
			   });
			});
			addRows(qualityControlPoints);
		}
	});
	
}

function fillThirdLevel(upOneLevelCode){
	var basePath = $("#basePath").val();
	$.ajax({
		url: basePath + "quality_control/quality_control_item_by_up_level_code",
		type: "GET",
		data:{upOneLevelCode:upOneLevelCode},
		dataType: "json",
		success: function( datas ) {
			var qualityControlPoints = datas['data'];
			addRows(qualityControlPoints);
			
			
		}
	});
	
}


/*添加列表行*/
function addRows(qualityControlPoints){
	for(var index in qualityControlPoints){
		var qualityControlPoint = qualityControlPoints[index];
		var add_content=$("#template_tr").clone();
		add_content.removeAttr("hidden");
		add_content.attr("id",qualityControlPoint.id);
		add_content.find("span[class='code']").html(qualityControlPoint.code);
		add_content.find("span[class='project']").html(qualityControlPoint.project);
		add_content.find("span[class='score']").html(qualityControlPoint.score);
		add_content.find("span[class='remark']").html(qualityControlPoint.mark);
		$("#query_show_table tbody").append(add_content);
    } 
	
}

function addRow(qualityControlPoint){
	var add_content=$("#template_tr").clone();
	add_content.removeAttr("hidden");
	add_content.attr("id",qualityControlPoint.id);
	add_content.find("span[class='code']").html(qualityControlPoint.code);
	add_content.find("span[class='project']").html(qualityControlPoint.project);
	add_content.find("span[class='score']").html(qualityControlPoint.score);
	add_content.find("span[class='remark']").html(qualityControlPoint.mark);
	$("#query_show_table tbody").append(add_content);
	
}

/*清空列表*/
function clearPage(){
	$("#template_tr").siblings("tr").remove();
}

function createDataBtnClick(){
	$("#crate_data_form").submit();
}

//显示新建数据Layer
var layerCreateDataIndex
function layerCreateData(){
	
	var add_content=$("#create_data_div").clone();
	add_content.find("form").attr("id","crate_data_form");
	var title = "新建质控项";
	layerCreateDataIndex = layer.open({
		  type: 1,
		  title:title,
		  skin: 'layui-layer-rim', //加上边框
		  area: ['420px', '290px'], //宽高
		  content: add_content.html(),
		  success: function(layero, index){
			 
			  var validator = $("#crate_data_form").validate({
					errorElement: "title",
					ignoreTitle: true,
					submitHandler : function(){
						createDataFormSubmit();
						/*return false;*/
					},
					rules:{
						code: {
							required: true,
			                minlength: 1,
			                maxlength: 20
			            },
			            project: {
							required: true,
			                minlength: 2,
			                maxlength: 20
			            },
			            score: {
			                number:true,
			                range:[0,100],
			                maxlength:4
			            }
						
					},
					
				});
			  
		  }
	});
}

function createDataFormSubmit(){
	var submitData = $('#crate_data_form').serialize();
	var basePath = $("#basePath").val();
	layer.load(1);
	$.ajax({
		url: basePath + "quality_control/create_quality_control",
		dataType: "json",
		type: "POST",
		data:submitData,
		success: function( data ) {
			var success = data['success'];
			
			if(success){
				var stateCode = data['stateCode'];
				var stateMessage = data['stateMessage'];
				if(stateCode =="1"){
					layer.msg(stateMessage);
					var qualityControlItem = data['data'];
					layer.close(layerCreateDataIndex);
					addRow(qualityControlItem);
				}else if(stateCode =="2"){
					layer.msg(stateMessage);
				}else{
					layer.msg(stateMessage);
				}
			}else{
				layer.msg("新增失败");
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

function updateDataBtnClick(){
	$("#update_data_form").submit();
}

//显示新建数据Layer
var layerUpdateDataIndex
function layerUpdateData(obj){
	
	var add_content=$("#update_data_div").clone();
	add_content.find("form").attr("id","update_data_form");
	var title = "修改质控项";
	layerUpdateDataIndex = layer.open({
		  type: 1,
		  title:title,
		  skin: 'layui-layer-rim', //加上边框
		  area: ['420px', '290px'], //宽高
		  content: add_content.html(),
		  success: function(layero, index){
			  var content = $(obj).parent().parent();
			  $("#update_data_form input[name='id']").val(content.attr("id"));
			  $("#update_data_form input[name='code']").val(content.find(".code").html());
			  $("#update_data_form input[name='project']").val(content.find(".project").html());
			  $("#update_data_form input[name='score']").val(content.find(".score").html());
			  $("#update_data_form input[name='mark']").val(content.find(".remark").html());
			  
			  var validator = $("#update_data_form").validate({
					errorElement: "title",
					ignoreTitle: true,
					submitHandler : function(){
						updateDataFormSubmit();
					},
					rules:{
						code: {
							required: true,
			                minlength: 1,
			                maxlength: 20
			            },
			            project: {
							required: true,
			                minlength: 2,
			                maxlength: 20
			            },
			            score: {
			                number:true,
			                range:[0,100],
			                maxlength:4
			            }
						
					},
					
				});
			  
		  }
	});
}

function updateDataFormSubmit(){
	var submitData = $('#update_data_form').serialize();
	var basePath = $("#basePath").val();
	layer.load(1);
	$.ajax({
		url: basePath + "quality_control/update_quality_control",
		dataType: "json",
		type: "POST",
		data:submitData,
		success: function( data ) {
			var success = data['success'];
			
			if(success){
				var stateCode = data['stateCode'];
				var stateMessage = data['stateMessage'];
				if(stateCode =="1"){
					layer.msg(stateMessage);
					var qualityControlItem = data['data'];
					layer.close(layerUpdateDataIndex);
					updateRow(qualityControlItem);
				}else if(stateCode =="2"){
					layer.msg(stateMessage);
				}else{
					layer.msg(stateMessage);
				}
			}else{
				layer.msg("修改失败");
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

function updateRow(qualityControlPoint){
	var add_content=$("#query_show_table tr[id='"+qualityControlPoint.id+"']");
	add_content.removeAttr("hidden");
	add_content.find("span[class='code']").html(qualityControlPoint.code);
	add_content.find("span[class='project']").html(qualityControlPoint.project);
	add_content.find("span[class='score']").html(qualityControlPoint.score);
	add_content.find("span[class='remark']").html(qualityControlPoint.mark);
	$("#query_show_table tbody").append(add_content);
	
}