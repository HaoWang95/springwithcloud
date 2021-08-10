package AlanJava.SpringBootStarter.Task;

import AlanJava.SpringBootStarter.Task.model.Task;
import AlanJava.SpringBootStarter.Task.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This is a configuration class, it will update the database when the app is started
 */

@Configuration
public class LoadTask {
    private static final Logger logger = LoggerFactory.getLogger(LoadTask.class);

    @Bean
    CommandLineRunner initDb(TaskRepository taskRepository){
        return args -> {
            logger.info("Preloading data -> "
                    + taskRepository.save(
                            new Task("Test spring boot",
                                    "Upgrade to spring cloud and build microservices",
                                    false
                            )));
            logger.info("Preloading data -> "+ taskRepository.save(
                    new Task("React and ng application",
                            "Important to use both of the front end tools",
                            false
                    )));
        };
    }
}
