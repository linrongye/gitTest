package cn.aop.dao.Impl;

import cn.aop.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void addUser() {
        System.out.println("����һ���û�");
    }
    @Override
    public void findUser() {
        System.out.println("��ѯ���û���");
    }
}
