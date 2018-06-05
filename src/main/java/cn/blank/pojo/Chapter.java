package cn.blank.pojo;
/**
 * 章节类
 * @author Administrator
 *
 */
public class Chapter {
	
	@Override
	public String toString() {
		return "Chapter [title=" + title + ", content=" + content + ", prevous=" + prevous + ", next=" + next + "]";
	}
	private String title;
	private String content;
	private String prevous;
	private String next;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPrevous() {
		return prevous;
	}
	public void setPrevous(String prevous) {
		this.prevous = prevous;
	}
	public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}
	
	
	
	

}
