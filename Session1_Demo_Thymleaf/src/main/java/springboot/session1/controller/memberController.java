package springboot.session1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class memberController {
    @RequestMapping("/admin")
    public String index(){
        return "indexad";
    }
}
