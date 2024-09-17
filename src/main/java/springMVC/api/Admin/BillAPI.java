package springMVC.api.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springMVC.DTO.BillDTO;
import springMVC.service.Interface.IBillService;

@RestController
@RequestMapping("/api/bill")
public class BillAPI {
	@Autowired
	IBillService billService;
	@PostMapping("/add")
	public BillDTO add(@RequestBody BillDTO bill ) {
		BillDTO billDTO=billService.addBill(bill);
		return billDTO;
	}
	@DeleteMapping("/delete")
	public int delete(@RequestBody BillDTO bill) {
		int result= billService.delete(bill);
		return result;
	}
}

