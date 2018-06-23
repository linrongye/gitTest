package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;
import service.UserService1;
import util.BeanFactory;

import java.util.Arrays;

public class SpringController {


    @Autowired
    private static UserService service;
    @Autowired
    private static  UserService1 service1;
    public static void main(String[] args) {
       // UserService userServiceImpl = (UserService) BeanFactory.getBean("UserServiceImpl");
     /*   ChongZhi chongZhi=new ChinaChong();
        chongZhi.chongzhi();*/
        //Arrays.sort();

     /*   SellProxy sellProxy=new SellProxy(new ChinaChong());
        ChongZhi proxyChong=(ChongZhi) sellProxy.getInstance();
        proxyChong.chongzhi();*/
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean.xml");
        UserService userServiceImpl = (UserService)applicationContext.getBean("userService");
        //UserService userService1 = (UserService)applicationContext.getBean("userService1Impl");
        userServiceImpl.saveUser();
      //  userService1.saveUser();
        //service1.saveUser();

    }

}
