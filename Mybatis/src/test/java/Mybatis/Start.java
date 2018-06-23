package Mybatis;

import Mybatis.dao.UserDao;
import Mybatis.domain.Orders;
import Mybatis.domain.User;
import Mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Start {
    SqlSession sqlSession;
    UserDao mapper;
    @Before
    public void init(){
        sqlSession=MybatisUtil.getSqlSessionFactory().openSession();
         mapper = sqlSession.getMapper(UserDao.class);
    }
    @Test
    public void add() throws UnsupportedEncodingException {
        SqlSession sqlSession =  MybatisUtil.getSqlSessionFactory().openSession(true);
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user=new User();
        user.setUsername("linry");
        user.setBirthday(new Date());
        String address=new String("广州".getBytes("utf8"),"utf8");
        System.out.println(address);
        user.setAddress(address);
       // String sex=new String("男".getBytes("GBK"),"utf-8");
        user.setSex("男");
        int add = mapper.add(user);
        System.out.println(user.getId());
        //sqlSession.select();
    }

    @Test
    public void findAll(){
        SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession();
        UserDao mapper = sqlSession.getMapper(Mybatis.dao.UserDao.class);
        List <User> all = mapper.findAll();
        for (User user : all) {
            System.out.println(user.getUsername()+"  "+user.getAddress());
        }
    }
    @Test
    public  void findBy(){
        SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List <User> userList = mapper.findBy("%明%", "1");
        for (User user : userList) {
            System.out.println(user.getUsername()+ "   "+user.getSex());
        }
        sqlSession.close();
    }
    @Test
    public void countUser(){
        SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        byte i = mapper.countUser();
        System.out.println(i);
    }
   /* @After
    public void destory(){
        sqlSession.close();
    }*/
    @Test
    public void query(){
        UserDao mapper = MybatisUtil.getSqlSessionFactory().openSession().getMapper(UserDao.class);
        int[] a=new int[]{45, 46, 47, 48};
        List <User> query = mapper.query(a);
        for (User user : query) {
            System.out.println(user.getUsername()+ "   "+user.getSex());
        }
    }

    @Test
    public void queryOrdersAndUsers(){

        List <Orders> orders = mapper.queryOrdersAndUsers();
        for (Orders order : orders) {
            System.out.println(order);
        }
    }
    @Test
    public void queryUsersAndOrders(){
        List <User> users = mapper.queryUsersAndOrders();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();

    }
    @Test
    public void queryByoption(){
        Map<String,Object> map=new HashMap <String, Object>();
        map.put("id",1);
        map.put("sex","2");
        List <User> users1 = mapper.queryByoption(map);
        for (User user : users1) {
            System.out.println(users1);
        }


    }

}
