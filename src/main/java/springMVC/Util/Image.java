package springMVC.Util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component
public class Image implements InterfaceImage {
	 @Autowired
	 private  ServletContext servletContext;
	 
	public Image() {
	}
/*
	@Override
	public List<String> addListImage(MultipartFile[] Listfiles, String applicationPath) {
			List<String> images=new ArrayList<String>();
			for(int i=0;i<Listfiles.length;i++) {
				String fileName=Listfiles[i].getOriginalFilename();
				// lấy toàn bộ đường dẫn của ứng dụng
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
			images.add(fileUrl);
			
			}
			return images;
		}
*/
	@Override
	public String AddImage(MultipartFile file, String applicationPath) {
		String fileName=file.getOriginalFilename();
		// tạo đường dẫn đến nơi lưu trữ tệp trên server , File.separatorlà dấu phân cách ,UPLOAD_DIR tên thư mục mình muốn upload
    	String uploadFilePath = applicationPath + "uploads";
    	System.out.println(" uploadFilePath: "+uploadFilePath);
    	// tạo thư mục lưu trữ tệp 
    	File uploadDir = new File(uploadFilePath);
    	  // nếu thư mục chưa tồn tại thì phải tạo thư mục 
     if (!uploadDir.exists()) {
         uploadDir.mkdirs();
     }
     File newFile=new File(uploadFilePath + File.separator + fileName);
     // mở file có tên được gán cho biến newFile để ghi dữ liệu vào 
     try (FileOutputStream fos = new FileOutputStream(newFile);
         	//Đọc dữ liệu nhị phân từ body của part đưa vào biến fileContent
               InputStream fileContent = file.getInputStream()) {
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
		return fileUrl;
	}
		
}

	
	

