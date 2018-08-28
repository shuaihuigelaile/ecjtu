package dao;

import java.util.List;

import domain.Commodity_attribute_value;

public interface Commodity_attribute_valueDao {
	/**
	 * 查询全部
	 * @return
	 */
	 List<Commodity_attribute_value> getAllCommodity_attribute_value();
	 public boolean add(Commodity_attribute_value commodity_attribute_value);
	 public boolean delete(int id);
	 public boolean update(Commodity_attribute_value commodity_attribute_value);
	 public Commodity_attribute_value queryById(int id);
}
