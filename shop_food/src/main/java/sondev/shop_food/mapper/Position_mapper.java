package sondev.shop_food.mapper;

import org.springframework.jdbc.core.RowMapper;
import sondev.shop_food.model.Position;
import sondev.shop_food.utils.View;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Position_mapper implements RowMapper<Position> {
    @Override
    public Position mapRow(ResultSet rs, int rowNum) throws SQLException {
        Position item = new Position();
        item.setId(rs.getInt(View.COL_POSITION_ID));
        item.setTitle(rs.getString(View.COL_POSITION_TITLE));
        item.setStatus(rs.getInt(View.COL_POSITION_STATUS));

        return item;
    }
}
