package util;

import java.sql.SQLException;

import org.junit.Test;

public class TestDataSource {

	
	@Test
	public void testC3P0() {
		try {
			System.out.println(C3P0Util.getInstance().getConn());
			System.out.println("数据库连接成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
