package controller;

import domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;

import java.util.List;

public class UserController {
    private static UserService service;

    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
        service=(UserService) context.getBean("userService");
        List <User> user = service.findUser();
        for (User user1 : user) {
            System.out.println(user1);
        }
        service.addUser();
    }
}
