package cn.linry.service;

import cn.linry.domain.Order;
import cn.linry.domain.item;

import java.util.List;

public interface OrdersService {
    List<Order> findOrders();
    item findOrdersById(int id);
}
