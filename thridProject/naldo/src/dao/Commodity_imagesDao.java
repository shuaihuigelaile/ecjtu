package dao;

import java.util.List;

import domain.Commodity_images;

public interface Commodity_imagesDao {
	/**
	 * 查询全部
	 * @return
	 */
	 List<Commodity_images> getAllCommodity_image();
	 boolean add(Commodity_images images);
}
