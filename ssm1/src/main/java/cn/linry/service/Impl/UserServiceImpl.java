package cn.linry.service.Impl;

import cn.linry.dao.UserDao;
import cn.linry.domain.User;
import cn.linry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    public void addUser() {
        User user=new User();
        user.setUsername("linry1");
        user.setAddress("遥远的地方");
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        user.setBirthday(simpleDateFormat.format(new Date()));
        user.setSex("男");
        user.setTest("2000");
        if(dao.addUser(user)>0){
            System.out.println("插入数据成功！！");
        }
    }

    public void findUser() {
        List <User> user = dao.findUser();
        for (User user1 : user) {
            System.out.println(user1);
        }

    }

    public void deleteUser(int id) {

    }

    public void updateUser(User user) {

    }
}
