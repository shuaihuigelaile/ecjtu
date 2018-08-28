package domain;
/*
id：商品id
type_id：商品类型id
commodity_name：商品名称
commodity_introduction:商品简介

 */
public class Commodity {
	private int id;
	private int type_id;
	private String commodity_name;
	private String commodity_introduction;
	public Commodity() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the type_id
	 */
	public int getType_id() {
		return type_id;
	}
	/**
	 * @param type_id the type_id to set
	 */
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	/**
	 * @return the commodity_name
	 */
	public String getCommodity_name() {
		return commodity_name;
	}
	/**
	 * @param commodity_name the commodity_name to set
	 */
	public void setCommodity_name(String commodity_name) {
		this.commodity_name = commodity_name;
	}
	/**
	 * @return the commodity_introduction
	 */
	public String getCommodity_introduction() {
		return commodity_introduction;
	}
	/**
	 * @param commodity_introduction the commodity_introduction to set
	 */
	public void setCommodity_introduction(String commodity_introduction) {
		this.commodity_introduction = commodity_introduction;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "commodity [id=" + id + ", type_id=" + type_id + ", commodity_name=" + commodity_name
				+ ", commodity_introduction=" + commodity_introduction + "]";
	}
	
}
