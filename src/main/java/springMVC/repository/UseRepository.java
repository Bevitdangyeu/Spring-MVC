package springMVC.repository;


import org.junit.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import springMVC.entity.UserAndPassEntity;

public interface UseRepository extends JpaRepository<UserAndPassEntity, Integer>{
	UserAndPassEntity findOneByUserNameAndStatus(String username, int status);
	
}
