package dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.sun.org.apache.bcel.internal.generic.NEW;

import dao.orderDao;
import domain.Order;
import util.DBUtil;

public class orderDaoImpl  implements orderDao{
	static QueryRunner qr;
	static{
		qr=new QueryRunner(DBUtil.getDs());
	}
	@Override
	public boolean addorder(Order order) {
		int i=0;
		String sql="INSERT into `order` (order_no,user_Id,order_State,payment_status,shipment_Status,address_id) VALUES(?,?,?,?,?,?)";
		String no=order.getOrder_no();
		int user_id=order.getUser_Id();
		String order_state=order.getOrder_State();
		int payment_status=order.getPayment_status();
		String shipment_Status=order.getShipment_status();
		int address_id=order.getAddress_id();
		try {
			i=qr.update(sql, new Object[]{no,user_id,order_state,payment_status,shipment_Status,address_id});
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (i>0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean delorder_Byid(int id) {
		int i=0;
		String sql="DELETE FROM `order` where id=?";
		try {
			i=qr.update(sql, new Object[]{id});
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i>0?true:false;
	}

	@Override
	public boolean delorder_Byorder_no(String order_no) {
		int i=0;
		String sql="DELETE FROM `order` where order_no=?";
		try {
			i=qr.update(sql, new Object[]{order_no});
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i>0?true:false;
	}

	@Override
	public boolean delorder_Byuser_Id(int user_Id) {
		int i=0;
		String sql="DELETE FROM `order` where user_Id=?";
		try {
			i=qr.update(sql, new Object[]{user_Id});
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i>0?true:false;
	}

	@Override
	public boolean updateorder_Byid(int id, Order order) {
		int i=0;//能更新的只有 订单状态，付款状态，配送状态，地址
		String sql="UPDATE `order` set order_State=?,payment_status=?,shipment_status=?,address_id=? where id=?";
		try {
			i=qr.update(sql, new Object[]{order.getOrder_State(),order.getPayment_status(),order.getShipment_status(),order.getAddress_id(),id});
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i>0?true:false;
	}

	@Override
	public boolean updateorder_Byorder_no(String order_no, Order order) {
		int i=0;//能更新的只有 订单状态，付款状态，配送状态，地址
		String sql="UPDATE `order` set order_State=?,payment_status=?,shipment_status=?,address_id=? where order_no=?";
		try { 
			i=qr.update(sql, new Object[]{order.getOrder_State(),order.getPayment_status(),order.getShipment_status(),order.getAddress_id(),order_no});
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i>0?true:false;
	}

	@Override
	public Order query_By_id(int id) {
		Order order=null;
		String sql="SELECT * from  `order` where id=?";
		try {
			order=qr.query(sql,new BeanHandler<Order>(Order.class),id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return order;
	}

	@Override
	public Order query_By_order_no(String Order_no) {
		Order order=null;
		String sql="SELECT * from  `order` where Order_no=?";
		try {
			order=qr.query(sql,new BeanHandler<Order>(Order.class),Order_no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return order;
	}

	@Override
	public List<Order> query_Byuser_Id(int user_Id) {
		List<Order> orders=null;
		String sql="SELECT * from  `order` where user_Id=? ";
		try {
			orders=qr.query(sql,new BeanListHandler<Order>(Order.class),user_Id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orders;
	}

	@Override
	public List<Order> queryAll() {
		List<Order> orders=null;
		String sql="SELECT * from  `order`";
		try {
			orders=qr.query(sql,new BeanListHandler<Order>(Order.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orders;
	}
	
}
