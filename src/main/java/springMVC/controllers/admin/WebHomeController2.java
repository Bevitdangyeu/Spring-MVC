package springMVC.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/user")
public class WebHomeController2 {
	
	@RequestMapping(value = "/home", method =RequestMethod.GET  )
	public ModelAndView homePage() {
		ModelAndView mav=new ModelAndView("home");
		return mav;
	}
	
}
