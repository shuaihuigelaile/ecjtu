package service;

import entity.Cart;
import entity.Course;
import entity.User;

import java.util.List;
import java.util.Map;

public interface ICartService {
    //实体cart，将商品信息存到cart中，根据cart就可以取到用户和商品信息，商品信息可由商品id来获得,用户信息根据用户id来获得
    //添加购物车
    void addItemToCart(int product_id,User user);
    User findUserByName(String username);
    //找到所有购物车信息
    Map<Object,Object> queryCartformation(int userId);
    void deleteItem(Integer id);


    //根据用户id找到对应的购物车，并计算数量，进行返回
    Integer findNumberOfCart(String username);
}
