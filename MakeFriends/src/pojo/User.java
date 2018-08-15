package pojo;

public class User {
	private String logname;
	private String password;
	private String phone;
	private String email;
	private String message;
	private String pic;
	public User() {
		
	}	
	
	public User(String logname, String password, String phone, String email, String message, String pic) {
		this.logname = logname;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.message = message;
		this.pic = pic;
	}


	public String getLogname() {
		return logname;
	}
	public void setLogname(String logname) {
		this.logname = logname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	@Override
	public String toString() {
		return "User [logname=" + logname + ", password=" + password + ", phone=" + phone + ", email=" + email
				+ ", message=" + message + ", pic=" + pic + "]";
	}
	
	
}
