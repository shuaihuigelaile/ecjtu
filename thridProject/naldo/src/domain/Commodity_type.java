package domain;
/*
 * id：商品类型id
typ_name：商品类型名字

 */
public class Commodity_type {
	private int id;
	private String type_name;
	public Commodity_type() {
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
	 * @return the type_name
	 */
	public String getType_name() {
		return type_name;
	}
	/**
	 * @param type_name the type_name to set
	 */
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "commodity_type [id=" + id + ", type_name=" + type_name + "]";
	}
	
}
