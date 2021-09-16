package com.airline.adminservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		Info info = new Info().title("AIR LINE").version("1.0.0");
		return new OpenAPI().info(info);
	}

}
