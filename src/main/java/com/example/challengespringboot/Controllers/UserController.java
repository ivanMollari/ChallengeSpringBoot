package com.example.challengespringboot.Controllers;

import com.example.challengespringboot.Models.UserApp;
import com.example.challengespringboot.Services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/auth/login")
    public String loginForm(Model model){
        model.addAttribute("user",new UserApp());
        return "userLogin";
    }

    @GetMapping("/auth/register")
    public String registerForm(Model model){
        model.addAttribute("user",new UserApp());
        return "registerForm";
    }

    @PostMapping("/auth/register")
    public String registerUser(@Validated @ModelAttribute UserApp user, BindingResult result, Model model){
        if(result.hasErrors()){
            return "redirect:/auth/register";
        }else{
            model.addAttribute("user",userService.registerUser(user));
        }
        return "redirect:/auth/login";
    }

}
