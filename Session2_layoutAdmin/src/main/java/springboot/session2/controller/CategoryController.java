package springboot.session2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springboot.session2.models.Category;
import springboot.session2.repositories.CategoryRepository;

import java.util.List;

@Controller
@RequestMapping("/admin/cate")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;
    @GetMapping("/view")
    public String viewMgr(){
        List<Category> categoryList = categoryRepository.findAll();
        return "ad_layout/cate_mgr";
    }
}
