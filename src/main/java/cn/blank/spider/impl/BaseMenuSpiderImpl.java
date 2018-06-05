package cn.blank.spider.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cn.blank.pojo.Menu;
import cn.blank.spider.BaseMenuSpider;
import cn.blank.utils.RegulationUtils;
import cn.blank.utils.WebSiztUrlUtils;

/**
 * 目录爬取类
 * @author Administrator
 *
 */
public abstract class BaseMenuSpiderImpl extends BaseSpiderImpl implements BaseMenuSpider{
	
	public List<Menu> getBaseMenus(String url){

		Elements eles = null;
		Map<String,String> rule = RegulationUtils.getRule(WebSiztUrlUtils.getHostAddr(url));
		List<Menu> menus = new ArrayList<Menu>();
		String content = crwal(url);
		Document doc = Jsoup.parse(content);
		doc.setBaseUri(url);
		eles = doc.select(rule.get("novel-menu"));
		//循环封装参数
			for(Element ele:eles){
					Menu menu = new Menu();
					menu.setTitle(ele.text());	
					menu.setUrl(ele.absUrl("href"));
					menus.add(menu);
				}
		return menus;
	}
	

}
