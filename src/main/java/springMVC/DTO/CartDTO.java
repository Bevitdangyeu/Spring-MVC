package springMVC.DTO;

import java.util.List;

public class CartDTO {
	private List<ProductCartDTO> list;

	public List<ProductCartDTO> getList() {
		return list;
	}

	public void setList(List<ProductCartDTO> list) {
		this.list = list;
	}
	
}
