package dao;

import domain.Trade_information;

import java.util.List;

/**
 * @auther:houkexin
 * @date: 2018/8/2
 * @description:
 * @version: 1.0
 */
public interface Trade_informationDao {
    public boolean add(Trade_information information);
    public List<Trade_information> queryById(String id);
}
