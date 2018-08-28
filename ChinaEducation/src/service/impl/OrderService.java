package service.impl;

import dao.OrderMapper;
import entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.IOrderService;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService implements IOrderService {
    @Autowired
    OrderMapper orderMapper;
    @Override
    public int OrderMapper(Order order) {
        //生成订单编号
        int hashCodeV=UUID.randomUUID().toString().hashCode();
        if (hashCodeV<0){
            hashCodeV=-hashCodeV;
        }
        Date date = new Date();
        order.setOrderId(hashCodeV);
        order.setBuyTime(date);
        return orderMapper.orderMapper(order);
    }

    @Override
    public List<Order> queryAllOrder() {
        return orderMapper.queryAllOrder();
    }

    @Override
    public Integer deleteOrder(Integer userId) {
        System.out.println("进入了deleteOrderService方法");
        return orderMapper.deleteOrder(userId);
    }
}
