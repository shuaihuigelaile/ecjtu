package service.impl;

import dao.UserDao;
import dao.UserInfoDao;
import domain.User;
import domain.UserInfo;
import factory.UserFactory;
import factory.UserInfoFactory;
import service.UserAndUserInfoService;

public class UserAndUserInfoServiceImpl implements UserAndUserInfoService {
		UserInfoDao dao=UserInfoFactory.getInstance("userinfodaoimpl", UserInfoDao.class);
		UserDao dao2=UserFactory.getInstance("userdaoimpl", UserDao.class);
		@Override
		public int updateUserInfoAndUser(UserInfo userInfo,User user,int id) {
			int res=0;
			int res1=0;
			int res2=0;
			//执行两次操作，对应的user表和userinfo表信息改变
			res1=dao.updateUserInfo(userInfo, id);
			res2=dao2.updateUser(user, id);
			if ((res1==1)&&(res2==1)) {
				res=1;
			}
			return res;
		}
		@Override
		public int updateUserInfoAndUserPwd(int id, String password) {
			int res=0;
			int res1;
			int res2;
			res1=dao.updatePassword(id, password);
			res2=dao2.updatePassword(id, password);
            System.out.println(res1);
            System.out.println(res2);
			if ((res1==1)&&(res2==1)) {
				res=1;
			}
			return res;
		}

}
