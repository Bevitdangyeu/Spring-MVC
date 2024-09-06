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
//	private String image;
	private List<Integer> ids=new ArrayList<Integer>();
	private List<String> listImage=new ArrayList<String>();
	private List<Integer> ListProduct=new ArrayList<Integer>();
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
	
}
