package springMVC.Util;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface InterfaceImage {
	//public  List<String> addListImage(MultipartFile[] Listfiles,String applicationPath );
	public String AddImage(MultipartFile file,String applicationPath);
	
}
