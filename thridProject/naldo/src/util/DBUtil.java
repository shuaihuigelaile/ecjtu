package util;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

public class DBUtil {

    private static DBUtil dbUtil = new DBUtil();
    private  Properties prop = new Properties();
    private static DataSource ds;

    private DBUtil(){
        try {
            prop.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
            ds = BasicDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DBUtil getDbUtil(){
        return dbUtil;
    }
    public static DataSource getDs() {
		return ds;
	}
    public Connection getConnection() {

        Connection conn = null;
        try {
            conn = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public String getOrder_no() {
    	  Date date=new Date();
		  SimpleDateFormat sf=new SimpleDateFormat("YYYYMMddHHmm");
		  System.out.println();
		  Random random=new Random();
		  String num;
		  int i=random.nextInt(100);
		  if (i<10) {
			 num="0"+Integer.toString(i);
		   }else{
			 num=Integer.toString(i); 
		   }	
	      return sf.format(date)+num;
    }
    public Date getDate() {
    	Date date=new Date();
    	SimpleDateFormat sf=new SimpleDateFormat("YYYY-MM-dd  HH:mm:ss");
    	try {
			 date=sf.parse(sf.format(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
}
