package edu.whu.sim.cloudnote.controller;

import edu.whu.sim.cloudnote.dao.User;
import edu.whu.sim.cloudnote.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(){
        return "login-page";
    }

    @RequestMapping("/index")
    public String root() {
        return "index";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login-page";
    }

    @GetMapping("/register")
    public String register() {
        return "register-page";
    }


    @PostMapping("/register")
    public String registerUser(User user, Model model) {
        int num = userService.registerUser(user);
        if(num == -1){
            model.addAttribute("registerError", true);
            model.addAttribute("errorMsg", "用户名已存在！");
            return "register-page";
        }
        return "redirect:/login-page";
    }

    @GetMapping("/logout")
    public String logout(){
        return "login-page";
    }
}
