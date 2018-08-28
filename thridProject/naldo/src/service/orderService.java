package service;

import java.util.List;

import domain.Order;

public interface orderService {
	//显示所有订单
	List<Order> showAllOrder();
	//分页显示所有订单
	List<Order> showAllorderWithPages(int start, int pagesize);
	//查询订单表数据总数
	int numOforder();
	
	//增加订单
	boolean AddOrder(Order order);
	
	//通过   订单号查询订单
	Order findorderByorder_no(String order_no);	
	//通过   用户id查询订单  一个用户可能有多个订单
	List<Order> findorderByuser_id(int user_id);
	//通过  订单id查询订单
	Order findorderByid(int id);
	
	//更新订单状态  能更新的只有 订单状态，付款状态，配送状态，地址
	//通过订单id
	boolean updateorderByid(int id, Order order);
	//通过订单号
	boolean updateorderByorder_no(String order_no, Order order);
	
	//删除订单
	//通过id
	boolean delorderByid(int id);
	//通过订单号
	boolean delorderByorder_no(String order_no);
	//通过用户ID
	boolean delorderByuser_id(int user_id);
}
