package cn.blank.spider;

import java.util.List;

import cn.blank.pojo.Novel;

/**
 *  小说列表爬取
 * @author Administrator
 *
 */
public interface NovelSpider {
	
	public static final int RETRY = 10;
	
	public List<Novel> getNovels(String uri,Integer RETRY);

}
