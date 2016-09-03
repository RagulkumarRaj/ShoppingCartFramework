package com.shoppingCart.frontController;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.shoppingCart.dao.ProductsDAO;
import com.shoppingCart.dao.entity.Product;
import com.shoppingCart.dao.entity.ProductWithImage;

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
