package com.example.tasker.service;

import com.example.tasker.model.Task;
import com.example.tasker.model.Person;
import com.example.tasker.repository.TaskRepository;
import com.example.tasker.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {

    private final PersonRepository personRepository;
    private final TaskRepository taskRepository;

    public Iterable<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id.intValue()).get();
    }

    public Iterable<Person> getAllUsers() {
        return personRepository.findAll();
    }

    public void createTask(String name, String info, Long author_id, int vacancy) {
        Optional<Person> author = personRepository.personById(author_id);
        if(author.isEmpty())
            throw new IllegalArgumentException("No such user");

        Task t = new Task();
        t.setName(name);
        t.setInformation(info);
        t.setAuthor(author.get());
        t.setFreeWorkplace(vacancy);
        System.out.println(t);
        taskRepository.save(t);
    }

    public void createUser(String name){
        personRepository.addNewPerson(name);
    }
}
