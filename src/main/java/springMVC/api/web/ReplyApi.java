package springMVC.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springMVC.DTO.ReplyDTO;
import springMVC.service.Interface.IReplyService;

@RestController
@RequestMapping("/user/reply")
public class ReplyApi {
	@Autowired IReplyService replyService;
	@PostMapping("/add")
	public void add(@RequestBody ReplyDTO reply) {
		replyService.add(reply);
	}
}
