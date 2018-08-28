package dao.impl;

import dao.Trade_informationDao;
import domain.Trade_information;
import util.C3P0Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @auther:houkexin
 * @date: 2018/8/2
 * @description:
 * @version: 1.0
 */
public class Trade_informationDaoImpl implements Trade_informationDao {
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
    public boolean add(Trade_information information) {
        boolean isSuccess = false;
        String sql = "INSERT INTO trade_information(order_id,commodity_id,quantity,amount_payable) VALUES(?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,information.getOrder_id());
            ps.setInt(2,information.getCommodity_id());
            ps.setInt(3,information.getQuantity());
            ps.setDouble(4,information.getAmount_payable());
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
    public List<Trade_information> queryById(String id) {
        List<Trade_information> list = new ArrayList<>();
        Trade_information information = null;
        String sql = "SELECT * FROM trade_information WHERE order_id = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,id);
            rs = ps.executeQuery();
            while (rs.next()){
                information = new Trade_information();
                information.setId(rs.getInt(1));
                information.setOrder_id(rs.getString(2));
                information.setCommodity_id(rs.getInt(3));
                information.setQuantity(rs.getInt(4));
                information.setAmount_payable(rs.getDouble(5));
                list.add(information);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
