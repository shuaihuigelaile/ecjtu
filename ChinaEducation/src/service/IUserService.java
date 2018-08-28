package service;

import entity.User;

import java.util.List;

public interface IUserService {
    int updateUser(User user);
    int deleteUserById(Integer id);
    User getUserById(Integer id);
    List<User> getUsers();
    //注册
    void register(User user);
    //登录
    boolean login(String username,String password);

    //获取所有的users
    List<User> findAllUsers();
    void deleteUserByUserId(Integer userId);

    //添加后台用户
    int addAdminUser(User user);
}
