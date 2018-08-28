package controller;

import java.io.IOException;
import java.io.PrintWriter;

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
import service.UserService;

@WebServlet("/UpdatePwdServlet")
public class UpdatePwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UpdatePwdServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//本servlet用来修改密码
		//获取当前操作用户id
		UserService service=UserFactory.getInstance("userservice", UserService.class);
		UserAndUserInfoService service2=UserFactory.getInstance("useranduserinfoservice", UserAndUserInfoService.class);

        HttpSession session = request.getSession();
       //User user1 = new User(1,"文建武","1333@qq.com","123456","18279905201");
        //session.setAttribute("user",user1);
		UserInfo user2 = (UserInfo) session.getAttribute("userInfo");
        int id = user2.getId();

		//原密码
		String pwd=request.getParameter("old_password");
		//要修改成新的密码
		String nPwd=request.getParameter("new_password");
		PrintWriter out=response.getWriter();
		//确认要修改成的新密码
		String sPwd=request.getParameter("comfirm_password");
		if (service.identifyPassword(id, pwd)) {
		    int i = service2.updateUserInfoAndUserPwd(id, sPwd);
		    if (i>0) {
		        user2.setPwd(sPwd);
                session.setAttribute("userInfo",user2);
				response.sendRedirect("userinfo.html");
		    }else {
		        out.print("update fail");
		    }
		}else {
			out.print("old password fail");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
