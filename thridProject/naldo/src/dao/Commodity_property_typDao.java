package dao;

import java.util.List;

import domain.Commodity_property_type;

public interface Commodity_property_typDao {
	/**
	 * 查询全部
	 * @return
	 */
	 List<Commodity_property_type> getAllCommodity_propertype_type();
	 public Commodity_property_type queryById(int id);
}
