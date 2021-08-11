package AlanJava.SpringBootStarter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.function.Predicate;


@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig {
    @Bean
    public Docket postsApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("AlanJava.SpringBootStarter.Task.controller"))
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("Swagger documentation test")
                .description("Swagger api test for sample apis")
                .termsOfServiceUrl("License and terms description")
                .license("Open")
                .license("")
                .version("1.0")
                .build();
    }
}
