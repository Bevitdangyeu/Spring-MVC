package springMVC.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springMVC.DTO.BillDTO;
import springMVC.DTO.ProductDTO;
import springMVC.entity.ProductEntity;
import springMVC.service.Interface.IBillService;
import springMVC.service.Interface.IProductService;

@Controller
@RequestMapping("/admin1/bill")
public class BillController {
	@Autowired
	IProductService productService;
	@Autowired
	IBillService billService;
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public ModelAndView getList(@RequestParam(value="page") int page,
								@RequestParam(value="limit") int limit,
								@RequestParam(value="sortBy") String sortBy) {
		ModelAndView mav=new ModelAndView("ListBill");
		// do là phương thức of của PageRequest nó là static nên là không cần phải tạo đối tượng cho PageRequest 
		Pageable pageable= PageRequest.of(page-1, limit, Sort.by(sortBy).ascending());
		List<BillDTO> listBill=billService.findAll(pageable);
		System.out.println(" size: "+listBill.size());
		mav.addObject("listBill", listBill);
		return mav;
	}
	@RequestMapping(value="/edit", method = RequestMethod.GET)
	public ModelAndView  getEdit(@RequestParam(value="id",required = false) Integer id){
		ModelAndView mav=new ModelAndView("EditBill");
		List<ProductDTO> product=productService.findAllProduct();
		if(id!=null) {
			BillDTO bill=billService.findById(id);
			mav.addObject("bill", bill);
		}
		mav.addObject("product", product);	
		
		return mav;
	}
	@RequestMapping(value="/approveOrder", method = RequestMethod.GET)
	public ModelAndView approveOrder() {
		ModelAndView mav=new ModelAndView("approveOrder");
		List<BillDTO> list=billService.findApproveOrder("Chờ xác nhận");
		System.out.println(" size: "+list.size());
		mav.addObject("list", list);
		return mav;
		
	}
	
}
