package springMVC.service.Implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springMVC.DTO.ProductDTO;
import springMVC.entity.CaterogyEntity;
import springMVC.entity.ColorEntity;
import springMVC.entity.ImageEntity;
import springMVC.entity.ProductEntity;
import springMVC.entity.SizeEntity;
import springMVC.paging.PageRequest;
import springMVC.repository.CategoryResponsitory;
import springMVC.repository.ColorRespository;
import springMVC.repository.ProductRespository;
import springMVC.repository.SizeRespository;
import springMVC.service.Interface.IProductService;

@Service
public class ProductService implements IProductService{
	@Autowired
		private ProductRespository productRepository;
	@Autowired
		private CategoryResponsitory category;
	@Autowired
		private SizeRespository sizeRepository;
	@Autowired
		private ColorRespository colorRepository;
	@Transactional
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
			// kiểm tra xem color đã tồn tại chưa, nếu chưa thì thêm mới 
			List<ColorEntity> listColor=new ArrayList<ColorEntity>();
			for(int i=0;i<product.getListColor().size();i++) {
				ColorEntity color= colorRepository.findBycolorName(product.getListColor().get(i));
				if(color==null) {
					color=new ColorEntity();
					color.setColorName(product.getListColor().get(i));
					color.getListProduct().add(productEntity);
					colorRepository.save(color);
					listColor.add(color);
				}
				else {
					color.getListProduct().add(productEntity);
					listColor.add(color);
				}
			}
			// kiểm tra xem size có trong bảng size hay không nếu chưa thì thêm vào
			List<SizeEntity> listSize=new ArrayList<SizeEntity>();
			for(int i=0;i<product.getListSize().size();i++) {
				SizeEntity size=sizeRepository.findBySizeName(product.getListSize().get(i));
					size.getListProduct().add(productEntity);
					listSize.add(size);
			}
			productEntity.setListSize(listSize);
			productEntity.setListColor(listColor);
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
	@Transactional
	@Override
	public List<ProductDTO> findAll(Pageable page) {
		List<ProductEntity> list=(List<ProductEntity>) productRepository.findAll(page).getContent();
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
			List<String> listImage=new ArrayList<String>();
			for(int j=0;j<list.get(i).getListImage().size();j++) {
				String image=list.get(i).getListImage().get(j).getImgae();
				System.out.println("image: "+image);
				listImage.add(image);
			}
			productDTO.setListImage(listImage);
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
		List<String> listColor=new ArrayList<String>();
		for(int i=0;i<productEntity.getListColor().size();i++) {
			String color=productEntity.getListColor().get(i).getColorName();
			listColor.add(color);
		}
		List<String> listSize=new ArrayList<String>();
		for( int i=0;i<productEntity.getListSize().size();i++) {
			String size=productEntity.getListSize().get(i).getSizeName();
			listSize.add(size);
		}
		DTO.setListColor(listColor);
		DTO.setListSize(listSize);
		DTO.setListImage(listImage);
		DTO.setDescription(productEntity.getDescription());
		DTO.setPrince(productEntity.getPrince());
		DTO.setQuantity(productEntity.getQuantity());
		return DTO;
	}
	@Transactional
	@Override
	public void delete(List<Integer> list) {
		// nếu muốn xóa một product thì cần phải xóa dữ liệu từ bảng liên kết(vd product_size) trươcs
		// xóa dữ liệu từ bảng liên kết xóa liên kết từ 2 phía (xóa listSize mà sản phẩm đó liên kết và xóa product mà size đó đang liên kết 
		for(int i=0;i<list.size();i++) {			
			// lấy sản phẩm đó lên từ cơ sở dữ liệu
			ProductEntity product=productRepository.findOneByProductId(list.get(i));
			for( int j=0;j<product.getListColor().size();j++) {
				// sp Áo liên kết với size S M L thì phải tìm đối tượng size M xóa đối tượng Áo này ra khỏi danh sách các sp mà size này liên kết, tương tự với M và L
				// lấy size từ cơ sở dữ liệu
				ColorEntity color=colorRepository.findBycolorName(product.getListColor().get(j).getColorName());
				// remove product đó ra khỏi danh sách các product đang liên kết đến size đó
				color.getListProduct().remove(product);
				// lưu lại color đó với danh sách product mới
				colorRepository.save(color);
			}
			for(int j=0;j<product.getListSize().size();j++) {
				SizeEntity size=sizeRepository.findBySizeName(product.getListSize().get(j).getSizeName());
				size.getListProduct().remove(product);
				sizeRepository.save(size);
			}
			// sau đó xóa liên kết giữa product và size
			product.getListSize().clear();
			// xóa liên kết giữa product và color 
			product.getListColor().clear();
			//sau đó cập nhật lại đối tượng product ( không còn liên kết đến size và color=> sẽ không gây ra lỗi khóa ngoại)
			product=productRepository.save(product);
			// sau đó thực hiện xóa sản phẩm
			productRepository.deleteById(product.getProductId());
		}
		
	}
	@Override
	public int count() {
		return (int) productRepository.count();
	}
	@Override
	public List<ProductDTO> findAllProduct() {
		List<ProductEntity> list=(List<ProductEntity>) productRepository.findAll();
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

	
	
	

}
