package service.impl;

import dao.UserMapper;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.IUserService;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int deleteUserById(Integer id) {
        return userMapper.deleteUserById(id);
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    @Override
    public List<User> getUsers() {
        return userMapper.getUsers();
    }

    @Override
    public void register(User user) {
        userMapper.addUser(user);
    }

    @Override
    public boolean login(String username, String password) {
        if ( userMapper.findUserByNameAndPwd(username,password)==null){
            return false;
        }
        return true;
    }

    @Override
    public List<User> findAllUsers() {
        return userMapper.findAllUsers();
    }

    @Override
    public void deleteUserByUserId(Integer userId) {
        userMapper.deleteUserByUserId(userId);
    }

    @Override
    public int addAdminUser(User user) {
        System.out.println("进入了addAdminUser的方法");
       return userMapper.addAdminUser(user);
    }
}
