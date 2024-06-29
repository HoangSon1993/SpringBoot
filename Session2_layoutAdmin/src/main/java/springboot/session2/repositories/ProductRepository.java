package springboot.session2.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import springboot.session2.models.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ProductRepository {
    @Autowired
    private JdbcTemplate db;

    static class ProductRowMapper implements RowMapper<Product>{

        @Override
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            Product item = new Product();
            item.setIdc(rs.getInt(Product.IDP));
            item.setName_pro(rs.getString(Product.NAME_P));
            item.setDescript_pro(rs.getString(Product.DESC_P));
            item.setPrice_pro(rs.getDouble(Product.PRICE_P));
            item.setImg_name(rs.getString(Product.IMG_NAME_P));

            return item;
        }
    }
}
