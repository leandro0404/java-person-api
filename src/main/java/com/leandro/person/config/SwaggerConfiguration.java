package com.leandro.person.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
class SwaggerConfiguration {

    public static final String BEARER_JWT = "bearer-jwt";

    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(getInfo())
                .externalDocs(getExternalDocumentation())
                .components(getComponents())
                .addSecurityItem(getSecurityRequirement());
    }

    private Info getInfo() {
        return new Info()
                .title("Leandro person-api ")
                .description("API person is a RESTful api responsible for"
                        + " providing the necessary resources for person.")
                .contact(new Contact()
                        .name("Leandro Contact"));
    }

    private ExternalDocumentation getExternalDocumentation() {
        return new ExternalDocumentation()
                .description("Github Repository")
                .url("https://github.com/leandro0404");
    }

    private SecurityRequirement getSecurityRequirement() {
        return new SecurityRequirement().addList(BEARER_JWT, List.of("ADMIN"));
    }

    private Components getComponents() {
        var securityScheme = new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT")
                .in(SecurityScheme.In.HEADER).name("Authorization");

        return new Components()
                .addSecuritySchemes(BEARER_JWT, securityScheme);
    }
}