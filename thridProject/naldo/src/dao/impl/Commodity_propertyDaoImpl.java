package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Commodity_propertyDao;
import domain.Commodity_property;

public class Commodity_propertyDaoImpl implements Commodity_propertyDao {
	PreparedStatement ps;
	ResultSet rs;
	static Connection conn;
	@Override
	public List<Commodity_property> getAllcommodity_property() {
		List<Commodity_property> commodity_properties=new ArrayList<>();
		String select_sql="select *from commodity_properties";
		try {
			ps=conn.prepareStatement(select_sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Commodity_property commodity_property =new Commodity_property();
				commodity_property.setCommodity_info_Id(rs.getInt("commodity_info_Id"));
				commodity_property.setCommodity_property_id(rs.getInt("commodity_property_id"));
				commodity_property.setCommodity_property_value_id(rs.getInt("commodity_property_value_id"));
				commodity_properties.add(commodity_property);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return commodity_properties;
	}

	@Override
	public boolean add(Commodity_property commodity_property) {
		boolean isSuccess = false;
		String sql = "INSERT INTO commodity_property(commodity_info_Id,commodity_property_id,commodity_property_value_id) VALUES(?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,commodity_property.getCommodity_info_Id());
            ps.setInt(2,commodity_property.getCommodity_property_id());
            ps.setInt(3,commodity_property.getCommodity_property_value_id());
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
	public boolean update(Commodity_property commodity_property) {
		return false;
	}

	@Override
	public boolean delete(Commodity_property commodity_property) {
		return false;
	}

	@Override
	public Commodity_property queryById(int id) {
		return null;
	}

}
