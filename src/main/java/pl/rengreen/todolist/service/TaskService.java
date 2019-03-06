package pl.rengreen.todolist.service;

import pl.rengreen.todolist.domain.Task;
import pl.rengreen.todolist.domain.User;

import java.util.List;

public interface TaskService {

    List<Task> findAll();
    void createTask(Task task);
    void updateTask(Long id, Task updatedTask);
    void deleteTask(Long id);
    Task getTaskById(Long id);

    void setTaskCompleted(Long id);
    void setTaskNotCompleted(Long id);

    List<Task> findTasksByUser(User user);
    void assignUserToTask(Task task, User user);
    List<Task>  findFreeTasks();

    List<Task> findAllByOrderByEndDateDesc();
}
