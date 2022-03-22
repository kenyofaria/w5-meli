package br.com.meli.springdemo.config;

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
public class SpringFoxConfig {

    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                
          .apis(RequestHandlerSelectors.basePackage("br.com.meli.springdemo.controller"))              
          .paths(PathSelectors.any()) 
          .build()
          .apiInfo(metaData());                                           
    }
    
    private ApiInfo metaData() {
        return new ApiInfoBuilder()
            .title("API developed during Wave 5")
            .description("\"Spring Boot REST API for ads management\"")
            .version("1.0.0")
            .license("Meli License")
            .licenseUrl("https://mercadolivre.com.br")
            .build();
      }
	
}
