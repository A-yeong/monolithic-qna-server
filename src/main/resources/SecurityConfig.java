import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 특정 경로에 대해 CORS 허용 설정
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:8077")  // 프론트엔드 주소
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // 허용할 HTTP 메서드
                .allowedHeaders("*")  // 모든 헤더 허용
                .allowCredentials(true);  // 쿠키 등의 자격 증명 허용
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors()  // CORS 설정 활성화
                .and()
                .csrf().disable()  // CSRF 비활성화 (필요하지 않으면 비활성화)
                .authorizeRequests()
                .antMatchers("/api/**").permitAll() // API 경로에 대한 접근 허용
                .anyRequest().authenticated(); // 다른 모든 요청은 인증 필요

        return http.build();
    }
}