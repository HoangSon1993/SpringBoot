package springboot.session2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/cate")
public class CategoryController {
    @GetMapping("/view")
    public String viewMgr(){
        return "ad_layout/cate_mgr";
    }
}
