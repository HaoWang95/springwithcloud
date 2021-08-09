package AlanJava.SpringBootStarter.Task.controller;

import AlanJava.SpringBootStarter.Task.model.Task;
import AlanJava.SpringBootStarter.Task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @GetMapping("")
    public String TaskTest(){
        return "This is the index test for task controller";
    }

    @GetMapping("/")
    public ResponseEntity<List<Task>> findAllTasks(){
        try{
            List<Task> taskList = new ArrayList<Task>(taskRepository.findAll());

            if (taskList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(taskList, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{:id}")
    public ResponseEntity<Task> findTaskById(@PathVariable("id") long id){
        System.out.println(id);
        Optional<Task> task = taskRepository.findById(id);
        return task.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        try{
            Task _task = taskRepository.save(new Task(task.getTitle(),task.getDescription()));
            return new ResponseEntity<>(_task, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
