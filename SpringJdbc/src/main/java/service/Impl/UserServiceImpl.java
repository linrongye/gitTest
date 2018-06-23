package service.Impl;

import dao.UserDao;
import domain.User;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService{
    private UserDao dao;

    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    public List <User> findUser() {
        return  dao.findUser();
    }

    public void addUser() {
        dao.addUser();
    }
}
