package cn.blank.test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jsoup.select.Elements;
import org.junit.Test;

import com.mysql.fabric.Response;

import cn.blank.pojo.Chapter;
import cn.blank.pojo.Menu;
import cn.blank.pojo.Novel;
import cn.blank.service.impl.NovelServiceImpl;
import cn.blank.spider.BaseChapterSpider;
import cn.blank.spider.BaseMenuSpider;
import cn.blank.spider.BaseSpider;
import cn.blank.spider.BookStackSpider;
import cn.blank.spider.NovelSpider;
import cn.blank.spider.impl.BaseSpiderImpl;
import cn.blank.spider.impl.BookStackSpiderImpl;
import cn.blank.spider.impl.ChapterSpiderImpl;
import cn.blank.spider.impl.MenuSpiderImpl;
import cn.blank.spider.impl.NovelsSpiderImpl;
import cn.blank.utils.RegulationUtils;
import cn.blank.utils.WebSiztUrlUtils;

public class TestSpider {
	
	@Test
	public void testSpider(){
		CloseableHttpClient client = HttpClientBuilder.create().build();
		HttpGet get = new HttpGet("https://www.baidu.com");
		try {
			HttpResponse response = client.execute(get);
			HttpEntity entity = response.getEntity();
			System.out.println(response.getStatusLine());
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	@Test
	public void test1(){
		BookStackSpider s = new BookStackSpiderImpl();
		System.out.println(s.getBookStack("http://www.23us.so/top/allvisit_1.html").getPages());
	}
	
	@Test
	public void test2(){
		System.out.println(WebSiztUrlUtils.getHostAddr("https://www.bxwx9.org/modules/article/index.php"));
	}
	
	@Test
	public void test3(){
		Map<String, String> map = RegulationUtils.getRule(WebSiztUrlUtils.getHostAddr("https://www.bxwx9.org/bsort/0/1.htm"));
		System.out.println(map);
	}
	
	@Test
	public void test6(){
		NovelSpider s = new NovelsSpiderImpl();
		List<Novel> novels = s.getNovels("http://www.23us.so/top/allvisit_1.html", null);
		for(Novel n:novels){
			System.out.println(n);
		}
	}
	
	@Test
	public void test7(){
		BaseChapterSpider chapter = (BaseChapterSpider) new ChapterSpiderImpl();
		Chapter c = chapter.getChapter("https://www.bxwx9.org/b/5/5169/11853587.html");
		System.out.println(c);
	}
	
	
	@Test
	public void test8(){
		BaseSpider spider = new BaseSpiderImpl();
		String content = spider.crwal("http://www.23us.so/top/allvisit_1.html");
		System.out.println(content);
	}



}
