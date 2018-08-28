package dao;

import domain.Commodity_ifo;
import domain.Shopping_trolley;

import java.util.Collection;

public interface Shopping_trolleyDao {

    //添加到购物车表
    boolean addTrolley(Shopping_trolley stObject);

    //显示购物车商品信息（根据用户ID）
    Collection showAll(int userInfoId);

    //根据商品id,显示商品信息
    Commodity_ifo getInfo(int id);

    //查询商品数量
    int selectTrolley(int user_id, int commodity_id);

    //更改商品数量
    boolean update(Shopping_trolley stObject);

    //删除购物车商品(user_id)
    boolean delete(int id,int commdityId);

    //在commodity_images插入文件路径
    boolean insert(int comId, String path);

}
