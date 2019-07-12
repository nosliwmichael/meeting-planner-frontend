package com.meeting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/meeting")
public class MeetingController {
	
	// MEETINGS PAGE
	@RequestMapping(value= { "", "/" }, method=RequestMethod.GET)
	public ModelAndView showMeetings() {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("title", "Meetings");
		mv.setViewName("meetings");
		return mv;
		
	}

}
