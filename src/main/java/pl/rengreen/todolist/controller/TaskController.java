package pl.rengreen.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.rengreen.todolist.domain.Task;
import pl.rengreen.todolist.service.TaskService;
import pl.rengreen.todolist.service.UserService;

import javax.validation.Valid;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;

    @GetMapping("/tasks/")
    public String listTasks(Model model) {
        model.addAttribute("tasks", taskService.findAll());
        model.addAttribute("users", userService.findAll());
        return "views/tasksList";
    }

    @GetMapping("task/new")
    public String newTask(Model model){
        model.addAttribute("task", new Task());
        return "views/taskForm";
    }

    @PostMapping("task/new")
    public String addTask(@Valid Task task, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "views/taskForm";
        }
        taskService.saveTask(task);
        return "redirect:/tasks/";
    }
}


