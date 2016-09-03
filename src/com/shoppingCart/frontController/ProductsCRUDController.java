package com.shoppingCart.frontController;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.shoppingCart.dao.ProductsDAO;
import com.shoppingCart.dao.entity.ProductWithImage;

@Controller
public class ProductsCRUDController {
	@RequestMapping(value="addProduct", method=RequestMethod.POST)
	public ModelAndView addProducToDB(@RequestParam("productName") String productName,
			@RequestParam("cost") String cost,
			@RequestParam("multiPartFileData") MultipartFile multiPartFileData){
		/*String message = "success";*/
		ProductWithImage product = new ProductWithImage();
		product.setCost(Integer.parseInt(cost));
		product.setProductName(productName);
		try{
		byte[] imageData = multiPartFileData.getBytes();
		product.setImageByteData(imageData);
		}
		catch(IOException ioex){
			ioex.printStackTrace();
		}
		//product.setMultiPartFileData(multiPartFileData);
		//product.setImageByteDataFromMultipart();
		ProductsDAO.getInstance().addProductWithImage(product);
		String message = "success";
		return new ModelAndView("index", "message", message);
	}
	
	@RequestMapping(value="addProduct", method=RequestMethod.GET)
	public ModelAndView displayAddProductPage(){
		System.out.println("Add Product Get Method");
		String message = "success";
		return new ModelAndView("addProduct", "message", message);
	}
	
	@RequestMapping(value="viewProductList", method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView viewExistingProductList(){
		System.out.println("View Existing Products List");
		List productList = ProductsDAO.getInstance().viewProductsList();
		return new ModelAndView("index", "message", message);
	}
}
