package dao;

import java.util.List;

import domain.Commodity;
import domain.Commodity_property;

public interface Commodity_propertyDao {
	/**
	 * 查询全部
	 * @return
	 */
	 List<Commodity_property> getAllcommodity_property();
	 public boolean add(Commodity_property commodity_property);
	 public boolean update(Commodity_property commodity_property);
	 public boolean delete(Commodity_property commodity_property);
	 public Commodity_property queryById(int id);
}
