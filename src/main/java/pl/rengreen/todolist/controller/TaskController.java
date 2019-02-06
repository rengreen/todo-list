package pl.rengreen.todolist.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    @RequestMapping("/")
    String text(){
        return "text";
    }
}
