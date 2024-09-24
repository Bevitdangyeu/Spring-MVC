package springMVC.api.Admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import springMVC.DTO.ProductDTO;
import springMVC.Util.Image;
import springMVC.Util.InterfaceImage;
import springMVC.service.Implement.ProductService;
import springMVC.service.Interface.IProductService;

@RestController
@RequestMapping("/api")
public class ProductAPI {
	 @Autowired
	    private ServletContext servletContext;
	 @Autowired
	 	private IProductService product;
	 @Autowired
	 	private InterfaceImage image;
	@PostMapping("product/add")
	public ProductDTO create(  @RequestParam("jsonData") String jsonData,@RequestParam(value="image",required = false)  MultipartFile fileFromClient,@RequestParam(value="listImage",required = false) MultipartFile[] Listfiles) throws JsonMappingException, JsonProcessingException {
		ProductDTO productDto=new ProductDTO();
		ObjectMapper mapper=new ObjectMapper();
	    productDto=mapper.readValue(jsonData, ProductDTO.class);
	    String applicationPath=servletContext.getRealPath("");
		// Lưu các ảnh phụ
	    if(Listfiles!=null) {
	    	
	    	for(int i=0;i<Listfiles.length;i++) {
	    		String url=image.AddImage(Listfiles[i], applicationPath);
	    		productDto.addImage(url);
	    	}
	    }
	   
//-------------------------------------------------------------------------------------------------
	    if(fileFromClient!=null) {
	    	productDto.setImage(image.AddImage(fileFromClient, applicationPath));
	    }
	 
//-----------------------------------------------------------------------	 
	    ProductDTO pro=product.save(productDto);
		return pro;
	}
	@DeleteMapping("product/delete")
	public void delete(@RequestBody ProductDTO productDelete) {
		product.delete(productDelete.getIds());
	}
	@DeleteMapping("color/delete")
	public void deleteColor(@RequestBody ProductDTO productDelete) {
		System.out.println(" id "+ productDelete.getProductId());
		product.deleteProductColor(productDelete);
	}
}
