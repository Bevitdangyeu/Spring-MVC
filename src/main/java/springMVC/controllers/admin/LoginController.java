package springMVC.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import springMVC.entity.UserAndPassEntity;
import springMVC.repository.UseRepository;
import springMVC.service.CustomUserDetailsService;

@Controller
@RequestMapping
public class LoginController {
	@Autowired
	private UseRepository userRepository;
	@RequestMapping(value = "/login", method =RequestMethod.GET  )
	public ModelAndView homePage() {
		ModelAndView mav=new ModelAndView("login");
		return mav;
	}
	
}
