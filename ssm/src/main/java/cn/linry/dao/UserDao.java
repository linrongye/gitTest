package cn.linry.dao;

import cn.linry.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    List<User> findUser();
    void updateUser(@Param("money") int money,@Param("id") int id);
    int getMoneyById(int id);
}
