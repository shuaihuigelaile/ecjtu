package service;

import domain.User;
import domain.UserInfo;

public interface UserInfoService {
	//根据用户id查询用户信息表
	UserInfo queryUserInfo(int id);
}
