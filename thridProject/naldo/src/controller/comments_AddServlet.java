package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Comments;
import domain.UserInfo;
import factory.BeanFactory;
import service.commentsService;
import service.impl.commentsServiceImpl;
import util.DBUtil;

/**
 * Servlet implementation class comments_AddServlet
 */
@WebServlet("/comments_AddServlet")
public class comments_AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public comments_AddServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		commentsService commentsServiceimpl=new commentsServiceImpl();
		Comments comment=new Comments();
		boolean b=false;
		HttpSession session = request.getSession();
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		int user_id=userInfo.getId(); //从前端获取
		int commodity_id=Integer.parseInt(request.getParameter("cmt_type"));
		Date date=new Date();
		String content=request.getParameter("content");//"你这个傻逼";
		if (content!=null&&!"".equals(comment)) {
			
			comment.setUser_id(user_id);
			comment.setCommodity_id(commodity_id);
			comment.setComments_time(date);
			comment.setComment_content(content);
			b=commentsServiceimpl.addcomments(comment);
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
