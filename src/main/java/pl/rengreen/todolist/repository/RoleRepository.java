package pl.rengreen.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.rengreen.todolist.domain.Role;

public interface RoleRepository extends JpaRepository<Role, String> {
    Object findByName(String role_user);
}
