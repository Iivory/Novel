package cn.blank.pojo;
/**
 * 目录列表
 * @author Administrator
 *
 */
public class Menu {
	
	private String title;
	private String url;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "Menu [title=" + title + ", url=" + url + "]";
	}
	
	

}
