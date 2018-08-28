package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * �ṩ��ȡ���ӹ�������
 * 
 * @author Administrator
 *
 */

public class C3P0Util {
	private static C3P0Util instance = new C3P0Util();
	private static DataSource ds = new ComboPooledDataSource();

	private C3P0Util() {

	}

	// �����ṩʵ���ķ���
	public static C3P0Util getInstance() {
		return instance;
	}

	public static Connection getConn() throws SQLException {
		return ds.getConnection();
	}
	public static DataSource getDataSource(){
		return ds;
	}
	
	public static void release(Connection conn, Statement stmt, ResultSet rs) {
		// �ر���Դ
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		if (conn != null) {
			try {
				conn.close();// �ر�
			} catch (Exception e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}

}
