package dao;

import entity.Order;

import java.util.List;

public interface OrderMapper {
    int orderMapper(Order order);
    //查询所有的订单
    List<Order> queryAllOrder();
    //删除特定订单
    Integer deleteOrder(Integer userId);
}
