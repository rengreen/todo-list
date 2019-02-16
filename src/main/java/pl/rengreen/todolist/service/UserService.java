package pl.rengreen.todolist.service;

import pl.rengreen.todolist.domain.User;
import java.util.List;

public interface UserService {
    void createUser(User user);
    void createAdmin(User user);
    List<User> findAll();
    User getUserByEmail(String email);
    boolean isUserPresent(String email);
}
