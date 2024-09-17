package springMVC.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springMVC.DTO.ProductDTO;
import springMVC.service.Interface.IProductService;
@Controller
@RequestMapping("/public")
public class WebHomeController {
	@Autowired IProductService productService;
	@RequestMapping(value = "/home", method =RequestMethod.GET  )
	public ModelAndView homePage(@RequestParam(value="page",required = false) int page,
								@RequestParam(value = "limit",required = false )int limit,
								@RequestParam(value="sortBy",required = false) String sortBy) {
		ModelAndView mav=new ModelAndView("home");
		if(page==0) {
			page=1;
			limit=5;
			sortBy="name";
		}
		// gán dữ liệu để truyền vào phân trang
		ProductDTO product=new ProductDTO();
		product.setPage(page);
		product.setTotalItem(limit);
		product.setTotalPage(productService.count()/limit);
		product.setSortBy(sortBy);
		// lấy dữ liệu lên để hiển thị 
		Pageable pageable=PageRequest.of(page-1, limit, Sort.by(sortBy).descending());
		List<ProductDTO> list=productService.findAll(pageable);
		mav.addObject("product", product);
		mav.addObject("list", list);
		return mav;
	}
	
}
