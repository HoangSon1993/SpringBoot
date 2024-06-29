package com.sondev.interceptor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ClientController {
    @GetMapping(value = "")
    public String index(){
        return "client_index";
    }

    @GetMapping(value = "pros")
    public String products(){
        return "client_product";
    }
}
