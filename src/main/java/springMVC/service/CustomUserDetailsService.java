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
		   UserAndPassEntity user = userRepository.findOneByUserNameAndStatus(username,1);
		   List<RoleEntity> roless = user.getRole();
		   List<GrantedAuthority> grantedAuthority=new ArrayList<GrantedAuthority>(); 
		   for(RoleEntity role: user.getRole()) {
			  for(PermissionEntity permission: role.getPermissions()) {
				  System.out.println(" permission code: "+ permission.getPermissionCode());
				  grantedAuthority.add(new SimpleGrantedAuthority(permission.getPermissionCode()));
			  }
		   }
		   return new org.springframework.security.core.userdetails.User(
		            user.getUserName(),
		            user.getPass(),
		            grantedAuthority
		        );
	}
	
}
