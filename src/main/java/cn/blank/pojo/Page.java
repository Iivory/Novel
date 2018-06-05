package cn.blank.pojo;

import java.util.List;

/**
 * 分页工具
 * @author Administrator
 *
 */
public class Page {
	
	private List<Novel> novels;
	
	private int currentPage;
	private int prePage;
	private int nextPage;
	private int totalPage;
	private int totalSize;
	private int pageSize = 10;
	
	public Page(int currentPage,int totalSize) {
		this.currentPage = currentPage;
		this.totalSize = totalSize;
		totalPage = (totalSize/pageSize)+(totalSize%pageSize>0?1:0);
	}

	public List<Novel> getNovels() {
		return novels;
	}

	public void setNovels(List<Novel> novels) {
		this.novels = novels;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPrePage() {
		if(currentPage==1){
			prePage = 1;
		}else{
			prePage = currentPage-1;
		}
		return prePage;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public int getNextPage() {
		if(currentPage==totalPage){
			nextPage = totalPage;
		}else{
			nextPage = currentPage+1;
		}
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
	
	
	
	
	
	

}
