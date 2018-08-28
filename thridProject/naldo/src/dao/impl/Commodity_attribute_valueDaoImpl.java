package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import dao.Commodity_attribute_valueDao;
import domain.Commodity_attribute_value;
import util.C3P0Util;

public class Commodity_attribute_valueDaoImpl implements Commodity_attribute_valueDao {
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
	public List<Commodity_attribute_value> getAllCommodity_attribute_value() {
		List<Commodity_attribute_value> commodity_attribute_values=new ArrayList<>();
		String select_sql="select  *from commodity_attribute_value";
		try {
			ps=conn.prepareStatement(select_sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Commodity_attribute_value commodity_attribute_value=new Commodity_attribute_value();
				commodity_attribute_value.setCommodity_info_id(rs.getInt("commodity_info_id"));
				commodity_attribute_value.setId(rs.getInt("id"));
				commodity_attribute_value.setTexture(rs.getString("texture"));
				commodity_attribute_value.setSize(rs.getString("size"));
				commodity_attribute_value.setWeight(rs.getString("weight"));
				commodity_attribute_values.add(commodity_attribute_value);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return commodity_attribute_values;
	}

	@Override
	public boolean add(Commodity_attribute_value commodity_attribute_value) {
		boolean isSuccess = false;
		String sql = "INSERT INTO commodity_attribute_value(commodity_info_id,texture,size,weight) VALUES(?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,commodity_attribute_value.getCommodity_info_id());
            ps.setString(2,commodity_attribute_value.getTexture());
            ps.setString(3,commodity_attribute_value.getSize());
            ps.setString(4,commodity_attribute_value.getWeight());
            int count = ps.executeUpdate();
            if (count != 0){
                isSuccess = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSuccess;
	}

	@Override
	public boolean delete(int id) {
		return false;
	}

	@Override
	public boolean update(Commodity_attribute_value commodity_attribute_value) {
		return false;
	}

	@Override
	public Commodity_attribute_value queryById(int id) {
	    Commodity_attribute_value commodity_attribute_value = null;
	    String sql = "SELECT * FROM commodity_attribute_value WHERE id = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if (rs.next()){
                commodity_attribute_value = new Commodity_attribute_value();
                commodity_attribute_value.setId(rs.getInt(1));
                commodity_attribute_value.setCommodity_info_id(rs.getInt(2));
                commodity_attribute_value.setTexture(rs.getString(3));
                commodity_attribute_value.setSize(rs.getString(4));
                commodity_attribute_value.setWeight(rs.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commodity_attribute_value;
	}

}
