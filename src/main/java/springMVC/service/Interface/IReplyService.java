package springMVC.service.Interface;

import springMVC.DTO.ReplyDTO;
import springMVC.entity.ReplyEntity;

import java.util.List;
public interface IReplyService {
	public ReplyDTO add(ReplyDTO reply);
	//public List<ReplyDTO> findByFeedbackId(int id);
}
