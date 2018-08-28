package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Commodity_ifoDao;
import domain.Commodity_ifo;
import util.C3P0Util;

public class Commodity_ifoDaoImpl implements Commodity_ifoDao {
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
	public List<Commodity_ifo> getAllCommodity_ifo() {
		List<Commodity_ifo> commodity_ifos=new ArrayList<>();
		String select_sql="select *from commodity_info";
		try {
			ps=conn.prepareStatement(select_sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Commodity_ifo commodity_ifo=new Commodity_ifo();
				commodity_ifo.setClarity(rs.getString("clarity"));
				commodity_ifo.setCommodity_color(rs.getString("commodity_color"));
				commodity_ifo.setCommodity_id(rs.getInt("commodity_id"));
				commodity_ifo.setCommodity_price(rs.getInt("comodity_price"));
				commodity_ifo.setCut(rs.getString("cut"));
				commodity_ifo.setId(rs.getInt("id"));
				commodity_ifo.setPolishing(rs.getString("polishing"));
				commodity_ifo.setQuantity_commodity(rs.getInt("quantity_commodity"));
				commodity_ifo.setStyle_no(rs.getString("style_no"));
				commodity_ifo.setSymmetry(rs.getString("symmetry"));
				commodity_ifos.add(commodity_ifo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commodity_ifos;
	}

	@Override
	public boolean add(Commodity_ifo commodity_ifo) {
		boolean isSuccess = false;
		String sql = "INSERT INTO commodity_ifo(commodity_id,style_no,commodity_price,quantity_commodity,commodity_color,clarity,cut,polishing,symmetry) VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            System.out.println(ps);
            ps.setInt(1,commodity_ifo.getCommodity_id());
            ps.setString(2,commodity_ifo.getStyle_no());
            ps.setDouble(3,commodity_ifo.getCommodity_price());
            ps.setInt(4,commodity_ifo.getQuantity_commodity());
            ps.setString(5,commodity_ifo.getCommodity_color());
            ps.setString(6,commodity_ifo.getClarity());
            ps.setString(7,commodity_ifo.getCut());
            ps.setString(8,commodity_ifo.getPolishing());
            ps.setString(9,commodity_ifo.getSymmetry());
            int count = ps.executeUpdate();
            System.out.println(count);
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
		boolean isSuccess = false ;
		String sql = "DELETE FROM commodity_ifo WHERE id = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
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
	public boolean update(Commodity_ifo commodity_ifo) {
		return false;
	}

	@Override
	public Commodity_ifo queryById(int id) {
        Commodity_ifo commodity_ifo = null;
        String sql = "SELECT * FROM commodity_ifo WHERE id = ? ";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if (rs.next()){
                commodity_ifo = new Commodity_ifo();
                commodity_ifo.setClarity(rs.getString(7));
                commodity_ifo.setCommodity_color(rs.getString(6));
                commodity_ifo.setCommodity_id(rs.getInt(2));
                commodity_ifo.setCommodity_price(rs.getDouble(4));
                commodity_ifo.setCut(rs.getString(8));
                commodity_ifo.setId(rs.getInt(1));
                commodity_ifo.setPolishing(rs.getString(9));
                commodity_ifo.setQuantity_commodity(rs.getInt(5));
                commodity_ifo.setStyle_no(rs.getString(3));
                commodity_ifo.setSymmetry(rs.getString(10));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commodity_ifo;
	}

	@Override
	public List<Commodity_ifo> queryByCommodityId(int commodityId) {
		return null;
	}

	@Override
	public Commodity_ifo queryByNoandId(int id, String no) {
		Commodity_ifo commodity_ifo = null;
		String sql = "SELECT * FROM commodity_ifo WHERE commodity_id = ? AND style_no = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.setString(2,no);
            rs = ps.executeQuery();
            if (rs.next()){
                commodity_ifo = new Commodity_ifo();
                commodity_ifo.setClarity(rs.getString(7));
                commodity_ifo.setCommodity_color(rs.getString(6));
                commodity_ifo.setCommodity_id(rs.getInt(2));
                commodity_ifo.setCommodity_price(rs.getDouble(4));
                commodity_ifo.setCut(rs.getString(8));
                commodity_ifo.setId(rs.getInt(1));
                commodity_ifo.setPolishing(rs.getString(9));
                commodity_ifo.setQuantity_commodity(rs.getInt(5));
                commodity_ifo.setStyle_no(rs.getString(3));
                commodity_ifo.setSymmetry(rs.getString(10));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commodity_ifo;
	}

}
