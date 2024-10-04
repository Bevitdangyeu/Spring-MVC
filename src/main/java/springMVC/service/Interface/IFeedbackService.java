package springMVC.service.Interface;


import springMVC.DTO.FeedbackDTO;
import java.util.List;
public interface IFeedbackService {
	public void add(FeedbackDTO feedback);
	public List<FeedbackDTO> findByproductId(int id);
}
