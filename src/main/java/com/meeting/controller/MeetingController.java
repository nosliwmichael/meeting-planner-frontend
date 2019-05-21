package com.meeting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/meeting")
public class MeetingController {
	
	// MEETINGS PAGE
	@RequestMapping(value= { "", "/" }, method=RequestMethod.GET)
	public String showMeetings() {
		
		return "meetings";
		
	}

}
