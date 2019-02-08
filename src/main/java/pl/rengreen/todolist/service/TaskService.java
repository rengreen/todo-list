package pl.rengreen.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import pl.rengreen.todolist.domain.Task;
import pl.rengreen.todolist.repository.TaskRepository;

import java.util.List;

public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAll() {
        return taskRepository.findAll();
    }
}
