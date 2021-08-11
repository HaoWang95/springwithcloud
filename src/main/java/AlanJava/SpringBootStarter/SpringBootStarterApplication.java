package AlanJava.SpringBootStarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// This is the general entrance of the app
@SpringBootApplication
@EnableSwagger2
public class SpringBootStarterApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(SpringBootStarterApplication.class);
		application.run(args);
	}
}
