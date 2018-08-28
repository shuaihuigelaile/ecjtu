package controller;

import service.LoginRegService;
import service.impl.AdminLogin;
import service.impl.Login;
import service.impl.Register;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @auther:houkexin
 * @date: 2018/7/26
 * @description:
 * @version: 1.0
 */
@WebServlet("/loginRegister")
public class LoginRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        if (type.equals("login")){
            LoginRegService login = new Login();
            if(login.dispose(request,response)){
                response.sendRedirect("index.html");
            }else {
                response.sendRedirect("login.html");
            }
        }else if (type.equals("register")){
            LoginRegService register = new Register();
            if (register.dispose(request,response)){
                response.sendRedirect("login.html");
            }else {
                response.sendRedirect("register.html");
            }
        }else if (type.equals("adminLogin")){
            LoginRegService adminLogin = new AdminLogin();
            if (adminLogin.dispose(request,response)){
                response.sendRedirect("X-admin/index.html");
            }else {
                response.sendRedirect("X-admin/login.html");
            }
        }
    }
}
