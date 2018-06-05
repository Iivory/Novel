package cn.blank.spider;

import java.util.List;

import cn.blank.pojo.Menu;

public interface BaseMenuSpider {
	
	public final int RETRY = 10;
	
	public List<Menu> getMenus(String url);

}
