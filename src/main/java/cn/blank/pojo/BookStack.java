package cn.blank.pojo;
/**
 * 书库信息
 * @author Administrator
 *
 */
public class BookStack {
	//总页数
	private int pages;
	//起始页地址
	private String url;
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
