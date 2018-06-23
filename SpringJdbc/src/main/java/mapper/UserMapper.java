package mapper;

import domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User u = new User();
        u.setId(resultSet.getString("id"));
        u.setUsername(resultSet.getString("username"));
        u.setBirthday(resultSet.getString("birthday"));
        u.setSex(resultSet.getString("sex"));
        u.setAddress(resultSet.getString("address"));
        u.setTest(resultSet.getString("test"));

        return u;
    }
}
