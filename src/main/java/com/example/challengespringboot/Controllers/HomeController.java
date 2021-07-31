package com.example.challengespringboot.Controllers;

import com.example.challengespringboot.Models.UserApp;
import com.example.challengespringboot.Services.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/app")
public class HomeController {

    private final UserServiceImpl userService;

    @Autowired
    public HomeController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/index")
    public String index(Authentication auth, HttpSession session){

        String username = auth.getName();

        if(session.getAttribute("user") == null){
            UserApp user = userService.findUserByName(username);
            user.setPassword(null);
            session.setAttribute("user",user);
        }

        return "index";
    }

}
