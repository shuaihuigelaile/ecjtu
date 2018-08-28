package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CommodityDao;
import domain.Commodity;
import domain.CommodityAllInfo;
import util.C3P0Util;

public class CommodityDaoImpl implements CommodityDao {
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
	public List<Commodity> getAllCommodity() {
		
		
		List<Commodity> commodities=new ArrayList<>() ;
		String select_sql="select *from Commodity";
		try {
			ps=conn.prepareStatement(select_sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Commodity commodity=new Commodity();
				commodity.setType_id(rs.getInt("Type_id"));
				commodity.setId(rs.getInt("id"));
				commodity.setCommodity_name(rs.getString("commodity_name"));
				commodity.setCommodity_introduction(rs.getString("commodity_introduction"));
				commodities.add(commodity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return commodities;
		}

	@Override
	public boolean add(Commodity commodity) {
		boolean isSuccess = false;
		String sql = "INSERT INTO commodity(type_id,commodity_name,commodity_introduction) VALUES(?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,commodity.getType_id());
            ps.setString(2,commodity.getCommodity_name());
            ps.setString(3,commodity.getCommodity_introduction());
            int rs = ps.executeUpdate();
            if (rs != 0){
                isSuccess = true ;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSuccess;
	}

	@Override
	public boolean update(Commodity commodity) {
		return false;
	}

	@Override
	public Commodity queryById(int id) {
		return null;
	}

	@Override
	public boolean delete(int id) {
		return false;
	}

	@Override
	public List<CommodityAllInfo> queryAll() {
    	List<CommodityAllInfo> list = new ArrayList<>();
        String sql  = "SELECT * FROM  commodity,commodity_ifo,commodity_attribute_value,commodity_images,commodity_type " +
                "                WHERE commodity.type_id = commodity_type.id AND commodity_ifo.commodity_id = commodity.id AND " +
                "                commodity_ifo.id = commodity_attribute_value.commodity_info_id AND commodity_ifo.id = commodity_images.commodity_id;" ;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                CommodityAllInfo commodityAllInfo = new CommodityAllInfo();
                commodityAllInfo.setId(rs.getInt("commodity_id"));
                commodityAllInfo.setName(rs.getString("commodity_name"));
                commodityAllInfo.setType_id(rs.getInt("type_id"));
                commodityAllInfo.setType_name(rs.getString("type_name"));
                commodityAllInfo.setIntroduction(rs.getString("commodity_introduction"));
                commodityAllInfo.setCommodityinfo_id(rs.getInt("commodity_info_id"));
                commodityAllInfo.setStyle_no(rs.getString("style_no"));
                commodityAllInfo.setPrice(rs.getDouble("commodity_price"));
                commodityAllInfo.setQuantity(rs.getInt("quantity_commodity"));
                commodityAllInfo.setColor(rs.getString("commodity_color"));
                commodityAllInfo.setClarity(rs.getString("clarity"));
                commodityAllInfo.setCut(rs.getString("cut"));
                commodityAllInfo.setPolishing(rs.getString("polishing"));
                commodityAllInfo.setSymmetry(rs.getString("symmetry"));
                commodityAllInfo.setWeight(rs.getString("weight"));
                commodityAllInfo.setSize(rs.getString("size"));
                commodityAllInfo.setTexture(rs.getString("texture"));
                commodityAllInfo.setImgPath(rs.getString("path"));
                list.add(commodityAllInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
	}

    @Override
    public Commodity queryByName(String name) {
        Commodity commodity = null;
        String sql = "SELECT * FROM commodity WHERE commodity_name = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            rs = ps.executeQuery();
            if (rs.next()){
                commodity = new Commodity();
                commodity.setId(rs.getInt(1));
                commodity.setType_id(rs.getInt(2));
                commodity.setCommodity_name(rs.getString(3));
                commodity.setCommodity_introduction(rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commodity;
    }

    @Override
    public CommodityAllInfo queryAllInfoById(int id) {
        CommodityAllInfo commodityAllInfo = null;
        String sql  = "SELECT * FROM  commodity,commodity_ifo,commodity_attribute_value,commodity_images,commodity_type " +
                "                WHERE commodity.type_id = commodity_type.id AND commodity_ifo.commodity_id = commodity.id AND " +
                "                commodity_ifo.id = commodity_attribute_value.commodity_info_id AND commodity_ifo.id = commodity_images.commodity_id and commodity_ifo.id= ?;" ;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if (rs.next()){
                commodityAllInfo = new CommodityAllInfo();
                commodityAllInfo.setId(rs.getInt("commodity_id"));
                commodityAllInfo.setName(rs.getString("commodity_name"));
                commodityAllInfo.setType_id(rs.getInt("type_id"));
                commodityAllInfo.setType_name(rs.getString("type_name"));
                commodityAllInfo.setIntroduction(rs.getString("commodity_introduction"));
                commodityAllInfo.setCommodityinfo_id(rs.getInt("commodity_info_id"));
                commodityAllInfo.setStyle_no(rs.getString("style_no"));
                commodityAllInfo.setPrice(rs.getDouble("commodity_price"));
                commodityAllInfo.setQuantity(rs.getInt("quantity_commodity"));
                commodityAllInfo.setColor(rs.getString("commodity_color"));
                commodityAllInfo.setClarity(rs.getString("clarity"));
                commodityAllInfo.setCut(rs.getString("cut"));
                commodityAllInfo.setPolishing(rs.getString("polishing"));
                commodityAllInfo.setSymmetry(rs.getString("symmetry"));
                commodityAllInfo.setWeight(rs.getString("weight"));
                commodityAllInfo.setSize(rs.getString("size"));
                commodityAllInfo.setTexture(rs.getString("texture"));
                commodityAllInfo.setImgPath(rs.getString("path"));
                //list.add(commodityAllInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commodityAllInfo;
    }
/*public static void main(String[] args) {
	CommodityDaoImpl commodityDao=new CommodityDaoImpl();
	System.out.println("========"+commodityDao.getAllCommodity());
	Commodity commodity =new commodity(1, 2, "hello", "hello");
	System.out.println(commodity);
	List<Commodity> num=commodityDao.getAllCommodity();
	System.out.println("num="+num);
}*/
}
