package dao.impl;

import java.util.ResourceBundle;

/**
 * @author : yyh
 * @date 创建时间：2018年7月6日 上午10:52:07
 * @version 1.0
 */
public class UserFactory {

	public static ResourceBundle bundle;
	static {
		//默认获取src资源文件，xxx.properties
		//根据文件名获取
		bundle = ResourceBundle.getBundle("instance");
	}

	/**
	 * 构造任意类型的对象 * @param key
	 * 
	 * @param classType
	 * @return
	 * @throws ClassNotFoundException
	 */
	public static <T> T getInstance(String key, Class<T> classType) throws ClassNotFoundException {
		//根据Key获取values
		String className = bundle.getString(key);
		try {
			return (T) Class.forName(className).newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
