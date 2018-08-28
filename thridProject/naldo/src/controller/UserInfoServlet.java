package controller;

import net.sf.json.JSONObject;
import service.Login_user_informationService;
import service.impl.AdminUserInfo;
import service.impl.UserInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @auther:houkexin
 * @date: 2018/7/27
 * @description:
 * @version: 1.0
 */
@WebServlet( "/userInfoServlet")
public class UserInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        PrintWriter pw = response.getWriter();
        if (type.equals("user")){
            Login_user_informationService userinfo = new UserInfoService();
            JSONObject json = userinfo.acquire(request,response);
            pw.print(json.toString());
        }else if (type.equals("adminUser")){
            Login_user_informationService adminUser = new AdminUserInfo();
            JSONObject json = adminUser.acquire(request,response);
            pw.print(json.toString());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
