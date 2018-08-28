package service.impl;

import dao.CartMapper;
import entity.Cart;
import entity.Course;
import entity.User;
import javafx.beans.binding.ObjectExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ICartService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartService implements ICartService {
    @Autowired
    CartMapper cartMapper;
    @Override
    public void addItemToCart(int product_id,User user) {
        //获取当前用户
        Cart record=new Cart();
        record.setProductId(product_id);
        record.setUserId(user.getId());
        Cart cart=cartMapper.selectOne(record);
        System.err.println(cart);
        System.out.println("进来了service方法");
        if (cart==null){
            System.out.println("创建新的购物车");
            cart = new Cart();
            cart.setProductId(product_id);
            cart.setUserId(user.getId());
            cart.setQuantity(1);
            cart.setCreateTime(new Date());
//            cart.setUpdateTime(new Date());
            cartMapper.insertCart(cart);
        }else {
            cart.setQuantity(cart.getQuantity()+1);
            cart.setUpdateTime(new Date());
            System.err.println(cart);
            cartMapper.updateByPrimaryKey(cart);
        }
    }

    @Override
    public User findUserByName(String username) {
        return cartMapper.findUserByName(username);
    }

    @Override
    public Map<Object, Object> queryCartformation(int userId) {
        //通过用户id找到其对应的购物车
        List<Cart> carts=cartMapper.queryCartList(userId);
        //根据购物车找到对应的
        Map<Object,Object> map=new HashMap<>();
        map.put(0,carts);
//        List lists=cartMapper.findProductIdByUserId(userId);
        for (Object cart:carts) {
            //根据productId找到对应的Course
            Cart cart1=(Cart) cart;
            Course course=cartMapper.findCourseByProductId(cart1.getProductId());
            map.put(course.getId(),course);
//            carts.add(course);
        }
        int size=map.size();
        map.put("num",size);
//        Cart cart=new Cart();
//        //根据对应的商品id获取对应的课程内容
//        int productId=cart.getId();
        return map;
//        return cartMapper.queryCartList(userId);
    }

    @Override
    public void deleteItem(Integer id) {
        cartMapper.deleteItem(id);
    }


    @Override
    public Integer findNumberOfCart(String username) {
        Integer userId=cartMapper.findUserIdByUsername(username);
        List<Cart> carts=cartMapper.findNumberOfCart(userId);
        int number=0;
        for(int i=0;i<carts.size();i++){
            number=number+carts.get(i).getQuantity();
        }
        return number;
    }
}
