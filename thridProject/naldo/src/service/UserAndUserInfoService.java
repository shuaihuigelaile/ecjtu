package service;

import domain.User;
import domain.UserInfo;

public interface UserAndUserInfoService {
	//根据id更新用户表和用户信息表
	int updateUserInfoAndUser(UserInfo userInfo, User user, int id);
	//根据id更新用户表和用户表中的密码
	int updateUserInfoAndUserPwd(int id, String password);
}
