package br.com.aj.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("RESTful API with Spring Boot")
                        .version("v1")
                        .description("API REST desenvolvida com Spring Boot")
                        .termsOfService("https://aj.com.br/terms")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://aj.com.br/license")));
    }
}
