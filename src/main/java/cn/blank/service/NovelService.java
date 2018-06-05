package cn.blank.service;

import java.util.List;

import cn.blank.pojo.Chapter;
import cn.blank.pojo.Menu;
import cn.blank.pojo.Novel;
import cn.blank.pojo.Page;

public interface NovelService {
	
	public void batchInsertBXWXNovels(String url);

	public int selcetCountFromKeywords(String keywords);

	public Page selectNovelsByKeywords(int curPage, int totalSize, String keywords);
	
	public List<Menu> searchNovelMenus(String url);

	public Chapter getNovelChapter(String url);
	
	public void batchInsert23usNovels(String url);
}
