package cn.linry.service.Impl;

import cn.linry.dao.OrdersDao;
import cn.linry.domain.Order;
import cn.linry.domain.item;
import cn.linry.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersDao dao;
    public List<Order> findOrders() {
        return null;
    }

    public item findOrdersById(int id) {
        return dao.findOrdersById(id);
    }
}
