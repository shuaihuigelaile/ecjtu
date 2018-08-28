package service.impl;

import dao.UserDao;
import dao.UserInfoDao;
import dao.impl.UserDaoImpl;
import dao.impl.UserInfoDaoImpl;
import domain.User;
import domain.UserInfo;
import factory.UserFactory;
import service.LoginRegService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @auther:houkexin
 * @date: 2018/7/26
 * @description:
 * @version: 1.0
 */
public class Login implements LoginRegService {
    @Override
    public boolean dispose(HttpServletRequest request, HttpServletResponse response) {
        boolean isSuccess = false;
        UserDao userDao = UserFactory.getInstance("userdaoimpl", UserDao.class);
        String userName = request.getParameter("username");
        String pwd = request.getParameter("password");
        String type = request.getParameter("login_type");
        UserInfo user = new UserInfo();
        if (type.equals("normal")){
            if (userDao.verifylogin(userName,pwd)){
                UserInfoDao userInfoDao = new UserInfoDaoImpl();
                user = userInfoDao.query(userName);
                HttpSession session = request.getSession();
                session.setAttribute("userInfo",user);
                isSuccess = true;
            }
        }
        return isSuccess;
    }
}
