package pl.rengreen.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.rengreen.todolist.domain.Task;
import pl.rengreen.todolist.service.TaskService;
import pl.rengreen.todolist.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    private UserService userService;
    private TaskService taskService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setTaskRepository(TaskService taskService) {
        this.taskService = taskService;
    }

   @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "views/usersList";
    }

    @GetMapping("user/assignTasks")
    public  String showAssignTasksForm(String email, Model model, HttpSession session) {

        session.setAttribute("email", email);
        model.addAttribute("user", userService.getUserByEmail(email));
        model.addAttribute("userTasks", taskService.findTasksByUser(userService.getUserByEmail(email)));
        model.addAttribute("freeTasks", taskService.findFreeTasks());

        return "views/assignTasksForm";
    }

    @PostMapping("/user/assignTasks")
    public String assignTasks(List<Task> newTasksList, HttpSession session) {

        String email=(String) session.getAttribute("email");
        if (newTasksList!=null) {
            userService.assignTasksToUser(newTasksList, userService.getUserByEmail(email));
        }
        return "redirect:/users";
    }
}
