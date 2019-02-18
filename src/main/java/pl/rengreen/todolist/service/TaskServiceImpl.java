package pl.rengreen.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.rengreen.todolist.domain.Task;
import pl.rengreen.todolist.repository.TaskRepository;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    private TaskRepository taskRepository;

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
}
