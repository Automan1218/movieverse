package sg.edu.nus.movieverse.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import sg.edu.nus.movieverse.filter.SessionTimeoutFilter;

public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173")  // Add allowed IP or domain
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Allows these HTTP methods
                .allowedHeaders("*")  // Allows all headers
                .allowCredentials(true);  // Allows credentials (optional, depending on your need)
    }

    @Bean
    public FilterRegistrationBean<SessionTimeoutFilter> sessionTimeoutFilter() {
        FilterRegistrationBean<SessionTimeoutFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new SessionTimeoutFilter());
        registrationBean.addUrlPatterns("/*");  // Apply filter to all URLs
        return registrationBean;
    }
}
