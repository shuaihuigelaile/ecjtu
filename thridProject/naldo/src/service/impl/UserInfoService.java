package service.impl;

import domain.AdminUser;
import domain.UserInfo;
import net.sf.json.JSONObject;
import service.Login_user_informationService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @auther:houkexin
 * @date: 2018/8/2
 * @description:
 * @version: 1.0
 */
public class UserInfoService implements Login_user_informationService {
    @Override
    public JSONObject acquire(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        JSONObject json = new JSONObject();
        json.put("userInfo",userInfo);
        return json;
    }
}
