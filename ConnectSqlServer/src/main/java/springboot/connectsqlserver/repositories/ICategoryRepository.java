package springboot.connectsqlserver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.connectsqlserver.models.Category;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {

}
