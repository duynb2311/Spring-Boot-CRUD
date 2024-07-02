package com.duynb.spring.crud.config;

import com.duynb.spring.crud.constant.ConfigConstants;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // Cho phép tất cả các domain
                .allowedMethods(ConfigConstants.HTTP_METHOD_GET, ConfigConstants.HTTP_METHOD_POST, ConfigConstants.HTTP_METHOD_PUT, ConfigConstants.HTTP_METHOD_DELETE) // Cho phép các phương thức này
                .allowCredentials(true) // Cho phép chia sẻ cookie (nếu có)
                .maxAge(ConfigConstants.CORS_MAPPING_MAX_AGE); // Thời gian cache của Preflight request
    }
}
