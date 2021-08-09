package AlanJava.SpringBootStarter.Task.controller;

import AlanJava.SpringBootStarter.Task.model.Task;
import AlanJava.SpringBootStarter.Task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.support.NullValue;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/task/v1")
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @GetMapping("")
    public String TaskTest(){
        return "This is the index test for task controller";
    }
}
