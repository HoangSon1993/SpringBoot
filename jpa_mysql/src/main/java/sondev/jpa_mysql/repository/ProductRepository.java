package sondev.jpa_mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sondev.jpa_mysql.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
