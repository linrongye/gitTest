package cn.aop.service.Impl;

import cn.aop.dao.UserDao;
import cn.aop.service.addUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class addUserServiceImpl implements addUserService {
    @Resource
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void addUser() {
        userDao.addUser();
    }

    public void findUser() {
        userDao.findUser();
    }
}
