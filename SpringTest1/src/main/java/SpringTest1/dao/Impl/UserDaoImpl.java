package SpringTest1.dao.Impl;

import SpringTest1.dao.UserDao;
import SpringTest1.domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private QueryRunner queryRunner;

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    public UserDaoImpl() {
    }

    public void addUser() throws SQLException {
        System.out.println(new UserDaoImpl() instanceof UserDao);
        System.out.println("添加用戶成功!!!!");
        List <User> query = queryRunner.query("select * from user", new BeanListHandler <User>(User.class));
        System.out.println(query);
    }
}
