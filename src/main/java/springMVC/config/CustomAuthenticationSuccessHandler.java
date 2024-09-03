package springMVC.config;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
			// lấy toàn bộ role trong  List<GrantedAuthority>
		List<GrantedAuthority> authorities =(List<GrantedAuthority>) authentication.getAuthorities();
		if( authorities.contains(new SimpleGrantedAuthority("CREATE"))&& authorities.contains(new SimpleGrantedAuthority("UPDATE"))
				&& authorities.contains(new SimpleGrantedAuthority("DELETE"))) {
			response.sendRedirect(request.getContextPath()+"/admin2/home");
		}
		else if(authorities.contains(new SimpleGrantedAuthority("CREATE"))&& authorities.contains(new SimpleGrantedAuthority("UPDATE"))){
			response.sendRedirect(request.getContextPath()+"/admin1/home");
		}
		else {
			response.sendRedirect(request.getContextPath()+"/user/home");
		}
		
	}

}
