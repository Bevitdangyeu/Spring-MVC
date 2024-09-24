package springMVC.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import springMVC.entity.DetailBillEntity;
import springMVC.entity.ProductEntity;
import springMVC.entity.UserAndPassEntity;
@Repository
public interface ProductRespository extends JpaRepository<ProductEntity, Integer> {
	ProductEntity save(ProductEntity product);
	ProductEntity findOneByProductId (int productId);
	ProductEntity findOneByName(String name);
	@Query(" SELECT d.product.productId "
			+ " FROM DetailBillEntity d WHERE d.product.productId IN (SELECT p.productId FROM ProductEntity p WHERE p.category.cateroryId = :categoryId) "
			+ " GROUP BY  d.product.productId ORDER BY SUM(d.quantity) DESC")
	List<Integer> findRelatedProduct( @Param("categoryId") int categoryId);
}
