package cn.blank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.blank.service.NovelService;
import cn.blank.utils.WebSiztUrlUtils;

@Controller
public class InputNovelController {
	
	
	@Autowired
	private NovelService novelService;
	
	@RequestMapping("/Data")
	public String getNovels(String url){
		String uri = WebSiztUrlUtils.getHostAddr(url);
		if(uri.equals("www.bxwx9.org")){
			novelService.batchInsertBXWXNovels(url);
		}else if(uri.equals("www.23us.so")){
			novelService.batchInsert23usNovels(url);
		}
		
		return "Success";
	}

}
