package sondev.jpa_mysql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sondev.jpa_mysql.entity.Category;
import sondev.jpa_mysql.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAllCategories (){

        return categoryRepository.findAll();
    }

    public Category saveCategory (Category category){
        return categoryRepository.save(category);
    }
}
