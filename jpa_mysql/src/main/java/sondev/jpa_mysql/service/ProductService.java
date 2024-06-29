package sondev.jpa_mysql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sondev.jpa_mysql.entity.Product;
import sondev.jpa_mysql.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts (){
        return productRepository.findAll();
    }

    public Product saveProduct (Product product){
        return productRepository.save(product);
    }
}
