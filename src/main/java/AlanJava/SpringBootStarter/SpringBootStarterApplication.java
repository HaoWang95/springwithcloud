package AlanJava.SpringBootStarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// This is the general entrance of the app
@SpringBootApplication
public class SpringBootStarterApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(SpringBootStarterApplication.class);
		application.run(args);
	}
}
