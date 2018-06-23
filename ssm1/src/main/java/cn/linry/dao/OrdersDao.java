package cn.linry.dao;

import cn.linry.domain.Order;
import cn.linry.domain.item;

import java.util.List;

public interface OrdersDao {
    List<Order> findOrders();
    item findOrdersById(int id);
}
