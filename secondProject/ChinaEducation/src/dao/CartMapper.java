package dao;

import entity.Cart;
import entity.Course;
import entity.User;

import java.util.List;

public interface CartMapper {
    User findUserByName(String username);
    Cart selectOne(Cart cart);
    void insertCart(Cart cart);
    void updateByPrimaryKey(Cart cart);
    List<Cart> queryCartList(int userId);
    void deleteItem(Integer id);
    //通过用户名找到对应的id
    Integer findUserIdByUsername(String username);
    //根据用户id找到对应的购物车
    List<Cart> findNumberOfCart(Integer userId);

//    List findProductIdByUserId(int userId);
    Course findCourseByProductId(Integer id);
}
