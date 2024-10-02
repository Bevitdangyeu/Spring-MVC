package springMVC.config;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import springMVC.DTO.CustomerDTO;
import springMVC.entity.UserAndPassEntity;
import springMVC.entity.customerEntity;
import springMVC.repository.CustomerResponsitory;
import springMVC.service.CustomUserDetails;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	@Autowired
	private HttpServletRequest request;
	@Autowired CustomerResponsitory customerResponsitory;
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
			
			CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
			CustomerDTO customerDTO=new CustomerDTO();
			UserAndPassEntity userEntity = customUserDetails.getUser();
			customerEntity customer=customerResponsitory.findByUserId(userEntity.getId());
			customerDTO.setCustomerId(customer.getCustomerId());
			customerDTO.setCustomerName(customer.getCustomerName());
			customerDTO.setAddress(customer.getAddress());
			customerDTO.setPhoneNumber(customer.getPhoneNumber());
			customerDTO.setUserId(customer.getUserId().getId());
			HttpSession session=request.getSession();
			session.setAttribute("user",customerDTO );
			response.sendRedirect(request.getContextPath()+"/public/home?page=1&limit=10&sortBy=name");
		}
		
	}

}
