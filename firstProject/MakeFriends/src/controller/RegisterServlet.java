package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.impl.UserFactory;
import pojo.User;
//@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
		 * Constructor of the object.
		 */
	public RegisterServlet() {
		super();
	}

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建dao实例
		try {
			UserDao dao=UserFactory.getInstance("userdaoimpl", UserDao.class);
			String name=request.getParameter("logname");
			String pwd=request.getParameter("password");
			String tel=request.getParameter("telephone");
			String email=request.getParameter("email");
			String information=request.getParameter("information");
			String pictname=request.getParameter("picturename");
			User  user=new User(name,pwd,tel,email,information,pictname);
			int res = dao.saveUser(user);
			System.out.println(res);
			if (res==0) {
				response.sendRedirect(request.getContextPath()+"/view"+"/login.jsp");
			}else {
				String dir="view";
				//request.getRequestDispatcher(dir+"/register.jsp").forward(request, response);
				response.sendRedirect(dir+"/register.jsp");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
