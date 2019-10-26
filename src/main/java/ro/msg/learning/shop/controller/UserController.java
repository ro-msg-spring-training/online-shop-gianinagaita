package ro.msg.learning.shop.controller;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ro.msg.learning.shop.services.MyUserDetailService;

@RestController
public class UserController {
    private final MyUserDetailService userDetailsService;

    public UserController(MyUserDetailService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @RequestMapping("/")
    @ResponseBody
    public UserDetails getUserNameAndPassword() {
        return userDetailsService.loadUserByUsername("gianinagaita");
    }

    @RequestMapping("/login.html")
    public UserDetails login() {
        return userDetailsService.loadUserByUsername("andreea");
    }

    @RequestMapping("/login-error.html")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "static/login.html";
    }
}
