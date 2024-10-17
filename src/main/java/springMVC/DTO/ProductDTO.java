package springMVC.DTO;

import java.util.ArrayList;
import java.util.List;

public class ProductDTO {
	private int productId;
	private String productName;
	private int categoryId;
	private String categoryName;
	private String description;
	private int quantity;
	private float prince;
	private String image;
	private int sold;
	private int page;
	private int totalItem;// lấy bao nhiêu đối tượng trên 1 trang
	private int totalPage;// tổng số trang
	private int offset;// vị trí lấy( lấy từ vị trí nào) 
	private String sortBy;
//	private String image;
	private List<Integer> ids=new ArrayList<Integer>();
	private List<String> listImage=new ArrayList<String>();
	private List<Integer> ListProduct=new ArrayList<Integer>();
	private List<String> listSize=new ArrayList<String>();
	private List<String> listColor=new ArrayList<String>();
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	} 
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	} 
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	} 
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrince() {
		return prince;
	}
	public void setPrince(float prince) {
		this.prince = prince;
	}
/*	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	} */
	public List<String> getListImage() {
		return listImage;
	} 
	public void setListImage(List<String> listImage) {
		this.listImage = listImage;
	}
	public List<Integer> getListProduct() {
		return ListProduct;
	}
	public void setListProduct(List<Integer> listProduct) {
		ListProduct = listProduct;
	}
	public void addImage(String image) {
		listImage.add(image);
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public List<Integer> getIds() {
		return ids;
	}
	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	public int getTotalItem() {
		return totalItem;
	}
	public void setTotalItem(int totalItem) {
		this.totalItem = totalItem;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	public List<String> getListSize() {
		return listSize;
	}
	public void setListSize(List<String> listSize) {
		this.listSize = listSize;
	}
	public List<String> getListColor() {
		return listColor;
	}
	public void setListColor(List<String> listColor) {
		this.listColor = listColor;
	}
	public int getSold() {
		return sold;
	}
	public void setSold(int sold) {
		this.sold = sold;
	}
	
}
