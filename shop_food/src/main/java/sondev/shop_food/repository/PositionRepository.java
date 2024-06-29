package sondev.shop_food.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import sondev.shop_food.mapper.Position_mapper;
import sondev.shop_food.model.Position;

import java.util.List;

@Repository
public class PositionRepository {
    @Autowired
    JdbcTemplate db;

    public List<Position> findAll(){
        return db.query("SELECT * FROM tbl_position", new Position_mapper());
    }

//    public List<Position> findPaginated(int page, int size) {
//        String sql = "SELECT * FROM tbl_position ORDER BY _id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
//        int offset = (page - 1) * size;
//        return db.query(sql, new Position_mapper(), offset, size);
//    }


    public int count(){
        return db.queryForObject("SELECT COUNT(*) FROM tbl_position", Integer.class);
    }

    public String newPosition(Position newItem) {
      try {
          int rowAccept = db.update("INSERT INTO tbl_position values (?,?) ", new Object[]{newItem.getTitle(), newItem.getStatus()});
          if(rowAccept == 1){
              return "Success";
          }else{
              return  "Failed";
          }
      } catch (Exception e){

      }
      return "da co loi ngoai le xay ra";
    }

    public String deletePosition(int id) {
       try {
         int rowAccept = db.update("delete  from tbl_position where _id=?", new Object[]{id});
         if(rowAccept == 1){
             return "Success";
         }else {
             return "Failed";
         }
       }catch (DataAccessException ex){

       }
       return "Delete exception data";
    }

    public Position findById(String id) {
       return db.queryForObject("SELECT * FROM tbl_position where _id = ?", new Position_mapper(),id);
    }

    public String update(Position position) {
        try {
            int rowAccept = db.update("UPDATE tbl_position SET _title = ?, _status  = ? WHERE _id = ?", new Object[]{position.getTitle(), position.getStatus(), position.getId()});
            if(rowAccept == 1){
                return "Update Successful";
            }else {
                return "Update fail";
            }
        }catch (DataAccessException ex){
            //
        }
        return "Data Accept exception";
    }
}
