package springboot.connectsqlserver.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import springboot.connectsqlserver.models.Category;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcCategoryDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class CategoryRowMapper implements RowMapper<Category>{

        @Override
        public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
            Category category = new Category();
            category.setId(rs.getInt("id"));
            category.setName(rs.getString("name"));
            return category;
        }
    }

    public List<Category> findAll (){
        return jdbcTemplate.query("SELECT * FROM Cateory", new CategoryRowMapper());
    }

    public Category findById(int id){
        return jdbcTemplate.queryForObject("SELECT * FROM Category WHERE id = ?", new Object[]{id}, new CategoryRowMapper());
    }

    public int save (Category category){
        return jdbcTemplate.update("INSERT INTO Category (name) VALUES (?)", category.getName());
    }

    public int update (Category category){
        return jdbcTemplate.update("UPDATE Category SET name = ? WHERE id = ?", category.getName(), category.getId());
    }

    public int deleteById(int id){
        return jdbcTemplate.update("DELETE FROM Category WHERE id = ?", id);
    }
}
