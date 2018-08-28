package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.UserInfoDao;
import domain.UserInfo;

import util.C3P0Util;

public class UserInfoDaoImpl implements UserInfoDao {
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
	public int saveUserInfo(UserInfo userinfo) {
		String insert_sql="insert into userinfo(userName,email,pwd,phone,idCard,compellation,sex) values(?,?,?,?,?,?,?)";
		int result=0;
		try {
			ps=conn.prepareStatement(insert_sql);
			ps.setString(1, userinfo.getUserName());
			ps.setString(2, userinfo.getEmail());
			ps.setString(3, userinfo.getPwd());
			ps.setString(4, userinfo.getPhone());
			ps.setString(5, userinfo.getIdCard());
			ps.setString(6, userinfo.getName());
			ps.setString(7, userinfo.getSex());
			
			result=ps.executeUpdate();
			System.out.println("插入成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public UserInfo query(String username) {
		String select_sql = "select * from userinfo where userName=?";
		UserInfo userInfo= null;
		try {
			ps=conn.prepareStatement(select_sql);
			ps.setString(1, username);
			rs=ps.executeQuery();
			if (rs.next()){
				userInfo =new UserInfo();
				userInfo.setId(rs.getInt("id"));
				userInfo.setUserName(rs.getString("userName"));
				userInfo.setEmail(rs.getString("email"));
				userInfo.setPwd(rs.getString("pwd"));
				userInfo.setPhone(rs.getString("phone"));
				userInfo.setIdCard(rs.getString("idCard"));
				userInfo.setName(rs.getString("compellation"));
				userInfo.setSex(rs.getString("sex"));
				userInfo.setDate_birth(rs.getDate("date_birth"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userInfo;
	}
	@Override
	public int query(String value, String pwd) {
		String select_sql="select * from userinfo where (userName=? or email=? or phone=?) and pwd=?";
		int res=0;
		UserInfo userInfo = null;
		try {
			ps=conn.prepareStatement(select_sql);
			ps.setString(1, value);
			ps.setString(2, value);
			ps.setString(3, value);
			ps.setString(4, pwd);
			rs=ps.executeQuery();
			System.out.println(value);
			if (rs.next()) {
				res=1;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public UserInfo queryUserInfo(int id) {
		String select_sql="select * from userinfo where id=?";
		UserInfo userInfo=new UserInfo();
		try {
			ps=conn.prepareStatement(select_sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()){
				userInfo.setUserName(rs.getString("userName"));
				userInfo.setEmail(rs.getString("email"));
				userInfo.setPwd(rs.getString("pwd"));
				userInfo.setPhone(rs.getString("phone"));
				userInfo.setIdCard(rs.getString("idCard"));
				userInfo.setName(rs.getString("compellation"));
				userInfo.setSex(rs.getString("sex"));
				userInfo.setDate_birth(rs.getDate("date_birth"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userInfo;
	}

	@Override
	public int updateUserInfo(UserInfo userInfo,int id) {
		//根据所传的用户名更改对应的用户信息表
		String update_sql="update userinfo set compellation=?,phone=?,email=?,sex=? where id=?";
		int res=0;
		System.out.println("come on 2");
		try {
			ps=conn.prepareStatement(update_sql);
			ps.setString(1, userInfo.getName());
			ps.setString(2, userInfo.getPhone());
			ps.setString(3, userInfo.getEmail());
			ps.setString(4,userInfo.getSex());
			ps.setInt(5, id);
			res=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(res);
		return res;
	}

	@Override
	public int updatePassword(int id, String npassword) {
        String update_sql = "update userinfo set pwd=? where id=?";
        int res = 0;
        try {
            ps = conn.prepareStatement(update_sql);
            ps.setString(1, npassword);
            ps.setInt(2, id);
            res = ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return res;
    }
	
}
