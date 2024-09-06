package springMVC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springMVC.entity.ProductEntity;
import springMVC.entity.UserAndPassEntity;
@Repository
public interface ProductRespository extends JpaRepository<ProductEntity, Integer> {
	ProductEntity save(ProductEntity product);
	ProductEntity findOneByProductId (int productId);
}
