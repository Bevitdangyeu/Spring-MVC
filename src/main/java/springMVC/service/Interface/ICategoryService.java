package springMVC.service.Interface;

import java.util.List;

import springMVC.DTO.CategoryDTO;
import springMVC.DTO.ProductDTO;
import springMVC.entity.ProductEntity;

public interface ICategoryService {
	List<CategoryDTO> findAll();
	
}
