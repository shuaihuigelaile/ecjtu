package dao;

import entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    // 查询所有用户信息
    List<User> getUsers();
    // 查询某个用户
    User getUserById(Integer id);
    // 删除用户
    int deleteUserById(Integer id);
    // 修改
    int updateUser(User user);
    //添加用户
    void addUser(User user);
    //实现登录
    User findUserByNameAndPwd(@Param("username") String username,@Param("password") String password);

    //获取所有的users
    List<User> findAllUsers();

    void deleteUserByUserId(Integer userId);

    //添加后台用户
    int addAdminUser(User user);
}
