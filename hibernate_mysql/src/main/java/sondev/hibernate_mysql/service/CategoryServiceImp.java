package sondev.hibernate_mysql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sondev.hibernate_mysql.entity.Category;
import sondev.hibernate_mysql.repository.CategoryRepository;

import java.util.List;
import java.util.Objects;

// Annotation
@Service

// Class
public class CategoryServiceImp implements IService<Category> {
    @Autowired
    private CategoryRepository categoryRepository;

    // Save operation
    @Override
    public Category save(Category item) {
        return categoryRepository.save(item);
    }

    // Read operation
    @Override
    public List<Category> fetchList() {
        return (List<Category>) categoryRepository.findAll();
    }

    // Update operation
    @Override
    public Category update(Category category, Long id) {
        Category cateDB = categoryRepository.findById(id).get();

        if (Objects.nonNull(cateDB.getName()) && !"".equalsIgnoreCase(cateDB.getName())) {
            cateDB.setName(category.getName());
        }
        // Tương tự thực hiện với các cột khác trong bảng.
        return categoryRepository.save(cateDB);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
