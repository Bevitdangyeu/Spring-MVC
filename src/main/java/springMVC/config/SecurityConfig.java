/*
 * package springMVC.config;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.web.SecurityFilterChain;
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class SecurityConfig {
 * 
 * @Bean public SecurityFilterChain securityFilterChain(HttpSecurity http)
 * throws Exception { http .authorizeRequests()
 * 
 * Cho phép tất cả người dùng (bao gồm cả những người chưa đăng nhập) truy cập
 * vào các URL bắt đầu bằng /public/.
 * 
 * .antMatchers("/public/**").permitAll()
 * 
 * Chỉ cho phép những người dùng có role ADMIN truy cập vào các URL bắt đầu bằng
 * /admin/
 * 
 * .antMatchers("/admin/**").hasRole("ADMIN")
 * 
 * Cho phép những người dùng có role USER hoặc ADMIN truy cập vào các URL bắt
 * đầu bằng /user/.
 * 
 * .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
 * 
 * Yêu cầu tất cả các request khác phải được xác thực (người dùng phải đăng nhập
 * mới có thể truy cập).
 * 
 * .anyRequest().authenticated() .and() .formLogin()
 * 
 * Định nghĩa URL /login là trang đăng nhập tùy chỉnh mà người dùng sẽ được
 * chuyển đến nếu chưa đăng nhập. java
 * 
 * .loginPage("/login")
 * 
 * Sau khi đăng nhập thành công, người dùng sẽ được chuyển hướng tới URL /home.
 * Tham số true đảm bảo rằng người dùng luôn được chuyển đến URL này, ngay cả
 * khi họ truy cập một URL khác trước khi đăng nhập.
 * 
 * .defaultSuccessUrl("/home", true)
 * 
 * Cho phép tất cả người dùng truy cập vào trang đăng nhập này (không yêu cầu
 * xác thực để truy cập trang đăng nhập).
 * 
 * .permitAll() .and() .logout() .logoutUrl("/logout")
 * .logoutSuccessUrl("/login?logout") .permitAll() .and() .csrf().disable();
 * return http.build(); } }
 */
package springMVC.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import springMVC.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService(); // Thay thế với lớp UserDetailsService thực sự của bạn
    }

	
	@Bean 
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); // Đảm bảo bạn đã định nghĩa PasswordEncoder }
	}
	 
	@Bean
	public AuthenticationSuccessHandler customAuthenticationSuccessHandler() {
		return new CustomAuthenticationSuccessHandler();
	}
	@Bean
	public AccessDeniedHandler customAccessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/public/**").permitAll()
				.antMatchers("/admin2/**").access("hasAuthority('READ') and hasAuthority('CREATE') and hasAuthority('UPDATE') and hasAuthority('DELETE')")
				.antMatchers("/admin1/**").access("hasAuthority('READ') and hasAuthority('CREATE') and hasAuthority('UPDATE')")
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/j_spring_security_check") // URL xử lý đăng nhập
                .successHandler(customAuthenticationSuccessHandler()) // sau khi thành công sẽ chuyển đến url được chỉ định tùy theo role
                .failureUrl("/public/home")
                .usernameParameter("username")  // Tên tham số username trong form
                .passwordParameter("password")  // Tên tham số password trong form
                .permitAll()
                .and()
            .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .permitAll()
                .and()
            .csrf().disable()
            .exceptionHandling()
            .accessDeniedHandler(customAccessDeniedHandler());

        return http.build();
    }
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                   .userDetailsService(userDetailsService())
                   .passwordEncoder(passwordEncoder())
                   .and()
                   .build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/template/**","/uploads/**"); // Bỏ qua các yêu cầu đến các tài nguyên tĩnh
    }
}