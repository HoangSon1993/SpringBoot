package com.sondev.interceptor.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.logging.Logger;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping(value = "",method = RequestMethod.GET)
    public String index(){
        return "ad_index";
    }

    @GetMapping(value = "/login")
    public String formLogin(){
        return "ad_login";
    }

    @RequestMapping(value = "/chklogin", method = RequestMethod.POST)
    public String chkLogin (@RequestParam("usr") String username, @RequestParam("pwd") String password, HttpServletRequest request){
        Logger log = Logger.getGlobal();
        log.info(username + " " + password);
        request.getSession().setAttribute("myacc", username);
        return "redirect:/admin";
    }
}
