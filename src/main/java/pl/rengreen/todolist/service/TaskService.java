package pl.rengreen.todolist.service;

import pl.rengreen.todolist.domain.Task;
import java.util.List;

public interface TaskService {

    List<Task> findAll();
    void createTask(Task task);
    void updateTask(Long id, Task updatedTask);
    void deleteTask(Long id);
    Task getTaskById(Long id);
}
