package springMVC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springMVC.entity.ColorEntity;
@Repository
public interface ColorRespository extends JpaRepository<ColorEntity, Integer>{
	ColorEntity findBycolorName(String colorName);
} 
