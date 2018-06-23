package cn.aop.service.Impl;

import cn.aop.dao.UserDao;
import cn.aop.service.addUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("addUserService")
public class addUserServiceImpl implements addUserService {
    @Resource
    private UserDao userDao;

    /*public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
*/
    @Override
    public void addUser() {
        userDao.addUser();
    }
    @Override
    public void findUser() {
        userDao.findUser();
    }
}
