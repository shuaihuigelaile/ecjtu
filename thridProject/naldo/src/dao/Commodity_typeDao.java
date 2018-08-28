package dao;

import java.util.List;

import domain.Commodity_type;

public interface Commodity_typeDao {
	//实现商品类型表的增删改查
	public int saveCommodity_type(String name);
	public int updateCommodity_type(Commodity_type commodity_type);
	public int deleteCommodity_type(int id);
	//查询所有
	public List<Commodity_type> queryAllCommodity_type();
	//按照id来查询对应的记录
	public Commodity_type queryCommodity_type(int id);
	public Commodity_type queryByName(String name);
}
