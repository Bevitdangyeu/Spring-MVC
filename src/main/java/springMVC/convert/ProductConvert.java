package springMVC.convert;

import java.util.ArrayList;
import java.util.List;

import springMVC.DTO.ProductDTO;
import springMVC.entity.ProductEntity;

public class ProductConvert {
	public void toDTO(ProductEntity entity) {
		ProductDTO product=new ProductDTO();
		product.setCategoryId(entity.getCategory().getCateroryId());
		product.setCategoryName(entity.getCategory().getCategoryName());
		product.setDescription(entity.getDescription());
		product.setImage(entity.getImage());
		List<String> listImage=new ArrayList<String>();
		for(int i=0;i<entity.getListImage().size();i++) {
			listImage.add(entity.getListImage().get(i).getImgae());
		}
		product.setListImage(listImage);
		product.setPrince(entity.getPrince());
		product.setProductId(entity.getProductId());
		product.setProductName(entity.getName());
		product.setQuantity(entity.getQuantity());
	}
}
