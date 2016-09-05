package com.test.violationsdrivecarMS.response;

import java.io.Serializable;
import java.util.List;


public class FindListResp<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PageMsg pageMsg;
	
	private List<T> list;

	public FindListResp() {
		super();
	}

	public FindListResp(PageMsg pageMsg, List<T> list) {
		super();
		this.pageMsg = pageMsg;
		this.list = list;
	}

	public PageMsg getPageMsg() {
		return pageMsg;
	}

	public void setPageMsg(PageMsg pageMsg) {
		this.pageMsg = pageMsg;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	

	
	
}
