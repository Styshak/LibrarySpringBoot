package com.styshak.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String helloWorld(Model model) {
        model.addAttribute("name", "Serega");
        return "login";
    }
}
