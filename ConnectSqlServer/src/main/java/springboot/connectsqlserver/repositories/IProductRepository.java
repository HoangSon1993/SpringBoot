package springboot.connectsqlserver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.connectsqlserver.models.Product;

public interface IProductRepository extends JpaRepository<Product,Integer> {
}
