package com.StarBucks.bean;

public class Page {
	
	private Integer totalRecord; //总的记录数
	private Integer currentPageNo; //当前的页码
	private Integer pageSize; //每页记录数
	private Integer totalPages;//总页数

	
	


	public Integer getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(Integer totalRecord) {
		this.totalRecord = totalRecord;
	}

	public Integer getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(Integer currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public Integer getPrev() {
		if(this.currentPageNo>1) {
			return this.currentPageNo-1;
		}else {
			return this.currentPageNo;
		}
	}
	
	public Integer getNext() {
		if(this.currentPageNo<this.totalPages) {
			return this.currentPageNo+1;
		}else {
			return this.currentPageNo;
		}
			
	}
	public Integer getFirst() {
		return 1;
	}
	
	public Integer getLast() {
		return this.totalPages;
	}
}
