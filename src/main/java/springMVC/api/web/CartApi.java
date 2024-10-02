package springMVC.api.web;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springMVC.DTO.CartDTO;
import springMVC.DTO.ProductCartDTO;
import springMVC.DTO.ProductDTO;
import springMVC.service.Interface.IProductService;

import java.util.Iterator;
import java.util.List;
@RestController
@RequestMapping("/api/cart")
public class CartApi {
	@Autowired
	IProductService productService;
	@Autowired
    private HttpServletRequest request;

	@RequestMapping(value="/add",method = RequestMethod.POST)
	public void add(@RequestBody ProductCartDTO product) {
		System.out.println("vo duoc ham");
		CartDTO cart=new CartDTO();
		// tìm thông tin của sản phẩm đó thông qua ProductCartDTO được gửi từ client
		ProductDTO productDto=productService.findOne(product.getProductId());
		product.setProduct(productDto);
		// lấy session
		HttpSession session=request.getSession();
		// chưa có giỏ hàng thì thêm mới giỏ hàng
		if(session.getAttribute("cart")==null) {
			System.out.println("tao gio hang");
			cart.addProduct(product);
			session.setAttribute("cart", cart);
		}
		// trường hợp đã có giỏ hàng rồi
		else {
			// lấy lại toàn bộ giỏ hàng
			cart=(CartDTO) session.getAttribute("cart");
			// lấy ra danh sách các sản phẩm
			List<ProductCartDTO> listProduct= cart.getList();
			int check=0;
			// lặp qua từng sản phẩm
			for(int i=0;i<listProduct.size();i++) {
				if(product.getProductId()==listProduct.get(i).getProductId() 
						&& product.getColor().equals(listProduct.get(i).getColor()) 
						&& product.getSize().equals(listProduct.get(i).getSize())
						) 
				{
					// cộng số lượng lên 
					System.out.println("cong so luong");
					listProduct.get(i).setSoLuong(listProduct.get(i).getSoLuong()+product.getSoLuong());
					check=1;
					break;
				}
			}
			if(check==0) {
				// sp chưa tồn tại trong giỏ hàng=> thêm mới
				System.out.println("them moi");
				listProduct.add(product);
				cart.setList(listProduct);
			}
			// cập nhật lại toàn bộ giỏ hàng
			session.setAttribute("cart", cart);
		}
	}
	@RequestMapping(value = "/remove",method = RequestMethod.DELETE)
	public int remove(@RequestBody ProductCartDTO product) {
		CartDTO cart=new CartDTO();
		HttpSession session=request.getSession();
		cart=(CartDTO) session.getAttribute("cart");
		
		List<ProductCartDTO> listProductCart=cart.getList();
		
		// lặp quanh danh sách tìm sản phẩm trùng khớp để xóa
		for(int i=0;i<listProductCart.size();i++) {
			if(product.getProductId()==listProductCart.get(i).getProductId() 
						&& product.getColor().equals(listProductCart.get(i).getColor()) 
						&& product.getSize().equals(listProductCart.get(i).getSize())
						) 
			{
				listProductCart.remove(i);
				return 1;
			}
			
		}
		// cập nhật lại cart
		cart.setList(listProductCart);
		request.setAttribute("cart", cart);
		return 0;
	}
}
