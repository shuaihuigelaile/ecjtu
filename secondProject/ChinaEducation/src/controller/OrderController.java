package controller;

import entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.IOrderService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    IOrderService orderService;

    @RequestMapping("/insertOrder")
    @ResponseBody
    public String insertOrder(HttpServletRequest request){
        String username=request.getParameter("username");
        String totalPrice=request.getParameter("totalPrice");
        Order order=new Order();
        order.setReceiver(username);
        order.setMoney(totalPrice);
        System.out.println("我进入了OrderController类");
        return orderService.OrderMapper(order)>0?"ok":"error";
    }

    //查询订单
    @RequestMapping("/queryAllOrder")
    @ResponseBody
    public List<Order> queryAllOrder(){
        return orderService.queryAllOrder();
    }

    //删除订单
    @RequestMapping("/deleteOrder")
    @ResponseBody
    public Integer deleteOrder(HttpServletRequest request){
        Integer orderId=Integer.parseInt(request.getParameter("id"));
        System.out.println("进入了deleteOrder方法");
        return orderService.deleteOrder(orderId);
    }

}
