package domain;
/*
address_Id：收货地址id 自增
user_id：用户id
address: 收货地址
zip_code：邮编
consignee_name:收货人姓名
consignee_phone 收货人手机号码

 */
public class Address {
	private int address_Id;
	private int user_id;
	private String address;
	private String zip_code;
	private String consignee_name;
	private String consignee_phone;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(int address_Id, int user_id, String address, String zip_code, String consignee_name,
			String consignee_phone) {
		super();
		this.address_Id = address_Id;
		this.user_id = user_id;
		this.address = address;
		this.zip_code = zip_code;
		this.consignee_name = consignee_name;
		this.consignee_phone = consignee_phone;
	}
	/**
	 * @return the address_Id
	 */
	public int getAddress_Id() {
		return address_Id;
	}
	/**
	 * @param address_Id the address_Id to set
	 */
	public void setAddress_Id(int address_Id) {
		this.address_Id = address_Id;
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the zip_code
	 */
	public String getZip_code() {
		return zip_code;
	}
	/**
	 * @param zip_code the zip_code to set
	 */
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	/**
	 * @return the consignee_name
	 */
	public String getConsignee_name() {
		return consignee_name;
	}
	/**
	 * @param consignee_name the consignee_name to set
	 */
	public void setConsignee_name(String consignee_name) {
		this.consignee_name = consignee_name;
	}
	/**
	 * @return the consignee_phone
	 */
	public String getConsignee_phone() {
		return consignee_phone;
	}
	/**
	 * @param consignee_phone the consignee_phone to set
	 */
	public void setConsignee_phone(String consignee_phone) {
		this.consignee_phone = consignee_phone;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "address [address_Id=" + address_Id + ", user_id=" + user_id + ", address=" + address + ", zip_code="
				+ zip_code + ", consignee_name=" + consignee_name + ", consignee_phone=" + consignee_phone + "]";
	}
	
	
}
