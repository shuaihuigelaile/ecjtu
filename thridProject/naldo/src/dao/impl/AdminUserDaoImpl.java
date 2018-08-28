package dao.impl;

import dao.AdminUserDAO;
import domain.AdminUser;
import util.C3P0Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @auther:houkexin
 * @date: 2018/7/27
 * @description:
 * @version: 1.0
 */
public class AdminUserDaoImpl implements AdminUserDAO {
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
    public AdminUser verifyLogin(String name, String pwd) {
        //boolean isSuccess = false;
        AdminUser adminUser = null;
        String sql = "SELECT * FROM adminuser WHERE adminName = ? AND pwd = ?" ;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,pwd);
            rs = ps.executeQuery();
            if (rs.next()){
                adminUser = new AdminUser();
                adminUser.setId(rs.getInt(1));
                adminUser.setAdminName(rs.getString(2));
                adminUser.setPwd(rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return adminUser;
    }

    @Override
    public boolean add(AdminUser user) {
        return false;
    }
}
