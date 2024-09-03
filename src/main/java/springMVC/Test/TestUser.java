package springMVC.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import springMVC.entity.UserAndPassEntity;
import springMVC.repository.UseRepository;

public class TestUser {
	@Autowired
	private UseRepository userRepository;
	 @Test
	    public void testFindUserByUsername() {
		 UserAndPassEntity user = userRepository.findOneByUserNameAndStatus("someUsername", 1);
		    assertNotNull(user);
		    assertFalse(user.getRole().isEmpty()); // Kiểm tra danh sách role không rỗng
	    }
}
