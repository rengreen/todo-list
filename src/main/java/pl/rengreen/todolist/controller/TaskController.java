package pl.rengreen.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.rengreen.todolist.domain.Task;
import pl.rengreen.todolist.service.TaskService;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks/")
    public String listTasks(Model model) {
        model.addAttribute("tasks", taskService.findAll());
        return "views/tasksList";
    }

    @GetMapping("task/new")
    public String newTask(Model model){
        model.addAttribute("task", new Task());
        return "taskForm";
    }

    @PostMapping("task")
    public String saveTask(Task task){
        taskService.saveTask(task);
        return "redirect:/tasks/";
    }
}


