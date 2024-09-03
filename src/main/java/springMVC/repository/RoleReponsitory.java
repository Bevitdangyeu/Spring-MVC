package springMVC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springMVC.entity.RoleEntity;

public interface RoleReponsitory extends JpaRepository<RoleEntity, Integer>{
	RoleEntity findOneByRoleId(int roleId);
}
