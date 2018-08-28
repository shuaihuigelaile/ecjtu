package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import dao.Commodity_property_typDao;
import domain.Commodity_property_type;

public class Commodity_property_typeDaoImpl implements Commodity_property_typDao {
PreparedStatement ps;
ResultSet rs;
static Connection conn;
	@Override
	public List<Commodity_property_type> getAllCommodity_propertype_type() {
		List<Commodity_property_type> commodity_property_types=new ArrayList<>();
		String select_sql="select *from commodity_peopertype_type";
		try {
			ps=conn.prepareStatement(select_sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Commodity_property_type commodity_property_type=new Commodity_property_type();
				commodity_property_type.setId(rs.getInt("id"));
				commodity_property_type.setName(rs.getString("name"));
				commodity_property_types.add(commodity_property_type);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return commodity_property_types;
	}

	@Override
	public Commodity_property_type queryById(int id) {
		Commodity_property_type commodity_property_type = null;
		String sql = "SELECT * FROM commodity_property_type WHERE id = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if (rs.next()){
                commodity_property_type = new Commodity_property_type();
                commodity_property_type.setId(rs.getInt(1));
                commodity_property_type.setName(rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commodity_property_type;
	}

}
