package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.User;
import domain.UserInfo;
import factory.UserFactory;
import service.UserAndUserInfoService;
import service.UserInfoService;
import service.UserService;


@WebServlet("/UpdatePersonServlet")
public class UpdatePersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public UpdatePersonServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//修改信息
		UserInfoService service=UserFactory.getInstance("userinfoservice", UserInfoService.class);
		UserService service2=UserFactory.getInstance("userservice", UserService.class);
		UserAndUserInfoService service3=UserFactory.getInstance("useranduserinfoservice", UserAndUserInfoService.class);

		//session里获取当前信息（user对象）
		HttpSession session = request.getSession();
        UserInfo user2 = (UserInfo) session.getAttribute("userInfo");
		int id=user2.getId();
		String sex=request.getParameter("sex");
		String email=request.getParameter("email");
		String phone=request.getParameter("extend_field5");
		String idCard=request.getParameter("extend_field7");
        String name=request.getParameter("extend_field8");

		UserInfo userInfo=service.queryUserInfo(id);
		User user=service2.queryUser(id);


		userInfo.setSex(sex);
		userInfo.setEmail(email);
		userInfo.setPhone(phone);
		userInfo.setIdCard(idCard);
		userInfo.setName(name);

		user.setEmail(email);
		user.setPhone(phone);
		//将修改信息存入到user，userinfo两张表中
		int  res=service3.updateUserInfoAndUser(userInfo, user, id);
		PrintWriter out=response.getWriter();
		if (res>0) {
            session.setAttribute("userInfo",userInfo);
			response.sendRedirect("userinfo.html");
		}else {
			out.print("fa");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
