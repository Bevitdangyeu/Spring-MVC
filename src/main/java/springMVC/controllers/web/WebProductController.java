package springMVC.controllers.web;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.internal.requests.FilterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springMVC.DTO.FeedbackDTO;
import springMVC.DTO.ProductDTO;
import springMVC.DTO.ReplyDTO;
import springMVC.service.Interface.IFeedbackService;
import springMVC.service.Interface.IProductService;
import springMVC.service.Interface.IReplyService;

@Controller
@RequestMapping(value="/public/product")
public class WebProductController {
	@Autowired IProductService productService;
	@Autowired IFeedbackService feedbackService;
	@Autowired IReplyService replyService;
	@RequestMapping(value="/detail",method = RequestMethod.GET) 
	public ModelAndView detailProduct(@RequestParam(value="id") int id,@RequestParam(value="caterogyId") int Caterogyid) {
		ModelAndView mav=new ModelAndView("DetailProduct");
		ProductDTO product=productService.findOne(id);
		List<ProductDTO> Related=productService.findRelatedProduct(Caterogyid);
		List<FeedbackDTO> feedback=feedbackService.findByproductId(id);
		mav.addObject("feedback", feedback);
		mav.addObject("Related", Related);
		mav.addObject("product", product);
		return mav;
		
	}
	
	
} 
