package cn.blank.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.blank.dao.mapper.NovelMapper;
import cn.blank.pojo.BookStack;
import cn.blank.pojo.Chapter;
import cn.blank.pojo.Menu;
import cn.blank.pojo.Novel;
import cn.blank.pojo.Page;
import cn.blank.service.NovelService;
import cn.blank.spider.BaseChapterSpider;
import cn.blank.spider.BaseMenuSpider;
import cn.blank.spider.BookStackSpider;
import cn.blank.spider.NovelSpider;
import cn.blank.utils.WebSiztUrlUtils;

@Service("novelService")
public class NovelServiceImpl implements NovelService {
	
	@Autowired
	private NovelMapper novelMapper;
	
	@Autowired
	private NovelSpider NovelsSpider;
	
	@Autowired
	private BookStackSpider bookStackSpider;
	
	@Autowired
	private BaseMenuSpider menuSpider;
	
	@Autowired
	private BaseChapterSpider chapterSider;
	
	/**
	 * 笔下文学
	 */
	@Transactional
	public void batchInsertBXWXNovels(String url) {
		
		BookStack bookStack = bookStackSpider.getBookStack(url);
		int totalPage = bookStack.getPages();
		String start = bookStack.getUrl();
		
		String[] us = start.split("0/");

		ExecutorService pool = Executors.newFixedThreadPool(10);
		List<Future<String>> tasks = new ArrayList<Future<String>>();
		for(int i=1;i<=totalPage;++i){
			final String path = us[0]+i/1000+"/"+i+".htm";	
		tasks.add(pool.submit(new Callable<String>() {
			
			public  String call() throws Exception {
				List<Novel> novels = NovelsSpider.getNovels(path, null);
				novelMapper.batchInsert(novels);
				return path+"完成了爬取";
			}
		}));
		}
		
		pool.shutdown();
		
		for(Future<String> future:tasks){
			try {
				System.out.println(future.get()+"完成了爬取");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("总共抓取了"+tasks.size()+"页");
  
	}
	
	/**
	 * 顶点小说
	 * @param url
	 */
	@Transactional
	public void batchInsert23usNovels(String url) {
		
		BookStack bookStack = bookStackSpider.getBookStack(url);
		int totalPage = bookStack.getPages();
		String start = bookStack.getUrl();
		
		String[] us = start.split("_");

		ExecutorService pool = Executors.newFixedThreadPool(10);
		List<Future<String>> tasks = new ArrayList<Future<String>>();
		for(int i=1;i<=totalPage;++i){
			final String path = us[0]+"_"+i+".html";	
		tasks.add(pool.submit(new Callable<String>() {
			
			public  String call() throws Exception {
				List<Novel> novels = NovelsSpider.getNovels(path, null);
				novelMapper.batchInsert(novels);
				return path+"完成了爬取";
			}
		}));
		}
		
		pool.shutdown();
		
		for(Future<String> future:tasks){
			try {
				System.out.println(future.get()+"完成了爬取");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("总共抓取了"+tasks.size()+"页");
  
	}
	
	
	
	
	
	public int selcetCountFromKeywords(String keywords) {
		int totalSize = novelMapper.selectCountByKeywords("%"+keywords+"%");
		return totalSize ;
	}
	public Page selectNovelsByKeywords(int curPage, int totalSize, String keywords) {
		Page page = new Page(curPage,totalSize);
		int start = (page.getCurrentPage()-1)+1;
		int end = start+page.getPageSize();
		List<Novel> novels = novelMapper.getNovelsByKeywords("%"+keywords+"%",start,end);
		for(Novel novel:novels){
			if(WebSiztUrlUtils.getHostAddr(novel.getBookurl()).equals("www.bxwx9.org")){
				novel.setSource("笔下文学");;
			}else if(WebSiztUrlUtils.getHostAddr(novel.getBookurl()).equals("www.23us.so")){
				novel.setSource("顶点小说");
			}
		}
		page.setNovels(novels);
		return page;
	}
	
	public List<Menu> searchNovelMenus(String url){
		return menuSpider.getMenus(url);
	}
	public Chapter getNovelChapter(String url) {
		Chapter chapter = chapterSider.getChapter(url);
		return chapter;
	}

}
