package springMVC.service;
	import org.springframework.security.core.GrantedAuthority;
	import org.springframework.security.core.userdetails.UserDetails;

import springMVC.entity.UserAndPassEntity;

import java.util.Collection;

public class CustomUserDetails implements UserDetails {
private UserAndPassEntity user;
	private Collection<? extends GrantedAuthority> authorities;

	public CustomUserDetails(UserAndPassEntity user, Collection<? extends GrantedAuthority> authorities) {
	   this.user = user;
	   this.authorities = authorities;
	}
	// Trả về UserAndPassEntity để có thể sử dụng trong ứng dụng
	public UserAndPassEntity getUser() {
	    return user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	   return authorities;
	}

	@Override
	public String getPassword() {
	    return user.getPass(); // Trả về mật khẩu của UserAndPassEntity
	}

	@Override
	public String getUsername() {
	    return user.getUserName(); // Trả về tên đăng nhập của UserAndPassEntity
	}

	@Override
	public boolean isAccountNonExpired() {
	    return true; // Hoặc tuỳ theo logic của bạn
	}

	@Override
	public boolean isAccountNonLocked() {
	   return true; // Hoặc tuỳ theo logic của bạn
	}

	@Override
	public boolean isCredentialsNonExpired() {
	    return true; // Hoặc tuỳ theo logic của bạn
	}

	@Override
	public boolean isEnabled() {
	    return user.getStatus() == 1; // Kích hoạt dựa trên trạng thái của UserAndPassEntity
	}
	}

