package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import dao.impl.UserFactory;
import pojo.User;
//@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public LoginServlet() {
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
		
		try {
			UserDao dao=UserFactory.getInstance("userdaoimpl", UserDao.class);
			System.out.println(dao);
			String name=request.getParameter("username");
			String pwd=request.getParameter("password");
			System.out.println(name+pwd);
			User user = dao.query(name,pwd);
			System.out.println(user);
			if (user!=null) {
				HttpSession session = request.getSession();
				session.setAttribute("loginName", name);
				String dir="view";
				System.out.println(request.getContextPath());
				request.getRequestDispatcher(dir+"/index.jsp").forward(request, response);
				//response.sendRedirect(request.getContextPath()+"/view"+"/index.jsp");
			}else {
				//response.sendRedirect("view"+"/login.jsp");
				System.out.println(request.getContextPath());
				response.sendRedirect(request.getContextPath()+"/view"+"/login.jsp");
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
