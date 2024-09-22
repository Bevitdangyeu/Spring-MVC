package springMVC.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/public/Cart")
public class CartController {
	@RequestMapping(value="/view", method = RequestMethod.GET)
	public ModelAndView view() {
		ModelAndView mav=new ModelAndView("Cart");	
		return mav;
		
	}
}
