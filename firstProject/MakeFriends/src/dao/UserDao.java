package dao;

import java.util.List;

import pojo.User;

public interface UserDao {
	public int saveUser(User user);
	public void insert();
	public int update(User user);
	public void delete();
	public void batch();
	public void query();
	public List queryall();
	public User query(String name,String password);
	public User query(String password);
	public int saveUser(String password);
}
