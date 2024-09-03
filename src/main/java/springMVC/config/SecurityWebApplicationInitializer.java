package springMVC.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
    // Không cần phải override bất kỳ phương thức nào.
    // Lớp này sẽ tự động đăng ký các bộ lọc bảo mật của Spring Security.
}
