$(function(){
	var totalCounts = $("#totalCountsHidden").val();
	var pageSize = $("#pageSizeHidden").val();
	var currentPage = $("#currentPageHidden").val();
	initPage(parseInt(totalCounts),parseInt(pageSize),parseInt(currentPage));
});

function initPage(totalCounts,pageSize,currentPage){
	 var visiblePages = 5;
	 var totalPages =  totalCounts%pageSize==0?(totalCounts/pageSize):(parseInt(totalCounts/pageSize)+1);
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
	     			$("#currentPageHidden").val(num);
					$("#pageSizeHidden").val(pageSize);
					$("#pageForm").submit();
				}
	            $("#totalPage").html(totalCounts);
	            $("#currentPage").html(num+"/"+totalPages);
	            $("#currentPageHidden").val(currentPage);
			    $("#pageSizeHidden").val(pageSize);
	        }
	    });

}