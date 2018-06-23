package SpringTest1.service.impl;

import SpringTest1.dao.Impl.UserDaoImpl;
import SpringTest1.dao.UserDao;
import SpringTest1.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.sql.SQLException;

@Service("userService")
public class UserServiceImpl implements UserService {

    @PostConstruct
    public void inti(){
        System.out.println("初始化。。。。。。");
    }

    @Resource(type = UserDaoImpl.class)
    private UserDao dao;
    public void addUser() {
        try {
            dao.addUser();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("調用了UserServiceImpl的addUser");
    }
    @PreDestroy
    public void destory(){
        System.out.println("銷毀方法。。。。。");
    }
}
