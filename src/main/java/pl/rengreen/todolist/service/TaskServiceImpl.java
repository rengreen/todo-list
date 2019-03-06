package pl.rengreen.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.rengreen.todolist.domain.Task;
import pl.rengreen.todolist.domain.User;
import pl.rengreen.todolist.repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{
    private TaskRepository taskRepository;

    @Autowired
    public void setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public void createTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void updateTask(Long id, Task updatedTask){
            Task task = taskRepository.getOne(id);

            task.setName(updatedTask.getName());
            task.setDescription(updatedTask.getDescription());
            task.setStartDate(updatedTask.getStartDate());
            task.setEndDate(updatedTask.getEndDate());

            taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public void setTaskCompleted(Long id) {
        Task task = taskRepository.getOne(id);
        task.setCompleted(true);
        taskRepository.save(task);
    }

    @Override
    public void setTaskNotCompleted(Long id) {
        Task task = taskRepository.getOne(id);
        task.setCompleted(false);
        taskRepository.save(task);
    }

    @Override
    public List<Task> findTasksByUser(User user) {
        return taskRepository.findByUser(user);
    }

    @Override
    public void assignUserToTask(Task task, User user) {
        task.setUser(user);
        taskRepository.save(task);
    }

    @Override
    public List<Task> findFreeTasks() {
        List<Task> allTasks=taskRepository.findAll();
        List<Task> freeTasks=new ArrayList<>();
        for(Task item: allTasks) {
            if(item.getUser()==null) {
                freeTasks.add(item);
            }
        }
        return freeTasks;
    }

    @Override
    public List<Task> findAllByOrderByEndDateDesc() {
        return taskRepository.findAllByOrderByEndDateDesc();
    }

    @Override
    public List<Task> findTasksByUserOrderByEndDateDesc(User user) {
        return taskRepository.findTasksByUserOrderByEndDateDesc(user);
    }
}
