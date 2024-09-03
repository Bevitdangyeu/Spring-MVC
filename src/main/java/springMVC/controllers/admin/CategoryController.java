package springMVC.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import springMVC.DTO.CategoryDTO;
import springMVC.service.Interface.ICategoryService;
@Controller
@RequestMapping("/admin12")
public class CategoryController {
	@Autowired
	ICategoryService category;
	/*@RequestMapping(value = "/home", method =RequestMethod.GET  )
	public ModelAndView homePage() {
		ModelAndView mav=new ModelAndView("admin");
		return mav;
	}*/
	@RequestMapping(value = "/product",method = RequestMethod.GET)
	public ModelAndView Product() {
	    ModelAndView modelAndView = new ModelAndView();
		List<CategoryDTO> listCategory=category.findAll();
		modelAndView.setViewName("EditProduct");
		modelAndView.addObject("category", listCategory);
		return modelAndView;
	}
}
