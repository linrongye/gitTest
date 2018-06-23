package cn.linry.service.Impl;

import cn.linry.dao.UserDao;
import cn.linry.domain.User;
import cn.linry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    public void findUser() {
        List <User> user = userDao.findUser();
        for (User user1 : user) {
            System.out.println(user);
        }
    }

    public void turnMoney() {
        int money = userDao.getMoneyById(3);

         int money1 = userDao.getMoneyById(4);

         userDao.updateUser(money-100,3);
         int i=1/0;
         userDao.updateUser(money+100,4);
    }
}
