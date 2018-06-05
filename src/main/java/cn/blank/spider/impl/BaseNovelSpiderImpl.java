package cn.blank.spider.impl;

import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cn.blank.pojo.Novel;
import cn.blank.spider.NovelSpider;
import cn.blank.utils.RegulationUtils;
import cn.blank.utils.WebSiztUrlUtils;

public abstract class BaseNovelSpiderImpl extends BaseSpiderImpl implements NovelSpider {

	
	public Elements getEles(String url,Integer retry){
		retry = (retry==null?RETRY:retry);
		Elements eles = null;
		Map<String,String> rule = RegulationUtils.getRule(WebSiztUrlUtils.getHostAddr(url));
			for (int i = 1; i < retry; ++i) {
				try {
					String content = crwal(url);
					Document doc = Jsoup.parse(content);
					doc.setBaseUri(url);
					eles = doc.select(rule.get("novels"));
					return eles;
				} catch (Exception e) {

				}
			} 
			throw new RuntimeException("第"+retry+"次爬取"+url+"失败");
	}


}
