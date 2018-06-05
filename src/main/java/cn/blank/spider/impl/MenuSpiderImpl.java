package cn.blank.spider.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.stereotype.Component;

import cn.blank.pojo.Menu;
import cn.blank.pojo.Novel;
import cn.blank.spider.BaseMenuSpider;
import cn.blank.spider.BaseSpider;
import cn.blank.utils.RegulationUtils;
import cn.blank.utils.WebSiztUrlUtils;
@Component("menuSpider")
public class MenuSpiderImpl extends BaseMenuSpiderImpl{

	public List<Menu> getMenus(String url) {
		List<Menu> menus = null;
		String uri = WebSiztUrlUtils.getHostAddr(url); 
		if(uri.equals("www.bxwx9.org")){
			menus = getBXWXMenus(url);
		}else if(uri.equals("www.23us.so")){
			menus = get23USMenus(url);
		}
		return menus;
	}

	private List<Menu> get23USMenus(String url) {
		List<Menu> menus = getBaseMenus(url);
		return menus;
	}

	private List<Menu> getBXWXMenus(String uri) {
		List<Menu> menus = getBaseMenus(uri);
		 Collections.sort(menus,new Comparator<Menu>() {
			public int compare(Menu o1, Menu o2) {
				String url1 = o1.getUrl();
				String url2 = o2.getUrl();
				String o1Index = url1.substring(url1.lastIndexOf("/")+1, url1.lastIndexOf("."));
				String o2Index = url2.substring(url1.lastIndexOf("/")+1, url1.lastIndexOf("."));
				return o1Index.compareTo(o2Index);
			}
		});
		return menus;
	}

	
}
