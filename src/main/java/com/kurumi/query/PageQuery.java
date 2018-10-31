package com.kurumi.query;

public class PageQuery {

	private Integer totalCounts = 0; //总条数
	
	private Integer totalPages = 0;//总页数
	
	private Integer pageSize=1; //每页条数
	
	private Integer currentPage=2; //当前页
	
	private Integer currentStartNum=0; //当前

	public Integer getCurrentStartNum() {
		if(currentPage != null && pageSize != null){
			currentStartNum = (currentPage.intValue()-1)*pageSize.intValue();
		}
		
		return currentStartNum;
	}

	public Integer getTotalCounts() {
		return totalCounts;
	}

	public void setTotalCounts(Integer totalCounts) {
		this.totalCounts = totalCounts;
	}

	public Integer getTotalPages() {
		if(totalCounts != null && pageSize != null){
			totalPages = totalCounts.intValue()%pageSize.intValue()==0?totalCounts.intValue()/pageSize.intValue():(totalCounts.intValue()/pageSize.intValue())+1;
		}
		return  totalPages;
	}


	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	
	
}
