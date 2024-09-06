package springMVC.service.Interface;

import java.util.List;

import springMVC.DTO.ProductDTO;
import springMVC.entity.ProductEntity;

public interface IProductService {
	ProductDTO save(ProductDTO product);
	List<ProductDTO> findAll();
	ProductDTO findOne ( int id);
	void delete(List<Integer> list);
	
}
