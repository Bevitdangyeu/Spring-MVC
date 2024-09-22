package springMVC.controllers.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import springMVC.DTO.BillDTO;
import springMVC.DTO.ProductCartDTO;
import springMVC.DTO.ProductDTO;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
@Controller
@RequestMapping("/public/checkout")
public class CheckoutController {
	@Autowired
	HttpServletRequest request;
	@PostMapping("/add")
	public String checkout(@RequestBody BillDTO bill) {
		float totalBill=0;
		for(int i=0;i<bill.getItems().size();i++) {
			float tong=bill.getItems().get(i).getPrince()*bill.getItems().get(i).getQuantity();
			totalBill+=tong;
			bill.getItems().get(i).setTotal(tong);		
		}
		bill.setTotalPrice(totalBill);	
		for( int i=0;i<bill.getItems().size();i++) {
			System.out.println(" name: "+bill.getItems().get(i).getProduct());
			System.out.println(" size: "+bill.getItems().get(i).getSize());
			System.out.println(" color: "+bill.getItems().get(i).getColor());
			System.out.println(" img: "+bill.getItems().get(i).getImage());
		}
		HttpSession session=request.getSession();
		session.setAttribute("checkout", bill);
		return "Checkout";
	}
	@GetMapping("/confirm")
    public String confirmPage(Model model) {
        // Chuyển hướng đến trang confirm sau khi xử lý xong
        return "Checkout"; // Trả về trang Checkout.jsp
    }
}
