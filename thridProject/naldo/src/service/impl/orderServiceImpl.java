package service.impl;

import java.sql.SQLException;
import java.util.List;

import dao.impl.orderDaoImpl;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import dao.orderDao;
import domain.Order;
import factory.BeanFactory;
import service.orderService;
import util.DBUtil;

public class orderServiceImpl implements orderService {
	private orderDao orderdaoimpl=new orderDaoImpl();
	
	@Override//显示所有的订单
	public List<Order> showAllOrder() {		
		return orderdaoimpl.queryAll();
	}

	@Override//分页显示所有的订单
	public List<Order> showAllorderWithPages(int start, int pagesize) {
		List<Order> orders=null;
		QueryRunner qr=new QueryRunner(DBUtil.getDs());
		String sql="SELECT * FROM `order` LIMIT ?,?";
		try {
			orders=qr.query(sql, new BeanListHandler<Order>(Order.class),start,pagesize);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orders;
	}
	
	@Override //计数
	public int numOforder() {
		List<Order> orders=orderdaoimpl.queryAll();
		return orders.size();
	}
	
	@Override//增加订单
	public boolean AddOrder(Order order) {
		
		return orderdaoimpl.addorder(order);
	}

	@Override//通过订单号查询订单
	public Order findorderByorder_no(String order_no) {
		// TODO Auto-generated method stub
		return orderdaoimpl.query_By_order_no(order_no);
	}

	@Override//通过用户id查询订单
	public List<Order> findorderByuser_id(int user_Id) {
		
		return orderdaoimpl.query_Byuser_Id(user_Id);
	}

	@Override//通过订单id查询订单
	public Order findorderByid(int id) {
		
		return orderdaoimpl.query_By_id(id);
	}

	@Override//通过订单ID修改订单
	public boolean updateorderByid(int id, Order order) {
		
		return orderdaoimpl.updateorder_Byid(id, order);
	}

	@Override//通过订单号修改订单
	public boolean updateorderByorder_no(String order_no, Order order) {
		
		return orderdaoimpl.updateorder_Byorder_no(order_no, order);
	}

	@Override//通过id删除订单
	public boolean delorderByid(int id) {
	
		return orderdaoimpl.delorder_Byid(id);
	}

	@Override//通过订单号删除订单
	public boolean delorderByorder_no(String order_no) {
		
		return orderdaoimpl.delorder_Byorder_no(order_no);
	}

	@Override//通过用户id删除订单
	public boolean delorderByuser_id(int user_id) {
		
		return orderdaoimpl.delorder_Byuser_Id(user_id);
	}

	

	

}
