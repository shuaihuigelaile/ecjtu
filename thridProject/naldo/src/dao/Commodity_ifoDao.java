package dao;

import domain.Commodity_ifo;

import java.util.List;


public interface Commodity_ifoDao {
	/**
	 * 查询全部
	 * @return
	 */
	 List<Commodity_ifo> getAllCommodity_ifo();
	 public boolean add(Commodity_ifo commodity_ifo);
	 public boolean delete(int id);
	 public boolean update(Commodity_ifo commodity_ifo);
	 public Commodity_ifo queryById(int id);
	 public List<Commodity_ifo> queryByCommodityId(int commodityId);
	 public Commodity_ifo queryByNoandId(int id, String no);
}
