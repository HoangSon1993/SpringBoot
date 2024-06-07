package springboot.connectsqlserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springboot.connectsqlserver.dao.JdbcProductDao;
import springboot.connectsqlserver.models.Product;
import springboot.connectsqlserver.repositories.ICategoryRepository;
import springboot.connectsqlserver.repositories.IProductRepository;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private JdbcProductDao jdbcProductDao;
    @Autowired
    private ICategoryRepository categoryRepository;

    @GetMapping
    public String getAllProducts(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "product-list";
    }

    @GetMapping("/{id}")
    public String getProductById(@PathVariable int id, Model model) {
        Product product = productRepository.findById(id).orElse(null);
        model.addAttribute("product", product);
        return "product-detail";
    }

    @GetMapping("/new")
    public String createProductForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryRepository.findAll());
        return "product-form";
    }

    @PostMapping
    public String createProduct(@ModelAttribute Product product) {
        productRepository.save(product);
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String updateProductForm(@PathVariable int id, Model model) {
        Product product = productRepository.findById(id).orElse(null);
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryRepository.findAll());
        return "product-form";
    }

    @PostMapping("/{id}")
    public String updateProduct(@PathVariable int id, @ModelAttribute Product product) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setCategory(product.getCategory());
        productRepository.save(existingProduct);
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        productRepository.deleteById(id);
        return "redirect:/products";
    }

    // JDBC Template methods
    @GetMapping("/jdbc")
    public String getAllProductsJdbc(Model model) {
        List<Product> products = jdbcProductDao.findAll();
        model.addAttribute("products", products);
        return "product-list";
    }

    @GetMapping("/jdbc/{id}")
    public String getProductByIdJdbc(@PathVariable int id, Model model) {
        Product product = jdbcProductDao.findById(id);
        model.addAttribute("product", product);
        return "product-detail";
    }

    @PostMapping("/jdbc")
    public String createProductJdbc(@ModelAttribute Product product) {
        jdbcProductDao.save(product);
        return "redirect:/products/jdbc";
    }

    @PostMapping("/jdbc/{id}")
    public String updateProductJdbc(@PathVariable int id, @ModelAttribute Product product) {
        jdbcProductDao.update(product);
        return "redirect:/products/jdbc";
    }

    @GetMapping("/jdbc/delete/{id}")
    public String deleteProductJdbc(@PathVariable int id) {
        jdbcProductDao.deleteById(id);
        return "redirect:/products/jdbc";
    }
}
