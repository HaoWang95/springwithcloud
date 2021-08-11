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

/**
 * Basic configuration for swagger
 * 1. After running the application, go to swagger-resources to check the metadata of the documentation.
 *    If we can get the name, url, swagger version and location data, it means the swagger is configured successfully.
 * 2. Lots of tutorials claim that swagger path is server:port/context-path/swagger-ui.html, based on my experience of this afternoon
 *    The default is server:port/swagger-ui/index.html
 * 3. Swagger requires quite lots of extra configuration to adjust the content. Also, it requires the documentation of the api endpoint
 *    controllers.
 */

@Configuration
@EnableSwagger2
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
