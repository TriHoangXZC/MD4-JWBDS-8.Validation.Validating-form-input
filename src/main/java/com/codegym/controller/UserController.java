package com.codegym.controller;

import com.codegym.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @GetMapping("/users/form")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("/user/form");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/users/result")
    public ModelAndView showResult(@Validated @ModelAttribute ("user") User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ModelAndView("/user/form");
        }
        return new ModelAndView("/user/result");
    }
}

