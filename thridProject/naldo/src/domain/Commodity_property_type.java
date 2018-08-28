package domain;
/*
 * id：商品属性类别id
name：商品属性名称 材质 | 尺寸 |重量

 */
public class Commodity_property_type {
	private int id;
	private String name;
	public Commodity_property_type() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Commodity_property_type(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "commodity_property_type [id=" + id + ", name=" + name + "]";
	}
	
}
