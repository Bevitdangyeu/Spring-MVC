package springMVC.service.Interface;

import java.util.List;

import org.springframework.data.domain.Pageable;

import springMVC.DTO.ProductDTO;
import springMVC.entity.ProductEntity;

public interface IProductService {
	ProductDTO save(ProductDTO product);
	List<ProductDTO> findAll(Pageable page);
	List<ProductDTO> findAllProduct();
	ProductDTO findOne ( int id);
	void delete(List<Integer> list);
	int count();
}
