package com.desarrollo.Ejercicio.Java.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private ApiInfo apiInfo() {
        return new ApiInfo("App de registro para Nissum", "Desafio tecnico JAVA para Nissum.", "1.0", "Terms of service",
                new Contact("FabianMorenoC", "#", "fabian.morenoc@gmail.com"),
                "License of API", "API license URL", Collections.emptyList());
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.desarrollo.Ejercicio.Java"))
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                //.paths(regex("/good-path/.*"))
                .build();
    }
}