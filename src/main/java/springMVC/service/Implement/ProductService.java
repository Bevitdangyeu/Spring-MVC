package springMVC.service.Implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springMVC.DTO.ProductDTO;
import springMVC.entity.CaterogyEntity;
import springMVC.entity.ImageEntity;
import springMVC.entity.ProductEntity;
import springMVC.repository.CategoryResponsitory;
import springMVC.repository.ProductRespository;
import springMVC.service.Interface.IProductService;

@Service
public class ProductService implements IProductService{
	@Autowired
		private ProductRespository productRepository;
	@Autowired
		private CategoryResponsitory category;
	@Override
	public ProductDTO save(ProductDTO product) {
		CaterogyEntity cate=category.findByCategoryName(product.getCategoryName());
		ProductEntity productEntity=new ProductEntity();
		productEntity.setName(product.getProductName());
		productEntity.setCategory(cate);
		productEntity.setQuantity(product.getQuantity());
		productEntity.setPrince(product.getPrince());
		productEntity.setStatus(1);
		productEntity.setDescription(product.getDescription());
		productEntity.setImage(product.getImage());
		java.util.List<ImageEntity> listImage =new ArrayList<ImageEntity>();
		for(int i=0;i<product.getListImage().size();i++) {
			ImageEntity image=new ImageEntity();
			image.setImgae(product.getListImage().get(i));
			image.setProduct(productEntity);
			listImage.add(image);
		}
		productEntity.setListImage(listImage);
		ProductEntity pro= productRepository.save(productEntity);
		ProductDTO DTO=new ProductDTO();
		DTO.setCategoryId(pro.getCategory().getCateroryId());
		DTO.setQuantity(pro.getQuantity());
		DTO.setPrince(pro.getPrince());
		
		return DTO;
	}
	@Override
	public List<ProductDTO> findAll() {
		List<ProductEntity> list=productRepository.findAll();
		// chuyển từ entity sang DTO
		List<ProductDTO> listProductDTO=new ArrayList<ProductDTO>();
		for(int i=0;i<list.size();i++) {
			ProductDTO productDTO=new ProductDTO();
			productDTO.setProductName(list.get(i).getName());
			productDTO.setCategoryName(list.get(i).getCategory().getCategoryName());
			productDTO.setDescription(list.get(i).getDescription());
			productDTO.setImage(list.get(i).getImage());
			productDTO.setPrince(list.get(i).getPrince());
			productDTO.setQuantity(list.get(i).getQuantity());
			listProductDTO.add(productDTO);
		}
		
		return listProductDTO;
	}
	

}
