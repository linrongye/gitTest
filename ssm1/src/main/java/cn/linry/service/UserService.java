package cn.linry.service;

import cn.linry.domain.User;

public interface UserService {
    void addUser();
    void findUser();
    void deleteUser(int id);
    void updateUser(User user);
}
