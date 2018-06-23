package SpringTest1.controller;

import SpringTest1.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:beans.xml"})
public class UserController {

    @Autowired
    @Qualifier("userService")
    private UserService service;
    @Test
    public void addUser(){
        service.addUser();
    }
}
