package Mybatis.dao;

import Mybatis.domain.Orders;
import Mybatis.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.*;

public interface UserDao {
    int add(User user);
    List<User>  findAll();
    List<User> findBy(String username,String sex);
    byte countUser();
    List<User> query(int[] array);
    List<Orders> queryOrdersAndUsers();
    List<User> queryUsersAndOrders();
    List<User> queryByoption(@Param("map") Map<String,Object> map);
}
