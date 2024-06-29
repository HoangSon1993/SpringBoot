package springboot.session1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import springboot.session1.util.AttributeNames;
import springboot.session1.util.Mappings;
import springboot.session1.util.ViewNames;

import javax.swing.text.View;

@Controller
public class DemoController {

    @GetMapping(Mappings.HOME_INDEX)
    public String index(Model model){
        model.addAttribute(AttributeNames.TITLE_INDEX,"trang chinh");
        return ViewNames.HOME_INDEX;
    }

    @GetMapping(Mappings.ADMIN)
    public String admin(){
        return ViewNames.ADMIN;
    }
}
