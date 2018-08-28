package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import dao.Commodity_imagesDao;
import domain.Commodity_images;
import util.C3P0Util;

public class Commodity_imagesDaoImpl implements Commodity_imagesDao {
    PreparedStatement ps;
    ResultSet rs;
    static java.sql.Connection conn;
    static{
        try {
            conn=C3P0Util.getConn();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	public List<Commodity_images> getAllCommodity_image() {
		List<Commodity_images> commodity_images=new ArrayList<>();
		String select_sql="select *from commodity_image";
		try {
			ps=conn.prepareStatement(select_sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Commodity_images commodity_images2 = new Commodity_images();
				commodity_images2.setCommodity_id(rs.getInt("commodity_id"));
				commodity_images2.setId(rs.getInt("ID"));
				commodity_images2.setPath(rs.getString("path"));
				commodity_images.add(commodity_images2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return commodity_images;
	}

	@Override
	public boolean add(Commodity_images images) {
		boolean isSuccess = false;
		String sql = "INSERT INTO commodity_images(commodity_id,path) VALUES(?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,images.getCommodity_id());
            ps.setString(2,images.getPath());
            int count = ps.executeUpdate();
            if (count != 0){
                isSuccess  = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return isSuccess;
	}

}
