package cn.linry.dao;


import cn.linry.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserDao {
    int addUser(User user);
    List<User> findUser();
    void deleteUser(int id);
    void updateUser(User user);
}
