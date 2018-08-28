package dao.impl;

import dao.AddressDao;
import domain.Address;
import util.C3P0Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @auther:houkexin
 * @date: 2018/8/1
 * @description:
 * @version: 1.0
 */
public class AddressDaoImpl implements AddressDao {
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
    public boolean add(Address address) {
        boolean isSuccess = false;
        String sql = "INSERT INTO address(user_id,address,zip_code,consignee_name,consignee_phone) VALUES(?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,address.getUser_id());
            ps.setString(2,address.getAddress());
            ps.setString(3,address.getZip_code());
            ps.setString(4,address.getConsignee_name());
            ps.setString(5,address.getConsignee_phone());
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
    public boolean update(Address address) {
        boolean isSuccess = false;
        String sql = "UPDATE address SET address = ? ,zip_code = ?, consignee_name = ?,consignee_phone =? WHERE user_id = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,address.getAddress());
            ps.setString(2,address.getZip_code());
            ps.setString(3,address.getConsignee_name());
            ps.setString(4,address.getConsignee_phone());
            ps.setInt(5,address.getUser_id());
            int count  = ps.executeUpdate();
            if (count != 0){
                isSuccess = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
    @Override
    public Address queryById(int id) {
        Address address = null;
        String sql = "SELECT * FROM address WHERE user_id = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if (rs.next()){
                address = new Address();
                address.setAddress_Id(rs.getInt(1));
                address.setUser_id(rs.getInt(2));
                address.setAddress(rs.getString(3));
                address.setZip_code(rs.getString(4));
                address.setConsignee_name(rs.getString(5));
                address.setConsignee_phone(rs.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return address;
    }
}
