package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Order;
import factory.BeanFactory;
import net.sf.json.JSONObject;
import service.orderService;

@WebServlet("/order_update")
public class order_update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public order_update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		orderService orderServiceimpl=BeanFactory.getInstance("orderservice", orderService.class);
		String order_no=request.getParameter("order_no");//从前端获得操作订单号
		Order order=orderServiceimpl.findorderByorder_no(order_no);
		order.setOrder_State("已付款");//想改哪个set哪个
		boolean result=orderServiceimpl.updateorderByorder_no(order_no, order);
		JSONObject json=new JSONObject();
		json.put("result", result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
