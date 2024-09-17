package springMVC.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import springMVC.DTO.CategoryDTO;
import springMVC.DTO.ProductDTO;
import springMVC.entity.ProductEntity;
import springMVC.service.Interface.ICategoryService;
import springMVC.service.Interface.IProductService;

@Controller
@RequestMapping("/admin1")
public class ProductController {
	@Autowired
	ICategoryService category;
	@Autowired
	private IProductService productService;
	@RequestMapping(value = "/home", method =RequestMethod.GET  )
	public ModelAndView homePage() {
		ModelAndView mav=new ModelAndView("admin");
		return mav;
	}
	@RequestMapping(value = "/product/list", method =RequestMethod.GET  )
	public ModelAndView List(@RequestParam (value="page") int page,
			@RequestParam(value = "totalItem") int limit,
			@RequestParam(value = "sortBy") String sortBy) {
		Pageable pageable=PageRequest.of(page-1, limit,Sort.by(sortBy).descending());
		// tính tổng số trang
		ProductDTO product=new ProductDTO();	
		product.setSortBy(sortBy);
		product.setTotalPage(productService.count()/limit);
		product.setPage(page);
		product.setTotalItem(limit);
		List<ProductDTO> listProduct= productService.findAll(pageable);
		ModelAndView mav=new ModelAndView("ListProduct");
		mav.addObject("product", product);
		mav.addObject("listProduct", listProduct);
		return mav;
	}
	@RequestMapping(value = "product/edit",method = RequestMethod.GET)
	public ModelAndView Product(@RequestParam(value = "id",required = false) Integer id) {
		 ModelAndView modelAndView = new ModelAndView();
		// chỉnh sửa-> lấy đối tượng lên để chỉnh sửa 
		if(id!=null) {
			ProductDTO product=productService.findOne(id);
			System.out.println(" image: "+product.getImage());
			System.out.println(" listimage: "+product.getListImage().get(0));
			modelAndView.addObject("product", product);
		}
	   
		List<CategoryDTO> listCategory=category.findAll();
		modelAndView.setViewName("EditProduct");
		modelAndView.addObject("category", listCategory);
		return modelAndView;
	}
}
