package pl.rengreen.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.rengreen.todolist.domain.Task;
import pl.rengreen.todolist.domain.User;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUser(User user);
    List<Task> findAllByOrderByEndDateAsc();
    List<Task> findTasksByUserOrderByEndDateAsc(User user);
}