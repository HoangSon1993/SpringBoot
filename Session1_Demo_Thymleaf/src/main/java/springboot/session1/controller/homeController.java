package springboot.session1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homeController {
    @GetMapping ("/myprofile")
    public String index(){
        return "myprofile";
    }
}
