package dao.Impl;

import com.mchange.v2.c3p0.jboss.C3P0PooledDataSource;
import dao.UserDao;
import domain.User;
import mapper.UserMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao{

   /* //private DriverManagerDataSource driverManagerDataSource;*/
    private JdbcTemplate jd;

    public void setJd(JdbcTemplate jd) {
        this.jd = jd;
    }

   /* public void setDriverManagerDataSource(DriverManagerDataSource driverManagerDataSource) {
        this.driverManagerDataSource = driverManagerDataSource;
    }
    */

    public List<User> findUser() {
         List <User> query = jd.query("select * from user",new UserMapper());
         return query;
    }

    public void addUser() {
        jd.update("insert  into user values (null,?,?,?,?,?)",new User());

    }
}
