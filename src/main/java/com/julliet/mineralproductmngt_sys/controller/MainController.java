package com.julliet.mineralproductmngt_sys.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/dashboard")
    @PreAuthorize("isAuthenticated()")
    public String dashboard() {
        // Controller logic
        return "userhome";
    }

    @GetMapping("/admin")
    @PreAuthorize("isAuthenticated()")
    public String admin() {
        // Controller logic
        return "admin";
    }
}
