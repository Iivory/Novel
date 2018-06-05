package cn.blank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.blank.dao.mapper.UserMapper;
import cn.blank.pojo.User;
import cn.blank.service.UserService;

@Controller
public class TestController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/test")
	public String test(String id,Model model){
		User user = userService.getUserByID(Integer.parseInt(id));
		model.addAttribute("user", user);
		return "test";
	}
}
