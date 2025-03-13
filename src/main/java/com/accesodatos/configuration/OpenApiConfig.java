package com.accesodatos.configuration;

import org.springframework.http.HttpHeaders;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
		info = @Info(
				title = "WRITER SERVICE",
				description = "Our app provides a consice listing of writers names",
				termsOfService = "www.accesodatos/terminos_y_condiciones",
				version = "1.0.0",
				contact = @Contact(
						name = "Alonso",
						url = "https://salesianos-lacuesta.com",
						email = "alonso@gmail.com"
				),
				license = @License(
						name = "Standart Software Use License For Acceso A Datos",
						url = "https://salesianos-lacuesta.com"
				)
		),
		servers = {
				@Server(
						description = "Server URL in Development environment",
						url = "http://localhost:8081"
				),
				@Server(
						description = "Server URL in Production environment",
						url = "http://localhost:8081"
						),
		},
		security = @SecurityRequirement(
				name = "Security Basic"
		)
)
@SecurityScheme(
		name = "Security Basic",
		description = "User/password for writers Service",
		type = SecuritySchemeType.HTTP,
		paramName = HttpHeaders.AUTHORIZATION,
		in = SecuritySchemeIn.HEADER,
		scheme = "basic"
)
public class OpenApiConfig {
	
}
