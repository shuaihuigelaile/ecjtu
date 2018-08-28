package domain;
/*
user_id:用户ID
commodity_id:商品ID
shopping_quantity：购买数量
 
 */
public class Shopping_trolley {
	private int user_id;
	private int commodity_id;
	private int shopping_quantity;
	public Shopping_trolley() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Shopping_trolley(int user_id, int commodity_id, int shopping_quantity) {
		super();
		this.user_id = user_id;
		this.commodity_id = commodity_id;
		this.shopping_quantity = shopping_quantity;
	}
	/**
	 * @return the user_id
	 */
	public int getUser_id() {
		return user_id;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
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
	 * @return the shopping_quantity
	 */
	public int getShopping_quantity() {
		return shopping_quantity;
	}
	/**
	 * @param shopping_quantity the shopping_quantity to set
	 */
	public void setShopping_quantity(int shopping_quantity) {
		this.shopping_quantity = shopping_quantity;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "shopping_trolley [user_id=" + user_id + ", commodity_id=" + commodity_id + ", shopping_quantity="
				+ shopping_quantity + "]";
	}
	
}
