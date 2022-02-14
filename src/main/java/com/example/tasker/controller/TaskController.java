package com.example.tasker.controller;

import com.example.tasker.service.TaskService;
import com.example.tasker.model.Task;
import com.example.tasker.model.Person;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/tasks")
    public Iterable<Task> GetAllTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping("/task/{id}")
    public Task GetTaskById(@PathVariable Long id){
        return taskService.getTaskById(id);
    }

    @GetMapping("/users")
    public Iterable<Person> GetAllUsers(){
        return taskService.getAllUsers();
    }

    @PostMapping("/task")
    public void CreateTask(@RequestParam(value="name", defaultValue="tasky") String name,
                           @RequestParam(value="info", defaultValue="") String info,
                           @RequestParam(value="author_id", defaultValue="0") Long author_id,
                           @RequestParam(value="vacancy", defaultValue="1") int vacancy){
        taskService.createTask(name, info, author_id, vacancy);

    };

    @PostMapping("/user")
    public void CreateUser(@RequestParam(value="name", defaultValue="usery") String name){
        taskService.createUser(name);
    }


}
