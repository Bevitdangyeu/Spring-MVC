package springMVC.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="image")
public class ImageEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="imageid")
	private  int imageId;
	@Column(name="imgae")
	private String imgae;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="productId",nullable = false)
	private ProductEntity product;
	public int getImageId() {
		return imageId;
	}
	public String getImgae() {
		return imgae;
	}
	public void setImgae(String imgae) {
		this.imgae = imgae;
	}
	public ProductEntity getProduct() {
		return product;
	}
	public void setProduct(ProductEntity product) {
		this.product = product;
	}
	
}
