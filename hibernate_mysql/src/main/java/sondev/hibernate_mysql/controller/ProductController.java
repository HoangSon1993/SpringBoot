package sondev.hibernate_mysql.controller;

import org.springframework.web.bind.annotation.*;
import sondev.hibernate_mysql.entity.Product;
import sondev.hibernate_mysql.service.ProductServiceImp;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductServiceImp productServiceImp;

    public ProductController(ProductServiceImp productServiceImp) {
        this.productServiceImp = productServiceImp;
    }

    // Save operation
    @PostMapping("")
    public Product saveProduct(@RequestBody Product product) {
        return productServiceImp.save(product);
    }

    // Read operation
    @GetMapping("")
    public List<Product> getAllProduct() {
        return productServiceImp.fetchList();
    }

    // Update operation
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable("id")Long productId, @RequestBody Product product){
        return productServiceImp.update(product, productId);
    }

    // Delete operation
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable("id")Long productId){
        productServiceImp.deleteById(productId);
        return "Delete product Successful";
    }
}
