package springMVC.api.Admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

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
import springMVC.service.Implement.ProductService;
import springMVC.service.Interface.IProductService;

@RestController
@RequestMapping("/public")
public class ProductAPI {
	 @Autowired
	    private ServletContext servletContext;
	 @Autowired
	 	private IProductService product;
	@PostMapping("/add")
	public ProductDTO create(  @RequestParam("jsonData") String jsonData,@RequestParam(value="image",required = false)  MultipartFile fileFromClient,@RequestParam(value="listImage",required = false) MultipartFile[] Listfiles) throws JsonMappingException, JsonProcessingException {
		System.out.println(" vao duoc ham them ");
		ProductDTO productDto=new ProductDTO();
		ObjectMapper mapper=new ObjectMapper();
	    productDto=mapper.readValue(jsonData, ProductDTO.class);
		// Lưu các ảnh phụ
	    if(Listfiles!=null) {
	    	 for( int i=0;i<Listfiles.length;i++) {
	 	    	String fileName=Listfiles[i].getOriginalFilename();
	 	    	System.out.println(" fileName: "+fileName);
	 	    	// lấy toàn bộ đường dẫn của ứng dụng
	 	    	String applicationPath=servletContext.getRealPath("");
	 	    	System.out.println(" realPath: "+applicationPath);
	 	    	// tạo đường dẫn đến nơi lưu trữ tệp trên server , File.separatorlà dấu phân cách ,UPLOAD_DIR tên thư mục mình muốn upload
	 	    	String uploadFilePath = applicationPath + "uploads";
	 	    	System.out.println(" uploadFilePath: "+uploadFilePath);
	 	    	// tạo thư mục lưu trữ tệp 
	 	    	File uploadDir = new File(uploadFilePath);
	 	    	  // nếu thư mục chưa tồn tại thì phải tạo thư mục 
	             if (!uploadDir.exists()) {
	                 uploadDir.mkdirs();
	             }
	             File file=new File(uploadFilePath + File.separator + fileName);
	             try (FileOutputStream fos = new FileOutputStream(file);
	                 	//Đọc dữ liệu nhị phân từ body của part đưa vào biến fileContent
	                       InputStream fileContent = Listfiles[i].getInputStream()) {
	 					  byte[] buffer = new byte[1024]; 
	 					  int bytesRead;
	 					  while ((bytesRead =fileContent.read(buffer)) != -1) 
	 					  { 
	 						  fos.write(buffer, 0, bytesRead); 
	 					  }
	 					 

	                 } catch (IOException e) {
	                     e.printStackTrace();
	                    
	                     return null;
	                 }
	             String fileUrl = servletContext.getContextPath() + "/" + "uploads" + "/" + fileName;
	             productDto.addImage(fileUrl);    
	             System.out.println(" Listimage 1: "+productDto.getListImage().get(i));
	 	    }
	    }
	   
//-------------------------------------------------------------------------------------------------
	    if(fileFromClient!=null) {
	    	  // lưu ảnh chính
		    String fileName=fileFromClient.getOriginalFilename();
		    // lấy toàn bộ đường dẫn của ứng dụng
		    String applicationPath=servletContext.getRealPath("");
			// tạo đường dẫn đến nơi lưu trữ tệp trên server , File.separatorlà dấu phân cách ,UPLOAD_DIR tên thư mục mình muốn upload
	    	String uploadFilePath = applicationPath + "uploads";
	    	System.out.println(" uploadFilePath: "+uploadFilePath);
	    	// tạo thư mục lưu trữ tệp 
	    	File uploadDir = new File(uploadFilePath);
	    	  // nếu thư mục chưa tồn tại thì phải tạo thư mục 
	        if (!uploadDir.exists()) {
	            uploadDir.mkdirs();
	        }
	        File file=new File(uploadFilePath + File.separator + fileName);
	        try (FileOutputStream fos = new FileOutputStream(file);
	            	//Đọc dữ liệu nhị phân từ body của part đưa vào biến fileContent
	                  InputStream fileContent = fileFromClient.getInputStream()) {
					  byte[] buffer = new byte[1024]; 
					  int bytesRead;
					  while ((bytesRead =fileContent.read(buffer)) != -1) 
					  { 
						  fos.write(buffer, 0, bytesRead); 
					  }
					 

	            } catch (IOException e) {
	                e.printStackTrace();
	               
	                return null;
	            }
	        String fileUrl = servletContext.getContextPath() + "/" + "uploads" + "/" + fileName;
		    productDto.setImage(fileUrl);
		    System.out.println(" imageee: "+productDto.getImage());
	    }
	  
//-----------------------------------------------------------------------	 
	    ProductDTO pro=product.save(productDto);
		return null;
	}
	@DeleteMapping("/delete")
	public void delete(@RequestBody ProductDTO productDelete) {
		product.delete(productDelete.getIds());
	}
}
