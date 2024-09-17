package springMVC.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="size")
public class SizeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sizeid")
	private int sizeId;
	@Column(name="sizname")
	private String sizeName;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="productSize",
				joinColumns = @JoinColumn(name="sizeId"),
				inverseJoinColumns = @JoinColumn(name="productId"))
	private List<ProductEntity> listProduct=new ArrayList<ProductEntity>();
	public int getSizeId() {
		return sizeId;
	}
	public void setSizeId(int sizeId) {
		this.sizeId = sizeId;
	}
	public String getSizeName() {
		return sizeName;
	}
	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}
	public List<ProductEntity> getListProduct() {
		return listProduct;
	}
	public void setListProduct(List<ProductEntity> listProduct) {
		this.listProduct = listProduct;
	}
	
}
