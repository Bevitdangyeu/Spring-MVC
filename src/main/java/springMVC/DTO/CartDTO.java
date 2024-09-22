package springMVC.DTO;

import java.util.ArrayList;
import java.util.List;

public class CartDTO {
	private List<ProductCartDTO> list=new ArrayList<ProductCartDTO>();

	public List<ProductCartDTO> getList() {
		return list;
	}

	public void setList(List<ProductCartDTO> list) {
		this.list = list;
	}
	public void addProduct(ProductCartDTO product) {
		list.add(product);
	}
}
