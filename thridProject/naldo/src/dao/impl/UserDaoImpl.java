package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.UserDao;
import domain.User;
import util.C3P0Util;

public class UserDaoImpl implements UserDao{
	PreparedStatement ps;
	ResultSet rs;
	static Connection conn;
	static{
		try {
			conn=C3P0Util.getConn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public int saveUser(User user) {
		String select_sql="insert into user(userName,email,pwd,phone) values(?,?,?,?)";
		int result=0;
		try {
			ps=conn.prepareStatement(select_sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPwd());
			ps.setString(4, user.getPhone());
			result=ps.executeUpdate();
			System.out.println("插入user表成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	@Override
	public int updateUser(User user,int id) {
		String update_sql="update user set email=?,phone=? where id=?";
		int res=0;
		try {
			ps=conn.prepareStatement(update_sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPhone());
			ps.setInt(3,id);
			res=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		ps.setString(1, );
		return res;
	}
	@Override
	public User queryUser(int id) {
		String select_sql="select * from user where id=?";
		User user=new User();
		try {
			ps=conn.prepareStatement(select_sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()){
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	@Override
	public int identifyPassword(int id, String password) {
		String select_sql="select pwd from user where id=?";
		int res=0;
		try {
			ps=conn.prepareStatement(select_sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()){
				String pwd=rs.getString("pwd");
				if (pwd.equals(password)) {
					res=1;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("res="+res);
		return res;
	}
	@Override
	public int updatePassword(int id, String npassword) {
		//修改密码
		String update_sql="update user set pwd=? where id=?";
		int res=0;
		try {
			ps=conn.prepareStatement(update_sql);
			ps.setString(1, npassword);
			ps.setInt(2, id);
			res=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public boolean verifylogin(String username, String pwd) {
		boolean isSuccess = false;
		String sql = "SELECT * FROM userinfo WHERE userName =? AND pwd =?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,pwd);
            rs = ps.executeQuery();
            if (rs.next()){
                isSuccess = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSuccess;
	}
}
