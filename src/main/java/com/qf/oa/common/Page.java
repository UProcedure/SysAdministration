package com.qf.oa.common;

import java.util.List;

public  class Page<T>{
	
	private int currentPage = 1;// 当前页
	private int pageSize = 5; // 每页显示条数
	private int totalPage;// 总页数
	private int totalCount;// 总条数
	private List<T> list;// 分页的集合数据
	private String url;// 分页的跳转地址
	public Page() {
		super();
	}
	public Page(List<T> list){
		com.github.pagehelper.Page<T> page = (com.github.pagehelper.Page<T>) list;
		this.currentPage = page.getPageNum();
		this.pageSize = page.getPageSize();
		this.totalPage = page.getPages();
		this.totalCount = (int) page.getTotal();
		this.list = page.getResult();
		
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "Page [currentPage=" + currentPage + ", pageSize=" + pageSize + ", totalPage=" + totalPage
				+ ", totalCount=" + totalCount + ", list=" + list + ", url=" + url + "]";
	}


}
