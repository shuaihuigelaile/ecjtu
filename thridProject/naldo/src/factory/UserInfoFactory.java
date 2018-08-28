package factory;

import java.util.ResourceBundle;

public class UserInfoFactory {

	public static ResourceBundle bundle;
	static {
		bundle = ResourceBundle.getBundle("instance");
	}
	public static <T> T getInstance(String key, Class<T> classType)  {
		String className = bundle.getString(key);
		try {
			return (T) Class.forName(className).newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
