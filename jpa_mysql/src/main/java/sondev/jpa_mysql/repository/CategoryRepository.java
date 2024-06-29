package sondev.jpa_mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sondev.jpa_mysql.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}