package AlanJava.SpringBootStarter.Task.repository;

import AlanJava.SpringBootStarter.Task.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
