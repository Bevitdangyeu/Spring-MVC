package springMVC.service.Implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springMVC.DTO.CategoryDTO;
import springMVC.entity.CaterogyEntity;
import springMVC.repository.CategoryResponsitory;
import springMVC.service.Interface.ICategoryService;

@Service
public class CategoryService implements ICategoryService {
	@Autowired
	CategoryResponsitory category;
	
	@Override
	public List<CategoryDTO> findAll() {
		List<CategoryDTO> models=new ArrayList<CategoryDTO>();
		List<CaterogyEntity> list=category.findAll();
		for(CaterogyEntity catelogy: list) {
			CategoryDTO model=new CategoryDTO();
			model.setCategoryId(catelogy.getCateroryId());
			model.setCategoryName(catelogy.getCategoryName());
			models.add(model);
		}
		return models;
	}


	
}
