package springMVC.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Đăng ký một endpoint cho WebSocket, sử dụng SockJS nếu client không hỗ trợ WebSocket
    	registry.addEndpoint("/chat").withSockJS(); 
    	  System.out.println("WebSocket endpoint registered: /chat");
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // Kích hoạt một message broker đơn giản để lắng nghe các tin nhắn gửi đến các đích với prefix là "/queue"
        config.enableSimpleBroker("/queue");
        
        // Các tin nhắn từ client sẽ phải có prefix là "/app"
        config.setApplicationDestinationPrefixes("/app");
    }
}