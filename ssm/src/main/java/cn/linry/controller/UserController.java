package cn.linry.controller;

import cn.linry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("hello")
    public ModelAndView userController(){
        userService.findUser();
        ModelAndView modelAndView=new ModelAndView("success");
        System.out.println("返回前");
        return modelAndView;
    }

    @RequestMapping("turnMoney.do")
    public ModelAndView turnMoney(HttpServletRequest httpServletRequest, Model model){
        userService.turnMoney();
        ModelAndView modelAndView=new ModelAndView("success");
        return  modelAndView;
    }

}
