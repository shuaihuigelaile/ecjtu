package dao;

import domain.User;

public interface UserDao {
	public int saveUser(User user);
	public int updateUser(User user, int id);
	//根据id查询对应的user记录
	public User queryUser(int id);
	public int identifyPassword(int id, String password);
	
//修改密码
	public int updatePassword(int id, String npassword);
	public boolean verifylogin(String username, String pwd);
}
