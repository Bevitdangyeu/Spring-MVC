package springMVC.api.Admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springMVC.DTO.BillDTO;
import springMVC.DTO.CartDTO;
import springMVC.DTO.CheckoutDTO;
import springMVC.DTO.ProductCartDTO;
import springMVC.service.Interface.IBillService;

@RestController
@RequestMapping("/api/bill")
public class BillAPI {
	@Autowired
	IBillService billService;
	@Autowired
	HttpServletRequest request;
	@PostMapping("/add")
	public BillDTO add(@RequestBody BillDTO ListbillCheckout ) {
		BillDTO billDTO=billService.addBill(ListbillCheckout);
		if(ListbillCheckout.getEmployeeID()==1) {
			HttpSession session=request.getSession();
			CartDTO cart=(CartDTO) session.getAttribute("cart");
			// lấy ra list sản phẩm trong cart;
			
			// lặp qua danh sách các sản phẩm trong giỏ hàng với danh sách sản phẩm đã mua nếu sản phẩm nào trùng với sản phẩm đã mua thì remove
			for( int i=0;i<cart.getList().size();i++) {
				for( int j=0;j<ListbillCheckout.getItems().size();j++) {
					ProductCartDTO prooduct=cart.getList().get(i);
					CheckoutDTO billCheckout=ListbillCheckout.getItems().get(j);
					System.out.println(" \nname: "+prooduct.getProduct().getProductName()+" và "+ billCheckout.getProduct());
					System.out.println(" \ncolor: "+prooduct.getColor()+" và "+ billCheckout.getColor());
					System.out.println(" \nsize: "+prooduct.getSize()+" và "+ billCheckout.getSize());
					if (prooduct.getProduct().getProductName().equals(billCheckout.getProduct())
							&& prooduct.getColor().equals(billCheckout.getColor())
							&& prooduct.getSize().equals(billCheckout.getSize()))
					{
						// nếu như trùng thì remove
						
						cart.getList().remove(prooduct);
					}
						
				}
			}
			request.setAttribute("cart", cart);
		}
		return billDTO;
	}
	@DeleteMapping("/delete")
	public int delete(@RequestBody BillDTO bill) {
		int result= billService.delete(bill);
		return result;
	}
	@PostMapping("/updateStatus")
	public void update(@RequestBody BillDTO bill) {
		System.out.print("billid: "+bill.getBillId());
		System.out.print("status: "+bill.getStatus());
		billService.updateStatus(bill);
	}
}

