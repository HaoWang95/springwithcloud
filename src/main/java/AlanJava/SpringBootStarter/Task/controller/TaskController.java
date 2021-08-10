package AlanJava.SpringBootStarter.Task.controller;

import AlanJava.SpringBootStarter.Task.component.TaskModelAssembler;
import AlanJava.SpringBootStarter.Task.model.Task;
import AlanJava.SpringBootStarter.Task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/task")
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    TaskModelAssembler assembler;


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

    // This is a path variable, not request param
    @GetMapping("/{id}")
    public ResponseEntity<?> findTaskById(@PathVariable("id") long id){
        Optional<Task> task = taskRepository.findById(id);

        if (task.isPresent()){
            EntityModel<Task> taskModel = assembler.toModel(task.get());
            return ResponseEntity.created(taskModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(taskModel);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//        return task
//                .map(taskInstance -> new ResponseEntity<>(taskInstance, HttpStatus.OK))
//                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    public ResponseEntity<?> createTask(@RequestBody Task task){
        try{
            EntityModel<Task> taskModel = assembler.toModel(
                    taskRepository.save(new Task(task.getTitle(), task.getDescription())));
            return ResponseEntity.created(taskModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(taskModel);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable("id") long id, @RequestBody Task task){
        try{
            Optional<Task> foundTask = taskRepository.findById(id);
            if(foundTask.isPresent()){
                Task _task = foundTask.get();
                _task.setTitle(task.getTitle());
                _task.setDescription(task.getDescription());
                return new ResponseEntity<>(taskRepository.save(_task), HttpStatus.OK);
            }
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTaskById(@PathVariable("id") long id){
        try{
            taskRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/")
    public ResponseEntity<HttpStatus> deleteAllTasks(){
        try{
            taskRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    public ResponseEntity<Task> findTaskByTitle(@PathVariable("title") String title){
        try{
            Optional<Task> task = taskRepository.findByTitle(title);
            return task.map(
                    value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
