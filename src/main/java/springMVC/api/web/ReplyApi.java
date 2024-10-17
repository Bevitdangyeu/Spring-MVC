package springMVC.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import springMVC.DTO.ReplyDTO;
import springMVC.service.Interface.IReplyService;

@RestController
@RequestMapping("/user/reply")
public class ReplyApi {
	@Autowired IReplyService replyService;
	@ResponseBody // chuyển dữ liệu trả về thành dạng dto
	@PostMapping("/add")
	public ReplyDTO add(@RequestBody ReplyDTO reply) {
		ReplyDTO rep=replyService.add(reply);
		return rep;
	}
}
