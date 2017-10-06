package com.shippingcompany.deliverymanager.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {                                    
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2) 
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.shippingcompany.deliverymanager.resource"))  
          .paths(regex("/api.*"))                     
          .build()
          .apiInfo(metaData());
    }

	private ApiInfo metaData() {
		ApiInfo apiInfo = new ApiInfo("Delivery Manager REST API", "Delivery Manager REST API for shipment enterprise", "1.0",
				"Terms of service",
				new Contact("Vitor Carrilho", "https://www.linkedin.com/in/vitorgcarrilho/", "vitorg.carrilho@gmail.com"),
				"VCarrilho License Version 1.0", "https://www.linkedin.com/in/vitorgcarrilho/");
		return apiInfo;
	}

}