package springboot.session2.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import springboot.session2.models.Category;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public final class CategoryRepository {
    private static  CategoryRepository _instance =null;
    private JdbcTemplate db;

    public CategoryRepository() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/sample1?verifyServerCertificate=false&useSSL=false&requireSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        db= new JdbcTemplate(dataSource);
    }

    public static  CategoryRepository Instance (){
        if(_instance == null){
            _instance = new CategoryRepository();
        }
        return _instance;
    }

    class CategoryRowMapper implements RowMapper<Category>{
        @Override
        public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
            Category item = new Category();
            item.setIdc(rs.getInt(Category.IDC));
            item.setName_c(rs.getString(Category.NAME_C));
            item.setActive(rs.getInt(Category.ACTIVE));
            return item;
        }
    }

    public List<Category> findAll (){
        return db.query("select * from Category", new CategoryRowMapper());
    }

    public Category FindById(int id){
        return db.queryForObject("select * from category where idc=?", new CategoryRowMapper(), new Object[] {id});
    }

    public int deleteById(int id){
        return db.update("delete from Category where idc=?", new Object[]{id});
    }
}
