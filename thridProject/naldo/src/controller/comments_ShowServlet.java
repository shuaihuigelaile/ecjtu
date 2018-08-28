package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Comments;
import factory.BeanFactory;
import net.sf.json.JSONObject;
import service.commentsService;
import service.impl.commentsServiceImpl;

/**
 * Servlet implementation class comments_ShowServlet
 */
@WebServlet("/comments_ShowServlet")
public class comments_ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public comments_ShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		commentsService commentsServiceimpl=new commentsServiceImpl();
		List<Comments> comments=null;
		final int PAGESIZE=10;
		int count=commentsServiceimpl.numOfcomments();//总数
		int pages=count%PAGESIZE==0?count/PAGESIZE:count/PAGESIZE+1;//总页数
		//前端传回来当前页码
		int currpage=1;
		
		//通过追加的参数method 来判断是以用户名显示还是以商品ID显示
		/*if (request.getParameter("method").equals("ShowBycommodity_id")) {*/
			
			int commodity_id=Integer.parseInt(request.getParameter("id"));
			comments=commentsServiceimpl.showcomments_Bycommodity_id(commodity_id, (currpage-1)*PAGESIZE, PAGESIZE);
		
		/*}else if (request.getParameter("method").equals("ShowByuser_id")) {
			
			int user_id=Integer.parseInt(request.getParameter("user_id"));
			comments=commentsServiceimpl.showcomments_Bycommodity_id(user_id, (currpage-1)*PAGESIZE, PAGESIZE);		
		}*/
		JSONObject json=new JSONObject();
		json.put("comments", comments);
		json.put("pages", pages);
		pw.print(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
