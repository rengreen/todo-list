package pl.rengreen.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.rengreen.todolist.domain.User;
import pl.rengreen.todolist.service.TaskService;
import pl.rengreen.todolist.service.UserService;

import java.security.Principal;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;

    @GetMapping("/profile")
    public String showProfilePage(Model model, Principal principal){

        String email=principal.getName();
        User user = userService.getUserByEmail(email);
        model.addAttribute("tasks", taskService.findTasksByUser(user));

        return "views/profile";
    }
}
