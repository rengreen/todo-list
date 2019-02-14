package pl.rengreen.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.rengreen.todolist.domain.User;

public interface UserRepository extends JpaRepository<User, String> {
}
