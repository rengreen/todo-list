package pl.rengreen.todolist.service;

import pl.rengreen.todolist.domain.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
}
