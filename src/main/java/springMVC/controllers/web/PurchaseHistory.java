package springMVC.controllers.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springMVC.DTO.BillDTO;
import springMVC.service.Implement.BillService;
import springMVC.service.Interface.IBillService;

@Controller
@RequestMapping("/user/PurchaseHistory")
public class PurchaseHistory {
	@Autowired IBillService billService;
	@RequestMapping(value="/confirm",method = RequestMethod.GET)
	private ModelAndView FindConfirm(@RequestParam(value="customerId") int customerId) {
		List<BillDTO> list= billService.PurchaseHistory(customerId, "Chờ xác nhận");
		System.out.println(" list: "+list.size());
		ModelAndView mav=new ModelAndView("PurchaseHistory");
		mav.addObject("list", list);
		return mav;
	}
	@RequestMapping(value="/ALL",method = RequestMethod.GET)
	private ModelAndView FindAll(@RequestParam(value="customerId") int customerId) {
		List<BillDTO> list= billService.PurchaseHistory(customerId, "");
		System.out.println(" list: "+list.size());
		ModelAndView mav=new ModelAndView("PurchaseHistory");
		mav.addObject("list", list);
		return mav;
	}
	@RequestMapping(value="/Pay",method = RequestMethod.GET)
	private ModelAndView FindPay(@RequestParam(value="customerId") int customerId) {
		List<BillDTO> list= billService.PurchaseHistory(customerId, "Đang");
		System.out.println(" list: "+list.size());
		ModelAndView mav=new ModelAndView("PurchaseHistory");
		mav.addObject("list", list);
		return mav;
	}
	@RequestMapping(value="/Complete",method = RequestMethod.GET)
	private ModelAndView FindComplete(@RequestParam(value="customerId") int customerId) {
		List<BillDTO> list= billService.PurchaseHistory(customerId, "hoàn thành");
		System.out.println(" list: "+list.size());
		ModelAndView mav=new ModelAndView("PurchaseHistory");
		mav.addObject("list", list);
		return mav;
	}
}
