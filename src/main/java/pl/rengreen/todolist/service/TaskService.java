package pl.rengreen.todolist.service;

import pl.rengreen.todolist.domain.Task;
import java.util.List;

public interface TaskService {

    public List<Task> findAll();
}
