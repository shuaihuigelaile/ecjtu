package domain;
/*
commodity_info_Id：商品信息ID
commodity_property_id：商品属性id
commodity_property_value_id：商品属性值id

 */
public class Commodity_property {
	private int commodity_info_Id;
	private int commodity_property_id;
	private int commodity_property_value_id;
	public Commodity_property() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Commodity_property(int commodity_info_Id, int commodity_property_id, int commodity_property_value_id) {
		super();
		this.commodity_info_Id = commodity_info_Id;
		this.commodity_property_id = commodity_property_id;
		this.commodity_property_value_id = commodity_property_value_id;
	}
	/**
	 * @return the commodity_info_Id
	 */
	public int getCommodity_info_Id() {
		return commodity_info_Id;
	}
	/**
	 * @param commodity_info_Id the commodity_info_Id to set
	 */
	public void setCommodity_info_Id(int commodity_info_Id) {
		this.commodity_info_Id = commodity_info_Id;
	}
	/**
	 * @return the commodity_property_id
	 */
	public int getCommodity_property_id() {
		return commodity_property_id;
	}
	/**
	 * @param commodity_property_id the commodity_property_id to set
	 */
	public void setCommodity_property_id(int commodity_property_id) {
		this.commodity_property_id = commodity_property_id;
	}
	/**
	 * @return the commodity_property_value_id
	 */
	public int getCommodity_property_value_id() {
		return commodity_property_value_id;
	}
	/**
	 * @param commodity_property_value_id the commodity_property_value_id to set
	 */
	public void setCommodity_property_value_id(int commodity_property_value_id) {
		this.commodity_property_value_id = commodity_property_value_id;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "commodity_property [commodity_info_Id=" + commodity_info_Id + ", commodity_property_id="
				+ commodity_property_id + ", commodity_property_value_id=" + commodity_property_value_id + "]";
	}
	
}
