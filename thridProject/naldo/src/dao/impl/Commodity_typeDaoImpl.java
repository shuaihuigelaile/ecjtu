package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import dao.Commodity_typeDao;
import domain.Commodity;
import domain.Commodity_type;
import util.C3P0Util;

public class Commodity_typeDaoImpl implements Commodity_typeDao {
	PreparedStatement ps;
	ResultSet rs;
	static Connection conn;
	static{
		try {
			conn = C3P0Util.getConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public int saveCommodity_type(String name) {
		String insert_sql="insert into commodity_type(type_name) values(?)";
		int result=0;
		try {
			ps=conn.prepareStatement(insert_sql);
			ps.setString(1, name);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public int updateCommodity_type(Commodity_type commodity_type) {
		String update_sql="update commodity_type set type_name=? where id=?";
		int result=0;
		try {
			ps=conn.prepareStatement(update_sql);
			ps.setString(1, commodity_type.getType_name());
			ps.setInt(2, commodity_type.getId());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteCommodity_type(int id) {
		String delete_sql="delete from commodity_type where id=?";
		int result=0;
		try {
			ps=conn.prepareStatement(delete_sql);
			ps.setInt(1, id);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Commodity_type> queryAllCommodity_type() {
		String select_sql="select id,type_name from commodity_type";
		List<Commodity_type> lists=new ArrayList<Commodity_type>();
		try {
			ps=conn.prepareStatement(select_sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Commodity_type commodity_type = new Commodity_type();
				commodity_type.setId(rs.getInt("id"));
				commodity_type.setType_name(rs.getString("type_name"));
				lists.add(commodity_type);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lists;
	}

	@Override
	public Commodity_type queryCommodity_type(int id) {
		String select_sql="select * from commodity_type where id=?";
		Commodity_type commodity_type = new Commodity_type();
		try {
			ps=conn.prepareStatement(select_sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()){
			commodity_type.setId(rs.getInt("id"));
			commodity_type.setType_name(rs.getString("type_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return commodity_type;
	}

	@Override
	public Commodity_type queryByName(String name){
		Commodity_type commodity_type = null;
		String sql = "select * from commodity_type where type_name=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            rs = ps.executeQuery();
            if (rs.next()){
                commodity_type = new Commodity_type();
                commodity_type.setId(rs.getInt(1));
                commodity_type.setType_name(rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return commodity_type;
	}
}
