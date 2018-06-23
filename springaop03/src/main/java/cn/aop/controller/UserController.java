package cn.aop.controller;

import cn.aop.service.addUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserController {
   /* @Autowired
    private addUserService service;*/

    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
        addUserService addUserService = (addUserService) context.getBean("addUserService");
        addUserService.findUser();
    }
}
