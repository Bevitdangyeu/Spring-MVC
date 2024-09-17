package springMVC.entity;

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

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name="color")
public class ColorEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="colorid")
	private int colorId;
	@Column(name="colorname")
	private String colorName;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="productColor",
				joinColumns = @JoinColumn(name="colorId"),
				inverseJoinColumns = @JoinColumn(name="productId"))
	private List<ProductEntity> listProduct=new ArrayList<ProductEntity>();
	public int getColorId() {
		return colorId;
	}
	public void setColorId(int colorId) {
		this.colorId = colorId;
	}
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	public List<ProductEntity> getListProduct() {
		return listProduct;
	}
	public void setListProduct(List<ProductEntity> listProduct) {
		this.listProduct = listProduct;
	}
	
}
