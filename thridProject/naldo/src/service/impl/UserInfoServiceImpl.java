package service.impl;

import dao.UserDao;
import dao.UserInfoDao;
import domain.User;
import domain.UserInfo;
import factory.UserFactory;
import factory.UserInfoFactory;
import service.UserInfoService;

public class UserInfoServiceImpl implements UserInfoService {
	UserInfoDao dao=UserInfoFactory.getInstance("userinfodaoimpl", UserInfoDao.class);
	@Override
	public UserInfo queryUserInfo(int id) {
		return dao.queryUserInfo(id);
	}
	
	
}
