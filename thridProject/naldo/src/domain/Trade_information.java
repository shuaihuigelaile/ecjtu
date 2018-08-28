package domain;
/*
id：交易id
order_id:订单id
commodity_id:商品id
quantity：交易商品数量
amount_payable :应付金额

 */
public class Trade_information {
	private int id;
	private String order_id;
	private int commodity_id;
	private int quantity;
	private double amount_payable;
	public Trade_information() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Trade_information(int id, String order_id, int commodity_id, int quantity, double amount_payable) {
		super();
		this.id = id;
		this.order_id = order_id;
		this.commodity_id = commodity_id;
		this.quantity = quantity;
		this.amount_payable = amount_payable;
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
	 * @return the order_id
	 */
	public String getOrder_id() {
		return order_id;
	}
	/**
	 * @param order_id the order_id to set
	 */
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
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
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the amount_payable
	 */
	public double getAmount_payable() {
		return amount_payable;
	}
	/**
	 * @param amount_payable the amount_payable to set
	 */
	public void setAmount_payable(double amount_payable) {
		this.amount_payable = amount_payable;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "trade_information [id=" + id + ", order_id=" + order_id + ", commodity_id=" + commodity_id
				+ ", quantity=" + quantity + ", amount_payable=" + amount_payable + "]";
	}
	
}
