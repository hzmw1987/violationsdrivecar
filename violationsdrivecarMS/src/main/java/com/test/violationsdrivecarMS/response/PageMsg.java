package com.test.violationsdrivecarMS.response;

import java.io.Serializable;
/**
 * 分页页码信息
 * @author hhm
 *
 */
public class PageMsg implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int page;
	private int pageSize;
	private int pageCount;
	private int totalCount;
	
	
	
	public PageMsg() {
		super();
	}
	
	public PageMsg(int page, int pageSize, int pageCount, int totalCount) {
		super();
		this.page = page;
		this.pageSize = pageSize;
		this.pageCount = pageCount;
		this.totalCount = totalCount;
	}

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	

}
