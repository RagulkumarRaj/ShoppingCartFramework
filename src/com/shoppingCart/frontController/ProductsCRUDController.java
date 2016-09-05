package com.shoppingCart.frontController;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.shoppingCart.dao.ProductsDAO;
import com.shoppingCart.dao.entity.Product;
import com.shoppingCart.dao.entity.ProductWithImage;
import com.sun.org.apache.xml.internal.security.utils.Base64;

@Controller
public class ProductsCRUDController {
	@RequestMapping(value="addProduct", method=RequestMethod.POST)
	public ModelAndView addProducToDB(@RequestParam("productName") String productName,
			@RequestParam("cost") String cost,
			@RequestParam("multiPartFileData") MultipartFile multiPartFileData){
		/*String message = "success";*/
		Product product = new Product();
		product.setCost(Integer.parseInt(cost));
		product.setProductName(productName);
		try{
		byte[] imageData = multiPartFileData.getBytes();
		product.setImageByteData(Base64.encode(imageData).toCharArray());
		}
		catch(IOException ioex){
			ioex.printStackTrace();
		}
		ProductsDAO.getInstance().addProduct(product);
		String message = "success";
		return new ModelAndView("index", "message", message);
	}
	
	@RequestMapping(value="addProduct", method=RequestMethod.GET)
	public ModelAndView displayAddProductPage(){
		System.out.println("Add Product Get Method");
		String message = "success";
		return new ModelAndView("addProduct", "message", message);
	}
	
	@RequestMapping(value = "viewProductList", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String viewExistingProductList(){
		System.out.println("View Existing Products List");
		List<Product> productList = ProductsDAO.getInstance().viewProductsList();
		Iterator<Product> it = productList.iterator();
		String json = new Gson().toJson(productList );
		return json;
	}
}
