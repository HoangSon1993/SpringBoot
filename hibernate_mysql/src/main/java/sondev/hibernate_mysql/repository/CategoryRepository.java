package sondev.hibernate_mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sondev.hibernate_mysql.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
