package com.shoppingCart.frontController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FrontController {
	
	@RequestMapping("/admin")
	public ModelAndView welcomeAdmin(){
		String message = "Hiiii";
		return new ModelAndView("admin", "message", message);
	}
	
	@RequestMapping("/")
	public ModelAndView welcomePage(){
		String message = "Hiiii";
		return new ModelAndView("index", "message", message);
	}
	
	@RequestMapping("/data")
	public ModelAndView data(){
		String message = "[{\"name\":\"ragul\"}, {\"name1\":\"kumar\"}]";
		return new ModelAndView("welcome", "message", message);
	}
}
