package service.impl;

import dao.Dao;
import dao.Impl.DaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import service.UserService;
import service.UserService1;

import javax.annotation.Resource;
import java.lang.reflect.Type;

@Service
@Scope("prototype")
public class UserService1Impl implements UserService {
    @Resource(type = DaoImpl.class)
    private Dao dao;
    @Override
    public void saveUser() {
        dao.saveUser();
    }
}
