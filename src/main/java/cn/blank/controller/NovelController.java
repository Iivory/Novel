package cn.blank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.blank.pojo.Chapter;
import cn.blank.pojo.Menu;
import cn.blank.pojo.Page;
import cn.blank.service.NovelService;

@Controller
public class NovelController {
	
	@Autowired
	private NovelService novelService;
	
	
	@RequestMapping("/SearchNovels")
	public String searchNovelsByKeywords(String keywords,String currentPage,Model model){
		int curPage = currentPage ==null?1:Integer.parseInt(currentPage);
		keywords = keywords==null?"":keywords;
		try {
			keywords = new String(keywords.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int totalSize = novelService.selcetCountFromKeywords(keywords);
		Page page = novelService.selectNovelsByKeywords(curPage,totalSize,keywords);
		model.addAttribute("page", page);
		model.addAttribute("keywords",keywords);
		return "search"; 
	}
	
	@RequestMapping("/menuList")
	public String getNovelMenus(String url,Model model){
		List<Menu> menus = novelService.searchNovelMenus(url);
		System.out.println(menus.size());
		model.addAttribute("menus",menus);
		model.addAttribute("baseUrl",url);
		return "menuList";
	}
	
	@RequestMapping("/chapter")
	public ModelAndView getChapter(String url,String baseUrl){
		if(url.endsWith("index.html")){
			return new ModelAndView("redirect:/menuList.do?url="+url);
		}
		ModelAndView view = new ModelAndView();
		view.setViewName("chapter");
		Chapter chapter = novelService.getNovelChapter(url);
		chapter.setContent(chapter.getContent().replaceAll("\n", "<br/>"));
		view.getModel().put("chapter",chapter);
		view.getModel().put("baseUrl", baseUrl);
		view.setViewName("chapter");
		return view;
	}
	
	@RequestMapping("/download")
	public void download(String url,HttpServletResponse response) throws IOException{
		List<Menu> menus = novelService.searchNovelMenus(url);


		
		//传输数据
		response.setHeader("Content-Disposition", "attachment;filename="+Math.random()+".txt");
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out = null;;
		try {
			out = response.getWriter();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			for(Menu menu: menus){
				Chapter chapter = novelService.getNovelChapter(menu.getUrl());
				out.write(chapter.getTitle()+"\n");
				out.write(chapter.getContent()+"\n");
				out.flush();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			out.close();
		}
		
		
	} 

}
