package springMVC.service.Implement;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springMVC.DTO.CustomerDTO;
import springMVC.DTO.FeedbackDTO;
import springMVC.DTO.ReplyDTO;
import springMVC.entity.DetailBillEntity;
import springMVC.entity.FeedbackEntity;
import springMVC.entity.ProductEntity;
import springMVC.entity.ReplyEntity;
import springMVC.entity.customerEntity;
import springMVC.repository.BillDetailRepository;
import springMVC.repository.CustomerResponsitory;
import springMVC.repository.FeedbackRepository;
import springMVC.repository.ProductRespository;
import springMVC.service.Interface.IFeedbackService;
import java.util.List;
@Service
public class FeedbackService implements IFeedbackService {
	@Autowired CustomerResponsitory customerResponsitory;
	@Autowired ProductRespository productResponsitory;
	@Autowired FeedbackRepository feedbackReponsitory;
	@Autowired BillDetailRepository billDetailRepository;
	@Override
	public void add(FeedbackDTO feedback) {
		// chuyển từ DTO thành feedback Entity
		FeedbackEntity feedbackEntity=new FeedbackEntity();
		LocalDateTime currentDateTime = LocalDateTime.now();
		customerEntity customerEntity=customerResponsitory.findByCustomerName(feedback.getCustomer());
		ProductEntity productEntity=productResponsitory.findOneByName(feedback.getProduct());
		DetailBillEntity billDetail=billDetailRepository.findByDetailBillId(feedback.getBillDetailId());
		billDetail.setFeedbacked(1);
		billDetailRepository.save(billDetail);
		feedbackEntity.setCustomer(customerEntity);
		feedbackEntity.setProduct(productEntity);
		feedbackEntity.setDescription(feedback.getDescription());
		feedbackEntity.setStar(feedback.getStar());
		feedbackEntity.setSizeColor(feedback.getSizeColor());
		feedbackEntity.setDate(currentDateTime);
		feedbackReponsitory.save(feedbackEntity);		
	}
	@Transactional
	@Override
	public List<FeedbackDTO> findByproductId(int id) {
		List<FeedbackEntity> listFeedbackEntity=feedbackReponsitory.findByProductId(id);
		// chuyển từ entity sang dto
		List<FeedbackDTO> listFeedbackDTO=new ArrayList<FeedbackDTO>();
		for(int i=0;i<listFeedbackEntity.size();i++) {
			FeedbackDTO feedback=new FeedbackDTO();
			FeedbackEntity feedbackEntity=listFeedbackEntity.get(i);
			// chuyển đổi kiểu local datetime sang String
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			feedback.setDate(feedbackEntity.getDate().format(formatter));
			feedback.setReviewId(feedbackEntity.getFeedbackId());
			feedback.setCustomer(feedbackEntity.getCustomer().getCustomerName());
			feedback.setDescription(feedbackEntity.getDescription());
			feedback.setProduct(feedbackEntity.getProduct().getName());
			feedback.setStar(feedbackEntity.getStar());
			feedback.setReviewId(feedbackEntity.getFeedbackId());
			List<ReplyDTO> listReply=new ArrayList<ReplyDTO>();
			for( int j=0;j<listFeedbackEntity.get(i).getReply().size();j++) {
				ReplyEntity reply=listFeedbackEntity.get(i).getReply().get(j);
				ReplyDTO replyDto=new ReplyDTO();
				DateTimeFormatter formatterReply = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
				replyDto.setReplyId(reply.getReplyId());
				// chuyển đổi từ customerEntity sang customer DTO
				customerEntity customer=reply.getCustomer();
				CustomerDTO customerDTO=new CustomerDTO();
				customerDTO.setCustomerId(customer.getCustomerId());
				customerDTO.setCustomerName(customer.getCustomerName());
				replyDto.setCustomer(customerDTO);
				replyDto.setContent(reply.getContent());
				replyDto.setFeedback(reply.getFeedback().getFeedbackId());
				replyDto.setDate(reply.getDate().format(formatterReply));
				listReply.add(replyDto);
			}
			feedback.setReply(listReply);
			listFeedbackDTO.add(feedback);
		}
		return listFeedbackDTO;
	}

	

}
