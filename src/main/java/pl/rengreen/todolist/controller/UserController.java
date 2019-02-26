package pl.rengreen.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.rengreen.todolist.domain.Task;
import pl.rengreen.todolist.service.TaskService;
import pl.rengreen.todolist.service.UserService;

import javax.servlet.http.HttpSession;

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

    @GetMapping("user/assignTasks/{email}")
    public  String showAssignTaskForm(@PathVariable String email, Model model) {

        model.addAttribute("user", userService.getUserByEmail(email));
        model.addAttribute("userTasks", taskService.findTasksByUser(userService.getUserByEmail(email)));
        model.addAttribute("freeTasks", taskService.findFreeTasks());

        return "views/assignTasksForm";
    }

    @GetMapping("/assign/{email}/{id}")
    public String assignTask(@PathVariable String email, @PathVariable Long id, Model model) {
        Task selectedTask=taskService.getTaskById(id);
        taskService.assignUserToTask(selectedTask, userService.getUserByEmail(email));

        return "redirect:/user/assignTasks/"+email;
    }
}
