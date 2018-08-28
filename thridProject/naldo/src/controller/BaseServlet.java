package controller;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.BeanFactory;
import service.orderService;
import util.WebUtils;

/**
 * Servlet implementation class BaseServlet
 */
@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    //载入各个serviceimpl 使用protected 以被子类继承
	protected orderService orderserviceimpl=BeanFactory.getInstance("orderservice", orderService.class);
	
    public BaseServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1(保存跳转的资源)  方法返回值
		 Object returnValue = null;
		//2获取方法
		 String methodName=request.getParameter("method");
		 //3获得selrvlet（methodName中的）中的具体方法
		 try {
			Method m=this.getClass().getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
		} catch (NoSuchMethodException|SecurityException e) {
			//跳转到错误页面
			returnValue = "/error/error.jsp";
			e.printStackTrace();
		} 
		//4、跳转页面
			WebUtils.goTo(request, response, returnValue);	
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
