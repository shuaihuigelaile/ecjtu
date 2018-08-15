package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

/** 
* @author : yyh
* @date 创建时间：2018年7月6日 上午10:28:50 
* @version 1.0 
*/
public class DBUtil {
	public static Properties properties=new Properties();
	public static String driver;
	public static String url;
	public static String username;
	public static String password;
	static {
		try {
			//加载配置文件
			properties.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
		    driver=properties.getProperty("driver");
		    url=properties.getProperty("url");
		    username=properties.getProperty("username");
		    password=properties.getProperty("password");
		   Class.forName(driver);
		} catch (IOException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection () throws SQLException {
		Connection conn=DriverManager.getConnection(url,username,password);
		return conn;
	}
	
	
	public int update(String sql,Object[]...params) {
		//sql insert into xxx(字段1，字段2，字段3) values(?,?,?)
		//update xxx set 字段1=？，字段2=？ where  id=?
		PreparedStatement ps;
		int result=0;
		try {
			ps = getConnection().prepareStatement(sql);
			for(int i=0;i<params.length;i++) {
				ps.setObject((i+1), params[i]);
			}
			result=ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return result;
	}

}
