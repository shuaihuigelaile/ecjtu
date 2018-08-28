package service;

import dao.OrderMapper;
import entity.Order;

import java.util.List;

public interface IOrderService {
    //插入方法
    int OrderMapper(Order order);
    //查询所有订单
    List<Order> queryAllOrder();
    //删除特定订单
    Integer deleteOrder(Integer userId);
}
