package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import dao.impl.UserFactory;
import pojo.User;

/**
 * Servlet implementation class UpdatePasswordServlet
 */
@WebServlet("/Update")
public class UpdatePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String username=(String) session.getAttribute("loginName");
		System.out.println(username);
		String oldpassword=request.getParameter("oldpassword");
		System.out.println(oldpassword);
		String newpassword=request.getParameter("newpassword");
		System.out.println(newpassword);
		PrintWriter out = response.getWriter();
		try {
			UserDao dao = UserFactory.getInstance("userdaoimpl", UserDao.class);
			User user = dao.query(username);
			if (user.getPassword().equals(oldpassword)) {
					user.setPassword(newpassword);
					dao.update(user);
					out.print("密码修改成功");
					response.sendRedirect("view/index.jsp");
			}else {
				out.print("请输入正确的原密码");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
