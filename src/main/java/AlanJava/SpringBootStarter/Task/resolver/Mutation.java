package AlanJava.SpringBootStarter.Task.resolver;

import AlanJava.SpringBootStarter.Task.model.Task;
import AlanJava.SpringBootStarter.Task.repository.TaskRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;

public class Mutation implements GraphQLMutationResolver {
    @Autowired
    private TaskRepository taskRepository;


    public Task createTask(String title, String description){
        return taskRepository.save(new Task(title, description, false));
    }
}
