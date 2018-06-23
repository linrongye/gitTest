package cn.linry.controller;

import cn.linry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping("addUser")
    public void addUser(){

        service.addUser();
        service.findUser();
    }
}
