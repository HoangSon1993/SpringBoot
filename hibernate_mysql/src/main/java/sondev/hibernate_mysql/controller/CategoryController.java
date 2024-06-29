package sondev.hibernate_mysql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sondev.hibernate_mysql.entity.Category;
import sondev.hibernate_mysql.service.CategoryServiceImp;

import java.util.List;

@RestController
@RequestMapping("/categories")

public class CategoryController {

    private final CategoryServiceImp categoryServiceImp;

    public CategoryController(CategoryServiceImp categoryServiceImp) {
        this.categoryServiceImp = categoryServiceImp;
    }

    // Save operation
    @PostMapping("")
    public Category saveCategory(@RequestBody Category category) {
        return categoryServiceImp.save(category);
    }

    // Read operation
    @GetMapping("")
    public List<Category> getAllCategory() {
        return categoryServiceImp.fetchList();
    }

    // Update operation
    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable("id") Long categoryId, @RequestBody Category category){
        return categoryServiceImp.update(category, categoryId);
    }

    // Delete operation
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable("id") Long categoryId){
         categoryServiceImp.deleteById(categoryId);
        return "Delete Successful";
    }

}
