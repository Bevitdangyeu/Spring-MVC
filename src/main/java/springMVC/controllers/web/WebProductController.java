package springMVC.controllers.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springMVC.DTO.ProductDTO;
import springMVC.service.Interface.IProductService;

@Controller
@RequestMapping(value="/public/product")
public class WebProductController {
	@Autowired
	IProductService productService;
	@RequestMapping(value="/detail",method = RequestMethod.GET)
	public ModelAndView detailProduct(@RequestParam(value="id") int id) {
		ModelAndView mav=new ModelAndView("DetailProduct");
		ProductDTO product=productService.findOne(id);
		mav.addObject("product", product);
		return mav;
		
	}
} 
