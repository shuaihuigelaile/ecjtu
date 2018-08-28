package domain;
/*
id：商品信息id	
commodity_id:商品id
style_no: 款式号	
commodity_price:商品单价
quantity_commodity:商品库存量
commodity_color：商品颜色
clarity：净度
cut：切工
polishing ：抛光
symmetry：对称
 */
public class Commodity_ifo {
	private int id;
	private int commodity_id;
	private String style_no;
	private double commodity_price;
	private int quantity_commodity;
	private String commodity_color;
	private String clarity;
	private String cut;
	private String polishing;
	private String symmetry;
	public Commodity_ifo() {
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
	 * @return the commodity_id
	 */
	public int getCommodity_id() {
		return commodity_id;
	}
	/**
	 * @param commodity_id the commodity_id to set
	 */
	public void setCommodity_id(int commodity_id) {
		this.commodity_id = commodity_id;
	}
	/**
	 * @return the style_no
	 */
	public String getStyle_no() {
		return style_no;
	}
	/**
	 * @param style_no the style_no to set
	 */
	public void setStyle_no(String style_no) {
		this.style_no = style_no;
	}
	/**
	 * @return the commodity_price
	 */
	public double getCommodity_price() {
		return commodity_price;
	}
	/**
	 * @param commodity_price the commodity_price to set
	 */
	public void setCommodity_price(double commodity_price) {
		this.commodity_price = commodity_price;
	}
	/**
	 * @return the quantity_commodity
	 */
	public int getQuantity_commodity() {
		return quantity_commodity;
	}
	/**
	 * @param quantity_commodity the quantity_commodity to set
	 */
	public void setQuantity_commodity(int quantity_commodity) {
		this.quantity_commodity = quantity_commodity;
	}
	/**
	 * @return the commodity_color
	 */
	public String getCommodity_color() {
		return commodity_color;
	}
	/**
	 * @param commodity_color the commodity_color to set
	 */
	public void setCommodity_color(String commodity_color) {
		this.commodity_color = commodity_color;
	}
	/**
	 * @return the clarity
	 */
	public String getClarity() {
		return clarity;
	}
	/**
	 * @param clarity the clarity to set
	 */
	public void setClarity(String clarity) {
		this.clarity = clarity;
	}
	/**
	 * @return the cut
	 */
	public String getCut() {
		return cut;
	}
	/**
	 * @param cut the cut to set
	 */
	public void setCut(String cut) {
		this.cut = cut;
	}
	/**
	 * @return the polishing
	 */
	public String getPolishing() {
		return polishing;
	}
	/**
	 * @param polishing the polishing to set
	 */
	public void setPolishing(String polishing) {
		this.polishing = polishing;
	}
	/**
	 * @return the symmetry
	 */
	public String getSymmetry() {
		return symmetry;
	}
	/**
	 * @param symmetry the symmetry to set
	 */
	public void setSymmetry(String symmetry) {
		this.symmetry = symmetry;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "commodity_ifo [id=" + id + ", commodity_id=" + commodity_id + ", style_no=" + style_no
				+ ", commodity_price=" + commodity_price + ", quantity_commodity=" + quantity_commodity
				+ ", commodity_color=" + commodity_color + ", clarity=" + clarity + ", cut=" + cut + ", polishing="
				+ polishing + ", symmetry=" + symmetry + "]";
	}
	
}
