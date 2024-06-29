package sondev.hibernate_mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sondev.hibernate_mysql.entity.Category;
import sondev.hibernate_mysql.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
