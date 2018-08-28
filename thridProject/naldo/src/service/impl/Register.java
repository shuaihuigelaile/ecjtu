package service.impl;

import dao.UserDao;
import dao.UserInfoDao;
import domain.User;
import domain.UserInfo;
import factory.UserFactory;
import factory.UserInfoFactory;
import service.LoginRegService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @auther:houkexin
 * @date: 2018/7/26
 * @description:
 * @version: 1.0
 */
public class Register implements LoginRegService {
    @Override
    public boolean dispose(HttpServletRequest request, HttpServletResponse response) {
        boolean isSuccess = false;
        String type = request.getParameter("reg_type");
        UserInfoDao userInfoDao=UserInfoFactory.getInstance("userinfodaoimpl", UserInfoDao.class);
        UserDao userDao = UserFactory.getInstance("userdaoimpl", UserDao.class);
        String userName=request.getParameter("username");
        String pwd=request.getParameter("password");
        String idCard=request.getParameter("extend_field7");
        String name=request.getParameter("extend_field8");
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userName);
        userInfo.setPwd(pwd);
        userInfo.setName(name);
        userInfo.setIdCard(idCard);
        User user = new User();
        user.setUserName(userName);
        user.setPwd(pwd);
        if (type.equals("email")){
            String email=request.getParameter("email");
            userInfo.setEmail(email);
            if (userInfoDao.saveUserInfo(userInfo) != 0){
                //userDao.saveUser(user);
                userInfo = userInfoDao.query(userName);
                user.setId(userInfo.getId());
                user.setEmail(email);
                userDao.saveUser(user);
                isSuccess = true;
            }
        }else if (type.equals("mobile")){
            String phone = request.getParameter("extend_field5");
            userInfo.setPhone(phone);
            if (userInfoDao.saveUserInfo(userInfo) != 0){
                //userDao.saveUser(user);
                userInfo = userInfoDao.query(userName);
                user.setId(userInfo.getId());
                user.setPhone(phone);
                userDao.saveUser(user);
                isSuccess = true;
            }
        }
        return isSuccess;
    }
}
