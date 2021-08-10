package AlanJava.SpringBootStarter.Task.component;


import AlanJava.SpringBootStarter.Task.controller.TaskController;
import AlanJava.SpringBootStarter.Task.model.Task;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class TaskModelAssembler implements RepresentationModelAssembler<Task, EntityModel<Task>> {

    @Override
    public EntityModel<Task> toModel(Task task) {
        return EntityModel.of(task,
                linkTo(methodOn(TaskController.class).findTaskById(task.getId())).withSelfRel());
    }

    @Override
    public CollectionModel<EntityModel<Task>> toCollectionModel(Iterable<? extends Task> entities) {
        List<EntityModel<Task>> tasks = new ArrayList<EntityModel<Task>>();
        entities.forEach(task -> {
            tasks.add(toModel(task));
        });
        return CollectionModel.of(
                tasks,
                linkTo(methodOn(TaskController.class).findAllTasks()).withSelfRel());
    }
}
