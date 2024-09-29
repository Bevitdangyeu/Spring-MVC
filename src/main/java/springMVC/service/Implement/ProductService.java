package springMVC.service.Implement;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springMVC.DTO.ProductDTO;
import springMVC.entity.CaterogyEntity;
import springMVC.entity.ColorEntity;
import springMVC.entity.DetailBillEntity;
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
	 @Autowired
	    private EntityManager entityManager;
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
			// kiểm tra xem color đã tồn tại chưa, nếu chưa thì thêm mới cần phải đảm bảo color đó đã tồn tại trong cơ sở dữ liệu trước khi được add vào list trong productEntity
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
			// nếu như danh sách truyền vào có  color thì mới thực hiện
			// xử lí phần thay đổi color
			int findColor=0;
			// nếu danh sách color mới nhiều hơn cũ=>thêm mới
			if(product.getListColor().size()>=oldProduct.getListColor().size()) {	
				for(int i=0;i<product.getListColor().size();i++) {
					for(int j=0;j<oldProduct.getListColor().size();j++) {
						if(product.getListColor().get(i).equals(oldProduct.getListColor().get(j).getColorName())) {
							findColor=1;
							break;
						}
					}
					if(findColor==0) {
						String color=product.getListColor().get(i);
						ColorEntity colorEntity=colorRepository.findBycolorName(color);
						if(colorEntity==null) {
							// nếu màu này chưa có trong cơ sở dữ liệu 
							colorEntity=new ColorEntity();
							colorEntity.setColorName(color);
							colorEntity.getListProduct().add(oldProduct);
							colorRepository.save(colorEntity);				
						}
						else {
							colorEntity.getListProduct().add(oldProduct);
						}
						oldProduct.getListColor().add(colorEntity);
					}
					findColor=0;
				}
			}
			// nếu danh sách color mới ít hơn cũ=> xóa color
			if(product.getListColor().size()<oldProduct.getListColor().size()) {
				for(int i=0;i<oldProduct.getListColor().size();i++) {
					for(int j=0;j<product.getListColor().size();j++) {
						// so sánh từng cái color cũ với color mới nếu color cũ không tìm thấy trong danh sách color mới => xóa color đó
						if(oldProduct.getListColor().get(i).getColorName().equals(product.getListColor().get(j))) {
							findColor=1;
							break;
						}
					}
					if(findColor==0) {
						// lấy lên color sẽ xóa từ cơ sở dữ liệu
						String color=oldProduct.getListColor().get(i).getColorName();
						ColorEntity colorEntity=colorRepository.findBycolorName(color);
						// xóa product đó ra khỏi danh sach product của color đó
						colorEntity.getListProduct().remove(oldProduct);
						// xóa color đó ra khỏi danh sach color của product đó
						oldProduct.getListColor().remove(colorEntity);
						
					}
					findColor=0;
				}
			}
			
			
			/* Xử lí phần thay đổi size */
			int findSize=0;
			// nếu như danh sách size vừa thêm lớn hơn danh sách size cũ=> thêm mới size
			if(product.getListSize().size()>=oldProduct.getListSize().size()) {
				for(int i=0;i<product.getListSize().size();i++) { 
					for(int j=0;j<oldProduct.getListSize().size();j++) {
						if(product.getListSize().get(i).equals(oldProduct.getListSize().get(j).getSizeName())) {
							findSize=1;
							break;
						}
						
					}
					if(findSize==0) {
						String size=product.getListSize().get(i);
						SizeEntity sizeEntity=sizeRepository.findBySizeName(size);
						if(sizeEntity==null) {
							// nếu màu này chưa có trong cơ sở dữ liệu 
							sizeEntity=new SizeEntity();
							sizeEntity.setSizeName(size);
							sizeEntity.getListProduct().add(oldProduct);
							sizeRepository.save(sizeEntity);				
						}
						else {
							sizeEntity.getListProduct().add(oldProduct);
						}
						oldProduct.getListSize().add(sizeEntity);
					}
					findSize=0;
				}
			}
			// nếu size mới ít hơn size cũ => thực hiện xóa size
			if(product.getListSize().size()<=oldProduct.getListSize().size()) {
				for(int i=0;i<oldProduct.getListSize().size();i++) { 
					for(int j=0;j<product.getListSize().size();j++) {
						// oldProduct.getListSize().get(i).getSizeName().equals(product.getListSize().get(j))
						if(oldProduct.getListSize().get(i).getSizeName().equals(product.getListSize().get(j))) {
							findSize=1;
							break;
						}
						
					}
					// nếu như không tìm thấy => xóa size này( xóa size ra khỏi danh sách size của product và xóa product ra khỏi list product của size
					if(findSize==0) {
						// lấy size đó lên từ cơ sở dữ liệu
						String size=oldProduct.getListSize().get(i).getSizeName();
						SizeEntity sizeEntity=sizeRepository.findBySizeName(size);
						sizeEntity.getListProduct().remove(oldProduct);
						oldProduct.getListSize().remove(sizeEntity);
					}
					findSize=0;
				}
			}
			
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
			productDTO.setCategoryId(list.get(i).getCategory().getCateroryId());
			List<String> listColor=new ArrayList<String>();
			for(int j=0;j<list.get(i).getListColor().size();j++) {
				String color=list.get(i).getListColor().get(j).getColorName();
				listColor.add(color);
			}
			List<String> listSize=new ArrayList<String>();
			for(int j=0;j<list.get(i).getListSize().size();j++) {
				String size=list.get(i).getListSize().get(j).getSizeName();
				listSize.add(size);
			}
			productDTO.setListColor(listColor);
			productDTO.setListSize(listSize);
			List<String> listImage=new ArrayList<String>();
			for(int j=0;j<list.get(i).getListImage().size();j++) {
				String image=list.get(i).getListImage().get(j).getImgae();
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
	@Transactional
	@Override
	public void deleteProductColor(ProductDTO product) {
		// lấy product đó lên từ cơ sở dữ liệu
		ProductEntity productEntity = productRepository.findOneByProductId(product.getProductId());
		for( int i=0;i<product.getListColor().size();i++) {
				ColorEntity color=colorRepository.findBycolorName(product.getListColor().get(i));
				productEntity.getListColor().remove(color);
				color.getListProduct().remove(productEntity);
			
		}
	}
	@Transactional
	@Override
	public List<ProductDTO> findRelatedProduct(int caterogyId) {
		List<Integer> list= productRepository.findRelatedProduct(caterogyId);
		List<ProductDTO> listProductDTO=new  ArrayList<ProductDTO>();
		// chuyển từ entity sang dto
		for( int i=0;i<list.size();i++)
		{
			ProductEntity productEntity=productRepository.findOneByProductId(list.get(i));
			ProductDTO DTO=new ProductDTO();
			DTO.setProductId(productEntity.getProductId());
			DTO.setProductName(productEntity.getName());
			DTO.setCategoryId(productEntity.getCategory().getCateroryId());
			DTO.setCategoryName(productEntity.getCategory().getCategoryName());
			DTO.setImage(productEntity.getImage());
			List<String> listImage=new ArrayList<String>();
			for(int j=0;j<productEntity.getListImage().size();j++) {
				String image=productEntity.getListImage().get(j).getImgae();
				listImage.add(image);
			}
			List<String> listColor=new ArrayList<String>();
			for(int j=0;j<productEntity.getListColor().size();j++) {
				String color=productEntity.getListColor().get(j).getColorName();
				listColor.add(color);
			}
			List<String> listSize=new ArrayList<String>();
			for( int j=0;j<productEntity.getListSize().size();j++) {
				String size=productEntity.getListSize().get(j).getSizeName();
				listSize.add(size);
			}
			DTO.setListColor(listColor);
			DTO.setListSize(listSize);
			DTO.setListImage(listImage);
			DTO.setDescription(productEntity.getDescription());
			DTO.setPrince(productEntity.getPrince());
			DTO.setQuantity(productEntity.getQuantity());
			listProductDTO.add(DTO);
		}
		return listProductDTO;
	}
	@Transactional
	@Override
	public List<ProductDTO> searchByName(String name) {
		List<ProductEntity> list=productRepository.findByName(name);
		System.out.println(" size "+list.size());
		List<ProductDTO> listProductDTO=new ArrayList<ProductDTO>();
		// chuyển đổi list này thanh dto
		for( int i=0;i<list.size();i++) {
			ProductEntity productEntity=list.get(i);
			ProductDTO DTO=new ProductDTO();
			DTO.setProductId(productEntity.getProductId());
			DTO.setProductName(productEntity.getName());
			DTO.setCategoryId(productEntity.getCategory().getCateroryId());
			DTO.setCategoryName(productEntity.getCategory().getCategoryName());
			DTO.setImage(productEntity.getImage());
			List<String> listImage=new ArrayList<String>();
			for(int j=0;j<productEntity.getListImage().size();j++) {
				String image=productEntity.getListImage().get(j).getImgae();
				listImage.add(image);
			}
			List<String> listColor=new ArrayList<String>();
			for(int j=0;j<productEntity.getListColor().size();j++) {
				String color=productEntity.getListColor().get(j).getColorName();
				listColor.add(color);
			}
			List<String> listSize=new ArrayList<String>();
			for( int j=0;j<productEntity.getListSize().size();j++) {
				String size=productEntity.getListSize().get(j).getSizeName();
				listSize.add(size);
			}
			DTO.setListColor(listColor);
			DTO.setListSize(listSize);
			DTO.setListImage(listImage);
			DTO.setDescription(productEntity.getDescription());
			DTO.setPrince(productEntity.getPrince());
			DTO.setQuantity(productEntity.getQuantity());
			listProductDTO.add(DTO);
		}
		return listProductDTO;
	}
	@Transactional
	@Override
	public List<ProductDTO> filter(float price) {
		List<ProductEntity> list=productRepository.filter(price);
		System.out.println(" size "+list.size());
		List<ProductDTO> listProductDTO=new ArrayList<ProductDTO>();
		// chuyển đổi list này thanh dto
		for( int i=0;i<list.size();i++) {
			ProductEntity productEntity=list.get(i);
			ProductDTO DTO=new ProductDTO();
			DTO.setProductId(productEntity.getProductId());
			DTO.setProductName(productEntity.getName());
			DTO.setCategoryId(productEntity.getCategory().getCateroryId());
			DTO.setCategoryName(productEntity.getCategory().getCategoryName());
			DTO.setImage(productEntity.getImage());
			List<String> listImage=new ArrayList<String>();
			for(int j=0;j<productEntity.getListImage().size();j++) {
				String image=productEntity.getListImage().get(j).getImgae();
				listImage.add(image);
			}
			List<String> listColor=new ArrayList<String>();
			for(int j=0;j<productEntity.getListColor().size();j++) {
				String color=productEntity.getListColor().get(j).getColorName();
				listColor.add(color);
			}
			List<String> listSize=new ArrayList<String>();
			for( int j=0;j<productEntity.getListSize().size();j++) {
				String size=productEntity.getListSize().get(j).getSizeName();
				listSize.add(size);
			}
			DTO.setListColor(listColor);
			DTO.setListSize(listSize);
			DTO.setListImage(listImage);
			DTO.setDescription(productEntity.getDescription());
			DTO.setPrince(productEntity.getPrince());
			DTO.setQuantity(productEntity.getQuantity());
			listProductDTO.add(DTO);
		}
		return listProductDTO;
	}
	
	
	

}
