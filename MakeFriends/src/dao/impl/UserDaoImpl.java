package dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Before;
import org.junit.Test;

import dao.UserDao;

import pojo.User;
import util.C3P0Util;
import util.DBUtil;


public class UserDaoImpl implements UserDao {
	PreparedStatement ps;
	ResultSet rs;
	Connection conn;
	static QueryRunner qr;

	static{
		qr=new QueryRunner(C3P0Util.getDataSource());
	}
	@Before
	public void before() {
	 qr=new QueryRunner(C3P0Util.getDataSource());
	}
	
	@Override
	public int saveUser(User user){
		String insert_sql="insert into member(logname,password,phone,email,message,pic) values(?,?,?,?,?,?)";
		int result=0;
		try {
			conn = DBUtil.getConnection();
			ps=conn.prepareStatement(insert_sql);
			ps.setString(1, user.getLogname());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getPhone());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getMessage());
			ps.setString(6, user.getPic());
			result=ps.executeUpdate();
			System.out.println("插入数据成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
//	public int saveUser(User user){
//		String insert_sql="insert into member(logname,password,phone,email,messqge,pic) values(?,?,?,?,?,?)";		
//		int result=0;
//		try {
//			result=qr.update(insert_sql, new Object[]{user.getLogname(),user.getPassword(),user.getPhone(),user.getEmail(),user.getMessage(),user.getPic()});
//			System.out.println(result>0?"插入成功":"插入失败");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return result;
//	}
//
//
//	public void insert() {
//	
//	String insert_sql="insert into member(logname,password,phone,email,message,pic) values(?,?,?,?,?,?)";
//	try {
//	int result=qr.update(insert_sql,new Object[] {"admin1","123456","","","",""});
//	System.out.println(result>0?"插入成功":"插入失败");
//	} catch (SQLException e) {
//		e.printStackTrace();
//	}
//	}
//	
	
//	
//	public void delete() {
//		String delete_sql="delete from userinfo where username like ?";
//		int result;
//		try {
//			result = qr.update(delete_sql, new Object[] {"菜鸟%"});
//			System.out.println(result>0?"删除成功":"删除失败");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
//	
//	//批量插入
//	public void batch() {
//		String insert_sql="insert into member(logname,password) values(?,?)";
//		Object[][]params=new Object[3][];
//		for(int i=0;i<params.length;i++) {
//			params[i]=new Object[] {"隔壁老黄"+(i+1),(i+1)};
//		}
//		try {
//			qr.batch(insert_sql, params);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	
	@Override
	public User query(String name,String password) {
		String select_sql="select * from member where logname=? and password=?";
		User user=null;
		try {
			user = qr.query(select_sql,new BeanHandler<User>(User.class),name,password);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	@Test
	public List queryall() {
	String select_sql="select * from member ";
    List<User> users=null;
	try {
		users = qr.query(select_sql,new BeanListHandler<User>(User.class));
//		 for (User user : users) {
//				System.out.println(user);
//		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return users;
	}
	
	@Override
	public void insert() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void batch() {
		// TODO Auto-generated method stub
		
	}
//	@Override
//	public void query() {
//		// TODO Auto-generated method stub
//		
//	}
	
	@Override
	public void query() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User query(String username) {
		String select_sql="select * from member where logname=?";
		User user=null;
		try {
			user = qr.query(select_sql,new BeanHandler<User>(User.class),username);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int saveUser(String password) {
		String insert_sql="update member set password=?";
		int result=0;
		try {
			conn = DBUtil.getConnection();
			ps=conn.prepareStatement(insert_sql);
			ps.setString(1, password);
			result=ps.executeUpdate();
			System.out.println("插入数据成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int update(User user) {
		String update_sql="update member set password=? where logname=?";
		int result=0;
		
		try {
			result = qr.update(update_sql,new Object[] {user.getPassword(),user.getLogname()});
			System.out.println(result>0?"更新成功":"更新失败");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result; 
	}
	
}
