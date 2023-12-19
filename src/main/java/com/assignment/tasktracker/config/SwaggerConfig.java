package com.assignment.tasktracker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /*
    This class configures Swagger to scan the com.assignment.tasktracker.controller package for API endpoints.

    Run your application and access Swagger UI:

    Once you run your Spring Boot application, you can access Swagger UI at: http://localhost:8080/swagger-ui.html

    This interactive documentation allows you to explore and test your API endpoints.

    Now, with Swagger integrated in the project, there is a user-friendly way to interact with and document your API
     */

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.assignment.tasktracker.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Task Tracker API")
                .description("API for managing tasks")
                .version("1.0")
                .build();
    }
}
