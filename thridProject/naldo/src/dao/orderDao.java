package dao;

import java.util.List;

import domain.Order;

public interface orderDao {
	//增删改查id ：订单id
		boolean addorder(Order order);//增加订单
		
		boolean delorder_Byid(int id);// 通过ID删除订单
		boolean delorder_Byorder_no(String order_no);//通过订单号删除订单
		boolean delorder_Byuser_Id(int user_Id);//通过用户id删除订单
		
		boolean updateorder_Byid(int id, Order order);//通过id更新订单//能更新的只有 订单状态，付款状态，配送状态，地址
		boolean updateorder_Byorder_no(String order_no, Order order);//通过订单号更新订单//能更新的只有 订单状态，付款状态，配送状态，地址
		
		Order query_By_id(int id);//通过ID查询订单
		Order query_By_order_no(String Order_no);//通过订单号查询订单
		List<Order> query_Byuser_Id(int user_Id);//通过用户ID查询订单
		List<Order> queryAll();//查询所有订单
}
