package com.pracownia.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    String home(ModelMap modal) {
        modal.addAttribute("title","Wypożyczalnia");
        return "index.html";
    }
}
