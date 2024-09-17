package springMVC.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="Product")
/*
 * @NoArgsConstructor
 * 
 * @AllArgsConstructor
 * 
 * @Getter
 * 
 * @Setter
 */
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int productId;
	@Column(name="name")
	private String name;
	@Column(name="quantity")
	private int quantity;
	@Column(name="prince")
	private float prince;
	@Column(name="status")
	private int status;
	@Column(name="image")
	private String image;
	@Column(name="Description",columnDefinition = "TEXT")
	private  String Description;
	@ManyToOne(fetch = FetchType.EAGER)
	// tạo ra column categoryId bên trong bảng Product
    @JoinColumn(name = "cateroryId")
    private CaterogyEntity category;
	@OneToMany(mappedBy = "product")
	private List<DetailBillEntity> list=new ArrayList<DetailBillEntity>();
	@OneToMany(mappedBy = "product",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
	private List<ImageEntity> listImage=new ArrayList<ImageEntity>();
	@ManyToMany(mappedBy = "listProduct",fetch = FetchType.LAZY)
	private List<SizeEntity> listSize=new ArrayList<SizeEntity>();
	@ManyToMany(mappedBy = "listProduct",fetch = FetchType.LAZY)
	private List<ColorEntity> listColor=new ArrayList<ColorEntity>();
	public int getProductId() {
		return productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CaterogyEntity getCategory() {
		return category;
	}
	public void setCategory(CaterogyEntity category) {
		this.category = category;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	public List<DetailBillEntity> getList() {
		return list;
	}
	public void setList(List<DetailBillEntity> list) {
		this.list = list;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public List<ImageEntity> getListImage() {
		return listImage;
	}
	public void setListImage(List<ImageEntity> listImage) {
		this.listImage = listImage;
	}
	public List<SizeEntity> getListSize() {
		return listSize;
	}
	public void setListSize(List<SizeEntity> listSize) {
		this.listSize = listSize;
	}
	public List<ColorEntity> getListColor() {
		return listColor;
	}
	public void setListColor(List<ColorEntity> listColor) {
		this.listColor = listColor;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	
	
	
}
