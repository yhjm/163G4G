package com.qhit.sbm.common.bean;

import java.util.ArrayList;
import java.util.List;

public class PageBean {

	private int pageNum;
	private int pageTotal;
	private int count;
	private int pageSize;
	private List data;
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		if(pageNum < 1){
			pageNum = 1;
		}else if(pageNum > pageTotal){
			pageNum = pageTotal;
		}else{
			this.pageNum = pageNum;
		}
	}
	public int getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {	
		this.count = count;
		pageTotal = (int) Math.ceil(count*1.0/pageSize);
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
	public PageBean() {
		super();
		// TODO Auto-generated constructor stub
		pageNum = 1;
		pageSize = 5;
		List  list = new ArrayList<>();
	}
	public PageBean(int pageNum, int pageTotal, int count, int pageSize,
			List<Object> data) {
		super();
		this.pageNum = pageNum;
		this.pageTotal = pageTotal;
		this.count = count;
		this.pageSize = pageSize;
		this.data = data;
	}
	public void addData(Object object){
		data.add(object);
	}
	
	
}
