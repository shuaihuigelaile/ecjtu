package dao.impl;

import dao.Shopping_trolleyDao;
import domain.Commodity_ifo;
import domain.Shopping_trolley;
import util.C3P0Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TrolleyDaoImpl implements Shopping_trolleyDao {

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
    public boolean addTrolley(Shopping_trolley stObject) {
        boolean flag = false;
        //conn = DBUtil.getDbUtil().getConnection();
        String sql = "insert into shopping_trolley (user_id,commodity_id,shopping_quantity) values (?,?,?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,stObject.getUser_id());
            ps.setInt(2,stObject.getCommodity_id());
            ps.setInt(3,stObject.getShopping_quantity());


            int rs = ps.executeUpdate();
            if(rs == 1){
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
    public int selectTrolley(int user_id,int commodity_id){
        int count = 0;
        //conn = DBUtil.getDbUtil().getConnection();
        String sql = "select * from shopping_trolley where user_id=? and commodity_id=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,user_id);
            ps.setInt(2,commodity_id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                count = rs.getInt("shopping_quantity");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    public boolean update(Shopping_trolley stObject){

        boolean flag = false;
        //conn = DBUtil.getDbUtil().getConnection();
        String sql_up = "update shopping_trolley set shopping_quantity=? where user_id=? and commodity_id=?";
        try {
            ps = conn.prepareStatement(sql_up);
            ps.setInt(1,stObject.getShopping_quantity());
            ps.setInt(2,stObject.getUser_id());
            ps.setInt(3,stObject.getCommodity_id());
            int rs = ps.executeUpdate();
            if(rs == 1){
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public Collection showAll(int userInfoId) {
        //conn = DBUtil.getDbUtil().getConnection();
        String sql = "select * from shopping_trolley where user_id="+userInfoId;
        int comm;
        int count;
        List list = new ArrayList();
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                comm = rs.getInt("commodity_id");
                list.add(comm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Commodity_ifo getInfo(int id) {
        Commodity_ifo ci = new Commodity_ifo();
        //conn = DBUtil.getDbUtil().getConnection();
        String sql = "select * from Commodity_ifo where id="+id;
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                ci.setId(rs.getInt("id"));
                ci.setCommodity_id(rs.getInt("commodity_id"));
                ci.setStyle_no(rs.getString("style_no"));
                ci.setCommodity_price(rs.getDouble("commodity_price"));
                ci.setQuantity_commodity(rs.getInt("quantity_commodity"));
                ci.setCommodity_color(rs.getString("commodity_color"));
                ci.setClarity(rs.getString("clarity"));
                ci.setCut(rs.getString("cut"));
                ci.setPolishing(rs.getString("polishing"));
                ci.setSymmetry(rs.getString("symmetry"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ci;
    }
    @Override
    public boolean delete(int id,int commdityId) {
        boolean flag = false;
        //conn = DBUtil.getDbUtil().getConnection();
        String sql = "DELETE FROM shopping_trolley where user_id=? and commodity_id=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.setInt(2,commdityId);
            int rs = ps.executeUpdate();
            if (rs != 0){
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
    @Override
    public boolean insert(int comId, String path) {
        boolean flag = false;
        //conn = DBUtil.getDbUtil().getConnection();
        String sql = "insert into commodity_images (commodity_id,path)values (?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,comId);
            ps.setString(2,path);
            int rs = ps.executeUpdate();
            if (rs == 1){
                flag = true;
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
