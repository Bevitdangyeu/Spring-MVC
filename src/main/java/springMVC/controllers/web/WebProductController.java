package springMVC.controllers.web;

import java.util.List;

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
	public ModelAndView detailProduct(@RequestParam(value="id") int id,@RequestParam(value="caterogyId") int Caterogyid) {
		ModelAndView mav=new ModelAndView("DetailProduct");
		ProductDTO product=productService.findOne(id);
		List<ProductDTO> Related=productService.findRelatedProduct(Caterogyid);
		mav.addObject("Related", Related);
		mav.addObject("product", product);
		return mav;
		
	}
} 
