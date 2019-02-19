package pl.rengreen.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.rengreen.todolist.service.TaskService;
import pl.rengreen.todolist.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;

   @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("users", userService.findAll());
        return "views/usersList";
    }
}