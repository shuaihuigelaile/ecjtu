package service;

import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @auther:houkexin
 * @date: 2018/7/27
 * @description:
 * @version: 1.0
 */
public interface Login_user_informationService {
    public JSONObject acquire(HttpServletRequest request, HttpServletResponse response);
}
