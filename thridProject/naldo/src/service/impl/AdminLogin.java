package service.impl;

import dao.AdminUserDAO;
import dao.impl.AdminUserDaoImpl;
import domain.AdminUser;
import service.LoginRegService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @auther:houkexin
 * @date: 2018/7/27
 * @description:
 * @version: 1.0
 */
public class AdminLogin implements LoginRegService {
    @Override
    public boolean dispose(HttpServletRequest request, HttpServletResponse response) {
        String adminName = request.getParameter("username");
        String pwd = request.getParameter("password");
        AdminUserDAO adminUserDAO = new AdminUserDaoImpl();
        HttpSession session = request.getSession();
        AdminUser adminUser = adminUserDAO.verifyLogin(adminName,pwd);
        //System.out.println(adminUser);
        if (adminUser != null){
            session.setAttribute("adminUser",adminUser);
            return true;
        }else {
            return false;
        }
    }
}
