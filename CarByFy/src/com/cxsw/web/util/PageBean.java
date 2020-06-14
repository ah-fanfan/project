package com.cxsw.web.util;

import java.util.List;

public class PageBean<E> {
	private int pageNumber;// 褰撳墠椤电爜
	private int pageCount;// 鎬绘潯鏁�
	private int PageSize;// 姣忎竴椤垫渶澶ф潯鏁�
	private int totalPage;// 鎬婚〉鏁�
	private List<E> list;

	public PageBean(int pageNumber, int pageSize) {
		this.pageNumber = pageNumber;
		PageSize = pageSize;
	}
	public PageBean() {
		
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageSize() {
		return PageSize;
	}

	public void setPageSize(int pageSize) {
		PageSize = pageSize;
	}

	public int getTotalPage() {
		 return (int) Math.ceil(pageCount/(PageSize*1.0));

	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<E> getList() {
		return list;
	}

	public void setList(List<E> list) {
		this.list = list;
	}

	public int getIndex() {
		int dex = (pageNumber - 1) * PageSize;
		return dex;
	}

	@Override
	public String toString() {
		return "PageBean [pageNumber=" + pageNumber + ", pageCount=" + pageCount + ", PageSize=" + PageSize
				+ ", totalPage=" + totalPage + ", list=" + list + "]";
	}
	
}
