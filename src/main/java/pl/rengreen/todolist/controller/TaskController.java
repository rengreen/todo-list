package pl.rengreen.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.rengreen.todolist.service.TaskService;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping("/tasks/")
    public String listUsers(Model model) {
        model.addAttribute("tasks", taskService.findAll());
        return "views/tasksList";
    }
}


