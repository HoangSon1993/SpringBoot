package springboot.connectsqlserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springboot.connectsqlserver.dao.JdbcCategoryDao;
import springboot.connectsqlserver.models.Category;
import springboot.connectsqlserver.repositories.ICategoryRepository;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Autowired
    private JdbcCategoryDao jdbcCategoryDao;

    @GetMapping
    public String getAllCategories (Model model){
        List<Category> categories = categoryRepository.findAll();
        return "category-list";
    }
    @GetMapping("/{id}")
    public String getCategoryById(@PathVariable int id, Model model){
        Category category = categoryRepository.findById(id).orElse(null);
        model.addAttribute("category", category);
        return "category-detail";
    }
    @GetMapping("/new")
    public String createCategoryForm(Model model){
        model.addAttribute("category", new Category());
        return "category-form";
    }
    @PostMapping
    public String creaateCategory(@ModelAttribute Category category){
        categoryRepository.save(category);
        return "redirect:/categories";
    }
    @GetMapping("/edit/{id}")
    public String updateCategoryForm(@PathVariable int id, Model model) {
        Category category = categoryRepository.findById(id).orElse(null);
        model.addAttribute("category", category);
        return "category-form";
    }

    @PostMapping("/{id}")
    public String updateCategory(@PathVariable int id, @ModelAttribute Category category) {
        Category existingCategory = categoryRepository.findById(id).orElse(null);
        existingCategory.setName(category.getName());
        categoryRepository.save(existingCategory);
        return "redirect:/categories";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable int id) {
        categoryRepository.deleteById(id);
        return "redirect:/categories";
    }

    // JDBC Template methods
    @GetMapping("/jdbc")
    public String getAllCategoriesJdbc(Model model) {
        List<Category> categories = jdbcCategoryDao.findAll();
        model.addAttribute("categories", categories);
        return "category-list";
    }

    @GetMapping("/jdbc/{id}")
    public String getCategoryByIdJdbc(@PathVariable int id, Model model) {
        Category category = jdbcCategoryDao.findById(id);
        model.addAttribute("category", category);
        return "category-detail";
    }

    @PostMapping("/jdbc")
    public String createCategoryJdbc(@ModelAttribute Category category) {
        jdbcCategoryDao.save(category);
        return "redirect:/categories/jdbc";
    }

    @PostMapping("/jdbc/{id}")
    public String updateCategoryJdbc(@PathVariable int id, @ModelAttribute Category category) {
        jdbcCategoryDao.update(category);
        return "redirect:/categories/jdbc";
    }

    @GetMapping("/jdbc/delete/{id}")
    public String deleteCategoryJdbc(@PathVariable int id) {
        jdbcCategoryDao.deleteById(id);
        return "redirect:/categories/jdbc";
    }
}
