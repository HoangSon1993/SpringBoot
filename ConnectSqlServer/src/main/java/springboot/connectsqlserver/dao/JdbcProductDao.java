package springboot.connectsqlserver.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import springboot.connectsqlserver.models.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcProductDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;



    private static class ProductRowMapper implements RowMapper<Product> {

        @Override
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            Product product = new Product();
            product.setId(rs.getInt("id"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getDouble("price"));
            // Assuming category_id is correctly mapped to the Category entity
            return product;
        }
    }
    public List<Product> findAll (){
        return jdbcTemplate.query("SELECT * FROM Product", new ProductRowMapper());
    }

    public int save(Product product) {
        return jdbcTemplate.update("INSERT INTO Product (name, price, category_id) VALUES (?, ?, ?)",
                product.getName(), product.getPrice(), product.getCategory().getId());
    }

    public Product findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Product WHERE id = ?", new Object[]{id}, new JdbcProductDao.ProductRowMapper());
    }
    public int update(Product product) {
        return jdbcTemplate.update("UPDATE Product SET name = ?, price = ?, category_id = ? WHERE id = ?",
                product.getName(), product.getPrice(), product.getCategory().getId(), product.getId());
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM Product WHERE id = ?", id);
    }
}
