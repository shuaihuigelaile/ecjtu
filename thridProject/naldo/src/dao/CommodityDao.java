package dao;

import java.util.List;

import domain.Commodity;
import domain.CommodityAllInfo;

/**
 * 查询全部
 * @return
 */
public interface CommodityDao {
     List<Commodity> getAllCommodity();
     public boolean add(Commodity commodity);
     public boolean update(Commodity commodity);
     public Commodity queryById(int id);
     public boolean delete(int id);
     List<CommodityAllInfo> queryAll();
     public Commodity queryByName(String name);
     public CommodityAllInfo queryAllInfoById(int id);
}