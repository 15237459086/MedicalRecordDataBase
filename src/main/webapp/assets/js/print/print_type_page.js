
$(function(){
	/*$("select").each(function(){
		$(this).append("<option value=''>---请选择---</option>");
	});
*/
	var basePath = $("#basePath").val();
	
	$("select[name='printerTypeId']").each(function(){
       $(this).change(function(){
    	    cleanPrinterTypes();
	   		var eventObj = $(this);
	   		if(eventObj.val()!=""){
	   			fillPrinterTypes(eventObj.val());
	   			$("#updateBtn").removeAttr("hidden");
	   		}else{
	   			$("#updateBtn").attr("hidden","hidden");
	   		}
	   });
	});
});

function cleanPrinterTypes(){
	$("input[type='checkbox']").attr("checked",false);
}

function fillPrinterTypes(printerTypeId){
	layer.load(1);
	var basePath = $("#basePath").val();
	$.ajax({
		url: basePath + "print/query_page_type_by_print_type_id",
		type: "GET",
		data:{printerTypeId:printerTypeId},
		dataType: "json",
		success: function( datas ) {
			console.log(datas);
			var printerTypeIds = datas['data'];
			for(var index in printerTypeIds){
				var printerTypeId = printerTypeIds[index];
				$("input[name='pageTypeIds'][value='"+printerTypeId+"']").attr("checked",true).prop("checked",true); ;
		    }
			
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			layer.msg("未知错误，请联系管理员");
		},
		complete:function(XMLHttpRequest, textStatus){
			layer.closeAll('loading');
		}
	});
	
}


/*点击查询按钮*/
function updateBtnClick(){
	updateFormSubmit();
}

/*提交查询*/
function updateFormSubmit(){
	var submitData = $('#updateForm').serialize();
	var basePath = $("#basePath").val();
	layer.load(1);
	$.ajax({
		url: basePath + "print/update_mr_printer_range",
		dataType: "json",
		type: "POST",
		data:submitData,
		success: function( data ) {
			var success = data['success'];
			if(success){
				layer.msg("保存成功");
			}else{
				layer.msg("保存失败");
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


