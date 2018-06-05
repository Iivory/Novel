package cn.blank.spider;

import cn.blank.pojo.BookStack;

/**
 * 书库爬取
 * @author Administrator
 *
 */
public interface BookStackSpider {
	/**
	 * 获取书库基本信息
	 * @param url
	 * @return
	 */
	public BookStack getBookStack(String url);
	
	
}
