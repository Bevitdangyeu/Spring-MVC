package springMVC.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springMVC.DTO.FeedbackDTO;

import springMVC.service.Interface.IFeedbackService;



@RestController
@RequestMapping("/user/feedback")
public class FeedbackApi {
	@Autowired IFeedbackService feedbackService;
	@RequestMapping(value="/add",method = RequestMethod.POST)
	private void addfeedback(@RequestBody FeedbackDTO feedback) {
		feedbackService.add(feedback);
	}
}
