package pl.rengreen.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StaticPageController {

    @RequestMapping("/about")
    String about(){
        return "views/about";
    }
}