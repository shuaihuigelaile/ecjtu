package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Order;
import domain.UserInfo;
import util.DBUtil;

public class order_AddServlet extends BaseServlet{
	private static final long serialVersionUID = 1L;

	// 1. 添加订单并跳转显示
	public Object addorder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 保存跳转资源(转发/重定向)
		Object uri = null;
		Order order=new Order();
		boolean b=false;
		//设置订单号、用户ID、订单状态、付款状态、配送状态、配送地址id
		//生成订单号//12位时间——年月日时分+两位随机数+用户id
		String order_no=DBUtil.getDbUtil().getOrder_no()+request.getParameter("user_id");
		order.setOrder_no(order_no);
        HttpSession session = request.getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		order.setUser_Id(userInfo.getId());
		order.setOrder_State("未完成");
		order.setPayment_status(1);
		order.setShipment_status("未配送");
		order.setAddress_id(1);
		b=orderserviceimpl.AddOrder(order);
		if (b) {
		   // 跳转到显示页
		   uri = request.getRequestDispatcher("order_list.html");
		}
		return uri;
}
}