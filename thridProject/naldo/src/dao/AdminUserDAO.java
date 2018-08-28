package dao;

import domain.AdminUser;
import domain.User;

/**
 * @auther:houkexin
 * @date: 2018/7/27
 * @description:
 * @version: 1.0
 */
public interface AdminUserDAO {
    public AdminUser verifyLogin(String name, String pwd);
    public boolean add(AdminUser user);
}
