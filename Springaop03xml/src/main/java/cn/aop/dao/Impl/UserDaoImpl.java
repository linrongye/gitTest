package cn.aop.dao.Impl;

import cn.aop.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    public void addUser() {
        System.out.println("存了一个用户");
    }

    public void findUser() {
        System.out.println("查询了用户表");
    }
}
