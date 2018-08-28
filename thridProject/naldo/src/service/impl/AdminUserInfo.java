package service.impl;

import domain.AdminUser;
import net.sf.json.JSONObject;
import service.Login_user_informationService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * @auther:houkexin
 * @date: 2018/7/27
 * @description:
 * @version: 1.0
 */
public class AdminUserInfo implements Login_user_informationService {
    @Override
    public JSONObject acquire(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        AdminUser adminUser = (AdminUser) session.getAttribute("adminUser");
        JSONObject json = new JSONObject();
        json.put("adminUser",adminUser);
        return json;
    }
}
