package com.meeting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {
	
	@RequestMapping(value= {"", "/"})
	public String getIndex(Model model) {
		
		model.addAttribute("title", "Meetings");
		return "index";
		
	}
	
}
