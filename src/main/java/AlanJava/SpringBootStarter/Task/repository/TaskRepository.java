package AlanJava.SpringBootStarter.Task.repository;

import AlanJava.SpringBootStarter.Task.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findByTitle(String title);

    List<Task> findByCompleted(@Param("completed") Boolean completed);
}
