package cn.aop.dao.Impl;

import cn.aop.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    public void addUser() {
        System.out.println("����һ���û�");
    }

    public void findUser() {
        System.out.println("��ѯ���û���");
    }
}
