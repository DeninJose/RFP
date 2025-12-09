package com.projects.rfp.backend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("RFP Procurement API")
                        .version("1.0.0")
                        .description("API for automating procurement requests for companies. " +
                                "This API accepts text requirements and converts them to structured procurement data."));
    }
}

