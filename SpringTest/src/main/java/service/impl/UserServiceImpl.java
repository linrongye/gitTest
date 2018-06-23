package service.impl;

import dao.Dao;
import dao.Impl.DaoImpl;
import dao.Impl.DaoImpl1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import service.UserService;

import javax.annotation.Resource;

@Service("userService")
@Scope("prototype")
public class UserServiceImpl implements UserService {
    @Resource(type = DaoImpl1.class)
    private Dao dao;

    @Override
    public void saveUser() {
        dao.saveUser();
        System.out.println("已经保存");
    }
}
