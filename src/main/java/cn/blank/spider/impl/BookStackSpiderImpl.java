package cn.blank.spider.impl;


import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.blank.pojo.BookStack;
import cn.blank.spider.BaseSpider;
import cn.blank.spider.BookStackSpider;
import cn.blank.utils.RegulationUtils;
import cn.blank.utils.WebSiztUrlUtils;

/*
 * 书库爬取类
 */
@Component("bookStackSpider")
public class BookStackSpiderImpl extends BaseSpiderImpl implements BookStackSpider {

	public BookStack getBookStack(String url) {
		String content = crwal(url);
		if(StringUtils.isEmpty(content)){throw new RuntimeException("书库爬取失败");}
		
		//获取匹配规则
		Map<String,String> rule = RegulationUtils.getRule(WebSiztUrlUtils.getHostAddr(url));
		
		Document doc = Jsoup.parse(content);
		Elements fisrt = doc.select(rule.get("bookstack-url"));
		Elements last = doc.select(rule.get("bookstack-pages")); 
		
		BookStack stack = new BookStack();
		stack.setUrl(fisrt.attr("href"));
		stack.setPages(Integer.parseInt(last.html()));
		
		return stack;
	}
	
	
}
