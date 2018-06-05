package cn.blank.spider.impl;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import cn.blank.pojo.BookStack;
import cn.blank.pojo.Novel;
import cn.blank.spider.BookStackSpider;
import cn.blank.spider.NovelSpider;
import cn.blank.utils.WebSiztUrlUtils;
@Component("novelsSpider")
public class NovelsSpiderImpl extends BaseNovelSpiderImpl {

	public List<Novel> getBXWXNovels(String url, Integer RETRY) {
		List<Novel> novels = new ArrayList<Novel>();
		
		Elements trs = getEles(url, RETRY);
		for(int i=1;i<trs.size();++i){
			Novel novel = new Novel();
			Element tr = trs.get(i);
			Elements tds = tr.getElementsByTag("td");
			novel.setBookname(tds.first().text());
			novel.setBookurl(tds.first().getElementsByTag("a").first().attr("href"));
			novel.setLastchapter(tds.get(1).text());
			novel.setLastchapterurl(tds.get(1).getElementsByTag("a").first().attr("href"));
			novel.setAuthor(tds.get(2).text());
			novel.setSize(tds.get(3).text());
			novel.setLastupdate(tds.get(4).text());
			novel.setStatus(tds.last().text().equals("连载")?0:1);
			novel.setType("未知");
			novels.add(novel);
		}
		return novels;
	}

	public List<Novel> getNovels(String uri, Integer RETRY) {
		List<Novel> novels = null;
		String url = WebSiztUrlUtils.getHostAddr(uri); 
		if(url.equals("www.bxwx9.org")){
			novels = getBXWXNovels(uri, RETRY);
		}else if(url.equals("www.23us.so")){
			novels = get23usNovles(uri,RETRY);
		}
		return novels;
	}

	private List<Novel> get23usNovles(String uri, Integer rETRY) {
		List<Novel> novels = new ArrayList<Novel>();
		
		Elements trs = getEles(uri, RETRY);
		for(int i=1;i<trs.size();++i){
			Novel novel = new Novel();
			Element tr = trs.get(i);
			Elements tds = tr.getElementsByTag("td");
			novel.setBookname(tds.first().text());
			novel.setBookurl(tds.first().getElementsByTag("a").first().attr("href"));
			novel.setLastchapter(tds.get(1).text());
			novel.setLastchapterurl(tds.get(1).getElementsByTag("a").first().attr("href"));
			novel.setAuthor(tds.get(2).text());
			novel.setSize(tds.get(3).text());
			novel.setLastupdate(tds.get(4).text());
			novel.setStatus(tds.last().text().equals("连载中")?0:1);
			novel.setType("未知");
			novels.add(novel);
		}
		return novels;
	}

}
