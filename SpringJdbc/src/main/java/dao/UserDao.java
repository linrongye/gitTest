package dao;

import domain.User;

import java.util.List;

public interface UserDao {
    List<User> findUser();
    void addUser();
}
