package service.impl;

import dao.UserDao;
import domain.User;
import factory.UserFactory;
import service.UserService;

public class UserServiceImpl implements UserService {
	UserDao dao=UserFactory.getInstance("userdaoimpl", UserDao.class);
	@Override
	public User queryUser(int id) {
		return dao.queryUser(id);
	}
	@Override
	public boolean identifyPassword(int id, String password) {
		boolean res=false;
		if (dao.identifyPassword(id, password)>0) {
			res=true;
		}
		return res;
	}
}
