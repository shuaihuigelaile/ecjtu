package dao.impl;

import java.util.ResourceBundle;

/**
 * @author : yyh
 * @date ����ʱ�䣺2018��7��6�� ����10:52:07
 * @version 1.0
 */
public class UserFactory {

	public static ResourceBundle bundle;
	static {
		//Ĭ�ϻ�ȡsrc��Դ�ļ���xxx.properties
		//�����ļ�����ȡ
		bundle = ResourceBundle.getBundle("instance");
	}

	/**
	 * �����������͵Ķ��� * @param key
	 * 
	 * @param classType
	 * @return
	 * @throws ClassNotFoundException
	 */
	public static <T> T getInstance(String key, Class<T> classType) throws ClassNotFoundException {
		//����Key��ȡvalues
		String className = bundle.getString(key);
		try {
			return (T) Class.forName(className).newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
