package com.meeting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.meeting.manager.UserManager;
import com.meeting.viewmodel.LoginView;
import com.meeting.viewmodel.UserView;

@Controller
public class UserController {
	
	@Autowired
	private UserManager userManager;
	
	// LOGIN PAGE
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView login(@ModelAttribute(name="userLogin") LoginView user) {

		ModelAndView mv = new ModelAndView();
		mv.addObject("title", "Login");
		mv.setViewName("login");
		return mv;
		
	}
	
	// VALIDATE LOGIN
	@RequestMapping(value="/loggingin", method=RequestMethod.POST)
	public ModelAndView loggingIn(@ModelAttribute(name="userLogin") LoginView user) {
		
		boolean loggedIn = userManager.loginUser(user);
		
		if (loggedIn) {
			return new ModelAndView("redirect:/meeting");
		} else {
			return new ModelAndView("login");
		}

	}
	
	// REGISTER PAGE
	@RequestMapping(value="/register")
	public ModelAndView createAccount(@ModelAttribute(name="newUser") UserView newUser) {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("title", "Registration");
		mv.setViewName("register");
		return mv;
		
	}
	
	// VALIDATE REGISTRATION
	@RequestMapping(value="/creating", method=RequestMethod.POST)
	public ModelAndView creatingAccount(@ModelAttribute(name="newUser") UserView newUser) {
		
		// NEED TO CHECK IF USER EXISTS
		newUser = userManager.create(newUser);
		return new ModelAndView("redirect:/created");
		
	}
	
	// ACCOUNT CREATED CONFIRMATION PAGE
	@RequestMapping(value="/created")
	public String accountCreated() {
		
		return "accountCreated";
		
	}
	
}
