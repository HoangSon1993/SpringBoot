package sondev.hibernate_mysql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sondev.hibernate_mysql.entity.Product;
import sondev.hibernate_mysql.repository.ProductRepository;

import java.util.List;
import java.util.Objects;
@Repository
public class ProductServiceImp implements IService<Product> {

    private final ProductRepository productRepository;

    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Save operation
    @Override
    public Product save(Product item) {
        return productRepository.save(item);
    }

    // Read operation
    @Override
    public List<Product> fetchList() {
        return (List<Product>) productRepository.findAll();
    }

    // Update operation
    @Override
    public Product update(Product product, Long id) {
        Product proDB = productRepository.findById(id).get();

        if(Objects.nonNull(proDB.getName()) && !"".equalsIgnoreCase(proDB.getName())){
            proDB.setName(product.getName());
        }

        if(!Objects.nonNull(proDB.getPrice())){
            proDB.setPrice(product.getPrice());
        }

        return productRepository.save(proDB);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
