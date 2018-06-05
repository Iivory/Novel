package cn.blank.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.blank.pojo.Menu;
import cn.blank.pojo.User;
import cn.blank.service.NovelService;
import cn.blank.service.UserService;
import cn.blank.spider.BaseMenuSpider;
import cn.blank.spider.impl.MenuSpiderImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class Demo1 {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private NovelService novelService;
	
	@Test
	public void testSpringAndMyBatis(){
		User u = userService.getUserByID(1);
		System.out.println(u.getPassword());
	}
	
	@Test
	public void Test(){
		String str = "http://www.23us.so/top/allvisit_1.html";
		String[] strs = str.split("_");
		System.out.println(strs[0]);
	}
	
	@Test
	public void test7(){
		novelService.batchInsertBXWXNovels("https://www.bxwx9.org/modules/article/index.php");
	}
	

	@Test
	public void test(){
		BaseMenuSpider menu = new MenuSpiderImpl();
		List<Menu> menus = menu.getMenus("https://www.bxwx9.org/b/122/122140/index.html");
		for(Menu e:menus){
			System.out.println(e);
		}
	}
}
