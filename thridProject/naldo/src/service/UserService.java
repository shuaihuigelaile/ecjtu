package service;

import dao.UserDao;
import domain.User;
import factory.UserFactory;

public interface UserService {
	User queryUser(int id);
	//修改密码时确认输入的原密码是否正确
	boolean identifyPassword(int id, String password);
}
