package dao;





import domain.UserInfo;

public interface UserInfoDao {
	public int saveUserInfo(UserInfo userinfo);
	public UserInfo query(String username);
	public int query(String name, String pwd);
	//public boolean query(int)
	public UserInfo queryUserInfo(int id);


	//根据用户名改一条记录
	public int updateUserInfo(UserInfo userInfo, int id);
	//修改密码
	public int updatePassword(int id, String npassword);
}
