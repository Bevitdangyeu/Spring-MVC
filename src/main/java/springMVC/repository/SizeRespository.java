package springMVC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springMVC.entity.SizeEntity;
@Repository
public interface SizeRespository extends JpaRepository<SizeEntity, Integer> {
	SizeEntity findBySizeName(String sizeName);
}
