package controller;

import dao.CommodityDao;
import dao.Commodity_ifoDao;
import dao.Trade_informationDao;
import dao.impl.*;
import dao.orderDao;
import domain.*;
import service.impl.orderServiceImpl;
import service.orderService;
import util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @auther:houkexin
 * @date: 2018/8/2
 * @description:
 * @version: 1.0
 */
@WebServlet("/addOrderServlet")
public class AddOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
       // Object uri = null;
        Order order=new Order();
        boolean b=false;
        orderDao orderDao = new orderDaoImpl();
        //设置订单号、用户ID、订单状态、付款状态、配送状态、配送地址id
        //生成订单号//12位时间——年月日时分+两位随机数+用户id
        HttpSession session = request.getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        String order_no=DBUtil.getDbUtil().getOrder_no()+userInfo.getId();
        Trade_information trade_information = new Trade_information();
        Trade_informationDao informationDao = new Trade_informationDaoImpl();
        TrolleyDaoImpl trolleyDao = new TrolleyDaoImpl();
        List<Integer> comdids = (List)trolleyDao.showAll(userInfo.getId());
        trade_information.setOrder_id(order_no);
        trade_information.setQuantity(1);
        Commodity_ifoDao ifoDao = new Commodity_ifoDaoImpl();
        //Shopping_trolley shopping_trolley = new Shopping_trolley();
        for (int i = 0; i < comdids.size(); i++){
            System.out.println(comdids.get(i));
            trade_information.setCommodity_id(comdids.get(i));
            Commodity_ifo ifo = ifoDao.queryById(comdids.get(i));
            System.out.println(ifo);
             double temp = ifo.getCommodity_price();
            System.out.println(temp);
            trade_information.setAmount_payable(temp);
            informationDao.add(trade_information);
        }
        order.setOrder_no(order_no);
        order.setUser_Id(userInfo.getId());
        order.setOrder_State("未完成");
        order.setPayment_status(1);
        order.setShipment_status("未配送");
        order.setAddress_id(1);
        b = orderDao.addorder(order);
        if (b) {
            // 跳转到显示页
            //uri = request.getRequestDispatcher("order_list.html");
            try {
                response.sendRedirect("order_list.html");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        doPost(request,response);
    }
}
