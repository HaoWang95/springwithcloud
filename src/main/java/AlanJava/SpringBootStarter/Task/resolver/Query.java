package AlanJava.SpringBootStarter.Task.resolver;

import AlanJava.SpringBootStarter.Task.model.Task;
import AlanJava.SpringBootStarter.Task.repository.TaskRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    private static final Logger logger = LoggerFactory.getLogger(Query.class);
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAllTasks(){
        logger.info(Query.class.getName() +" findAllTasks is called");
        return taskRepository.findAll();
    }

    public long countTasks(){
        logger.info(Query.class.getName() + " countTasks is called");
        return taskRepository.count();
    }
}
