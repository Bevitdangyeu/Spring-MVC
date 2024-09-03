package springMVC.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import springMVC.DTO.CategoryDTO;
import springMVC.DTO.ProductDTO;
import springMVC.service.Interface.ICategoryService;
import springMVC.service.Interface.IProductService;

@Controller
@RequestMapping("/admin1")
public class ProductController {
	@Autowired
	ICategoryService category;
	@Autowired
	private IProductService productService;
	@RequestMapping(value = "/home", method =RequestMethod.GET  )
	public ModelAndView homePage() {
		ModelAndView mav=new ModelAndView("admin");
		return mav;
	}
	@RequestMapping(value = "/list", method =RequestMethod.GET  )
	public ModelAndView List() {
		ModelAndView mav=new ModelAndView("ListProduct");
		List<ProductDTO> list=productService.findAll();
		mav.addObject("listProduct", list);
		return mav;
	}
	@RequestMapping(value = "/edit",method = RequestMethod.GET)
	public ModelAndView Product() {
	    ModelAndView modelAndView = new ModelAndView();
		List<CategoryDTO> listCategory=category.findAll();
		modelAndView.setViewName("EditProduct");
		modelAndView.addObject("category", listCategory);
		return modelAndView;
	}
}
