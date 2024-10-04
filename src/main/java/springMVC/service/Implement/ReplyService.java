package springMVC.service.Implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springMVC.DTO.ReplyDTO;
import springMVC.entity.FeedbackEntity;
import springMVC.entity.ReplyEntity;
import springMVC.entity.customerEntity;
import springMVC.repository.CustomerResponsitory;
import springMVC.repository.FeedbackRepository;
import springMVC.repository.ReplyRepository;
import springMVC.service.Interface.IReplyService;
import java.util.List;
@Service
public class ReplyService implements IReplyService{
	@Autowired CustomerResponsitory customerRepository;
	@Autowired FeedbackRepository feedbackRepository;
	@Autowired ReplyRepository replyRepository;
	@Override
	public void add(ReplyDTO reply) {
		// chuyển từ dto thành entity
		if(reply.getReplyId()==0) {
			ReplyEntity replyEntity=new ReplyEntity();
			replyEntity.setContent(reply.getContent());
			customerEntity customer=customerRepository.findByCustomerName(reply.getCustomer().getCustomerName());
			FeedbackEntity feedback=feedbackRepository.findByFeedbackId(reply.getFeedback());
			replyEntity.setCustomer(customer);
			replyEntity.setFeedback(feedback);
			replyRepository.save(replyEntity);
		}
		else if(reply.getReplyId()!=0) {
			ReplyEntity replyEntity=replyRepository.findByReplyId(reply.getReplyId());
			replyEntity.setContent(reply.getContent());
			customerEntity customer=customerRepository.findByCustomerName(reply.getCustomer().getCustomerName());
			//FeedbackEntity feedback=feedbackRepository.findByFeedbackId(reply.getFeedback());
			replyEntity.setCustomer(customer);
		//	replyEntity.setFeedback(feedback);
			replyRepository.save(replyEntity);
		}
		
	}
/*	@Override
	public List<ReplyDTO> findByFeedbackId(int id) {
		List<ReplyEntity> ListReplyEntity=replyRepository.findByFeedbackId(id);
		List<ReplyDTO> listReplyDTO=new ArrayList<ReplyDTO>();
		for(int i=0;i<ListReplyEntity.size();i++) {
			ReplyDTO reply=new ReplyDTO();
			reply.setReplyId(ListReplyEntity.get(i).getReplyId());
			reply.setFeedback(ListReplyEntity.get(i).getFeedback().getFeedbackId());
			reply.setContent(ListReplyEntity.get(i).getContent());
			reply.setCustomer(ListReplyEntity.get(i).getCustomer().getCustomerName());
			listReplyDTO.add(reply);
		}
		return listReplyDTO;
	}
	*/
	
}
