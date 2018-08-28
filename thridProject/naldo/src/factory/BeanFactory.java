package factory;

import java.util.ResourceBundle;

/**
 * 创建Dao或service工厂
 * 
 * @author Administrator
 *
 */
public class BeanFactory {

	// 加载配置文件
	private static ResourceBundle bundle;
	static {
		bundle = ResourceBundle.getBundle("instance");
	}

	/**
	 * 根据指定的key，读取配置文件获取类的全路径； 创建对象
	 * 
	 * @return
	 */
	public static <T> T getInstance(String key, Class<T> clazz) {
		String className = bundle.getString(key);
		try {
			return (T) Class.forName(className).newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
