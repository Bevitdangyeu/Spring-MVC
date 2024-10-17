package springMVC.service.Implement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springMVC.DTO.ReplyDTO;
import springMVC.entity.FeedbackEntity;
import springMVC.entity.ReplyEntity;
import springMVC.entity.customerEntity;
import springMVC.repository.CustomerResponsitory;
import springMVC.repository.FeedbackRepository;
import springMVC.repository.ReplyRepository;
import springMVC.service.Interface.ICustomerService;
import springMVC.service.Interface.IReplyService;
import java.util.List;
@Service
public class ReplyService implements IReplyService{
	@Autowired CustomerResponsitory customerRepository;
	@Autowired FeedbackRepository feedbackRepository;
	@Autowired ReplyRepository replyRepository;
	@Autowired ICustomerService customerService;
	
	@Transactional
	@Override
	public ReplyDTO add(ReplyDTO reply) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM HH:mm");
		ReplyEntity rep=new ReplyEntity();
		// chuyển từ dto thành entity
		if(reply.getReplyId()==0) { // thêm
			LocalDateTime currentDateTime = LocalDateTime.now();
			ReplyEntity replyEntity=new ReplyEntity();
			replyEntity.setContent(reply.getContent());
			customerEntity customer=customerRepository.findByCustomerName(reply.getCustomer().getCustomerName());
			FeedbackEntity feedback=feedbackRepository.findByFeedbackId(reply.getFeedback());
			replyEntity.setCustomer(customer);
			replyEntity.setFeedback(feedback);
			replyEntity.setDate(currentDateTime);
			rep = replyRepository.save(replyEntity);
			// chuyển đổi tượng đó thành dto
			
		}
		else if(reply.getReplyId()!=0) { // sửa
			ReplyEntity replyEntity=replyRepository.findByReplyId(reply.getReplyId());
			replyEntity.setContent(reply.getContent());
			customerEntity customer=customerRepository.findByCustomerName(reply.getCustomer().getCustomerName());
			//FeedbackEntity feedback=feedbackRepository.findByFeedbackId(reply.getFeedback());
			replyEntity.setCustomer(customer);
		//	replyEntity.setFeedback(feedback);
			rep=replyRepository.save(replyEntity);
		}
		ReplyDTO repDto=new ReplyDTO();
		repDto.setContent(rep.getContent());
		repDto.setCustomer(customerService.findByCustomerId(rep.getCustomer().getCustomerId()));
		repDto.setDate(rep.getDate().format(formatter));
		repDto.setFeedback(rep.getFeedback().getFeedbackId());
		repDto.setReplyId(rep.getReplyId());
		return repDto;
		
		
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
