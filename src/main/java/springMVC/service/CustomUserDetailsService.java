package springMVC.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import springMVC.DTO.MyUser;
import springMVC.entity.PermissionEntity;
import springMVC.entity.RoleEntity;
import springMVC.entity.UserAndPassEntity;
import springMVC.repository.RoleReponsitory;
import springMVC.repository.UseRepository;
@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UseRepository userRepository;
	@Autowired
	private RoleReponsitory roleRe;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserAndPassEntity user = userRepository.findOneByUserNameAndStatus(username, 1);
		
	    if (user == null) {
	        throw new UsernameNotFoundException("User not found");
	    }
	    List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
	    if(user.getRoles().size()>0) {
	    	for (RoleEntity role : user.getRole()) {
		        for (PermissionEntity permission : role.getPermissions()) {
		            grantedAuthorities.add(new SimpleGrantedAuthority(permission.getPermissionCode()));
		        }
		    }
	    }
	    // Trả về đối tượng CustomUserDetails thay vì User của Spring Security
	    return new CustomUserDetails(user, grantedAuthorities);
	}
	
}
