package domain;
/*
id ：订单id
order_no： 订单号 自动生成 16位
user_Id：用户ID 
order_State：订单状态
payment_status:付款状态 未付款0 | 已付款 1
shipment_status: 配送状态
address_id:收货地址id

 */
public class Order {
	private int id;
	private String order_no;
	private int user_Id;
	private String order_State;
	private int payment_status;
	private String shipment_status;
	private int address_id;
	private double prices;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int id, String order_no, int user_Id, String order_State, int payment_status, String shipment_status,
			int address_id) {
		super();
		this.id = id;
		this.order_no = order_no;
		this.user_Id = user_Id;
		this.order_State = order_State;
		this.payment_status = payment_status;
		this.shipment_status = shipment_status;
		this.address_id = address_id;
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
	 * @return the order_no
	 */
	public String getOrder_no() {
		return order_no;
	}
	/**
	 * @param order_no the order_no to set
	 */
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	/**
	 * @return the user_Id
	 */
	public int getUser_Id() {
		return user_Id;
	}
	/**
	 * @param user_Id the user_Id to set
	 */
	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}
	/**
	 * @return the order_State
	 */
	public String getOrder_State() {
		return order_State;
	}
	/**
	 * @param order_State the order_State to set
	 */
	public void setOrder_State(String order_State) {
		this.order_State = order_State;
	}
	/**
	 * @return the payment_status
	 */
	public int getPayment_status() {
		return payment_status;
	}
	/**
	 * @param payment_status the payment_status to set
	 */
	public void setPayment_status(int payment_status) {
		this.payment_status = payment_status;
	}
	/**
	 * @return the shipment_status
	 */
	public String getShipment_status() {
		return shipment_status;
	}
	/**
	 * @param shipment_status the shipment_status to set
	 */
	public void setShipment_status(String shipment_status) {
		this.shipment_status = shipment_status;
	}
	/**
	 * @return the address_id
	 */
	public int getAddress_id() {
		return address_id;
	}
	/**
	 * @param address_id the address_id to set
	 */
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

    public double getPrices() {
        return prices;
    }

    public void setPrices(double prices) {
        this.prices = prices;
    }

    /* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "order [id=" + id + ", order_no=" + order_no + ", user_Id=" + user_Id + ", order_State=" + order_State
				+ ", payment_status=" + payment_status + ", shipment_status=" + shipment_status + ", address_id="
				+ address_id + "]";
	}
	
}
