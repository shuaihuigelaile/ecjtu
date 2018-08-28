package controller;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ICartService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class CartController {
    //增加购物车商品
    @Autowired
    ICartService cartService;
    @RequestMapping("/addItemToCart")
    @ResponseBody
    public User addItemToCart(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username= (String) session.getAttribute("name");
        User user=cartService.findUserByName(username);
        System.out.println(user);
        int product_id=Integer.parseInt(request.getParameter("id"));
        if (user==null){
            System.out.println("未登录状态");
        }else {
            System.out.println("已登录状态");
            cartService.addItemToCart(product_id,user);
        }
        return user;
    }

    //查询购物车列表
    @RequestMapping("/showCartList")
    @ResponseBody
    public Map showCartList(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username= (String) session.getAttribute("name");
        User user=cartService.findUserByName(username);
        Map<Object,Object> map=null;
        if (user==null){
            //未登录状态
        }else {
            map=cartService.queryCartformation(user.getId());
        }
        return map;
    }

    //删除
    @RequestMapping("/deleteCart")
    @ResponseBody
    public void deleteItem(HttpServletRequest request){
        System.out.println("我进来了删除方法");
        HttpSession session = request.getSession();
        String username= (String) session.getAttribute("name");
        User user=cartService.findUserByName(username);
        Integer id=Integer.parseInt(request.getParameter("cartId"));
        if (user==null){
            //未登录
        }else {
            cartService.deleteItem(id);
            System.out.println("删除成功");
        }
    }

    //求购物车数量
    @RequestMapping("/findNumberOfCart")
    @ResponseBody
    public Integer  findNumberOfCart(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username=(String) session.getAttribute("name");
        System.out.println("username的值为"+username);
        User user=cartService.findUserByName(username);
        Integer number=0;
        //根据用户名找到对应的id
        if(user!=null){
             number=cartService.findNumberOfCart(username);
            System.out.println("number的数量为");
            System.out.println(number);
        }else {

        }

        return number;
    }

}
