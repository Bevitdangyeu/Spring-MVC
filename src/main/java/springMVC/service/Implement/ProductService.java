package springMVC.service.Implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		ProductDTO DTO=new ProductDTO();
		// thêm mới
		if(product.getProductId()==0) {
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
				// cho biết image( dòng dữ liệu) này có khóa ngoại là productId(product nào) xác định khóa ngoại 
				image.setProduct(productEntity);
				listImage.add(image);
			}
			productEntity.setListImage(listImage);
			ProductEntity pro= productRepository.save(productEntity);	
			DTO.setCategoryId(pro.getCategory().getCateroryId());
			DTO.setQuantity(pro.getQuantity());
			DTO.setPrince(pro.getPrince());
		
		} else if(product.getProductId()!=0) {
			ProductEntity oldProduct=productRepository.findOneByProductId(product.getProductId());
			oldProduct.setName(product.getProductName());
			oldProduct.setCategory(cate);
			oldProduct.setQuantity(product.getQuantity());
			oldProduct.setPrince(product.getPrince());
			oldProduct.setStatus(1);
			oldProduct.setDescription(product.getDescription());			
			java.util.List<ImageEntity> listImage =new ArrayList<ImageEntity>();
			if(product.getImage()!=null) {
				oldProduct.setImage(product.getImage());
			}
			if(product.getListImage().size()>0) {
				for(int i=0;i<product.getListImage().size();i++) {
					ImageEntity image=new ImageEntity();
					image.setImgae(product.getListImage().get(i));
					image.setProduct(oldProduct);
					listImage.add(image);
				}
				oldProduct.setListImage(listImage);
			}
			// nếu người dùng không thay đổi thì vẫn lấy giá trị cũ đã được thêm trước đó
			ProductEntity pro= productRepository.save(oldProduct);	
			DTO.setCategoryId(pro.getCategory().getCateroryId());
			DTO.setQuantity(pro.getQuantity());
			DTO.setPrince(pro.getPrince());
		}
		return DTO;
	}
	@Override
	public List<ProductDTO> findAll() {
		List<ProductEntity> list=productRepository.findAll();
		// chuyển từ entity sang DTO
		List<ProductDTO> listProductDTO=new ArrayList<ProductDTO>();
		for(int i=0;i<list.size();i++) {
			ProductDTO productDTO=new ProductDTO();
			productDTO.setProductId(list.get(i).getProductId());
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
	@Transactional
	@Override
	public ProductDTO findOne(int id) {
		ProductEntity productEntity=productRepository.findOneByProductId(id);
		ProductDTO DTO=new ProductDTO();
		DTO.setProductId(productEntity.getProductId());
		DTO.setProductName(productEntity.getName());
		DTO.setCategoryId(productEntity.getCategory().getCateroryId());
		DTO.setCategoryName(productEntity.getCategory().getCategoryName());
		DTO.setImage(productEntity.getImage());
		List<String> listImage=new ArrayList<String>();
		for(int i=0;i<productEntity.getListImage().size();i++) {
			String image=productEntity.getListImage().get(i).getImgae();
			listImage.add(image);
		}
		DTO.setListImage(listImage);
		DTO.setDescription(productEntity.getDescription());
		DTO.setPrince(productEntity.getPrince());
		DTO.setQuantity(productEntity.getQuantity());
		return DTO;
	}
	@Override
	public void delete(List<Integer> list) {
		for(int i=0;i<list.size();i++) {
			productRepository.deleteById(list.get(i));
		}
		
	}
	
	

}
