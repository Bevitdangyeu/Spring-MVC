package springMVC.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springMVC.entity.CaterogyEntity;
@Repository
public interface CategoryResponsitory extends JpaRepository<CaterogyEntity, Integer>{
	List<CaterogyEntity> findAll();
	CaterogyEntity findByCateroryId(int cateroryId);
	CaterogyEntity findByCategoryName(String categoryName);
}				   
