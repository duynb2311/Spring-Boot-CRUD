package com.duynb.spring.crud.config;

import com.duynb.spring.crud.constant.ConfigConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
// Cấu hình swagger để liệt kê danh sách các api
public class Swagger2Config {
    // Ánh xạ các api từ controller sang swagger ui
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiEndPointsInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(ConfigConstants.SWAGGER_BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build();
    }

    // Cấu hình các trường thông tin mô tả hiển thị trên trang swagger
    private ApiInfo apiEndPointsInfo() {
        return new ApiInfo(
                ConfigConstants.APIINFO_TITLE,
                ConfigConstants.APIINFO_DESCRIPTION,
                ConfigConstants.APIINFO_VERSION,
                ConfigConstants.APIINFO_TERM_OF_SERVICE,
                new Contact(ConfigConstants.APIINFO_CONTACT_NAME, ConfigConstants.APIINFO_CONTACT_URL, ConfigConstants.APIINFO_CONTACT_EMAIL),
                ConfigConstants.APIINFO_LICENSE,
                ConfigConstants.APIINFO_LICENSE_URL,
                Collections.emptyList());
    }
}
