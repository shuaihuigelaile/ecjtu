package domain;
/*
id：自增 主键
userName：用户名
email：邮箱
pwd：密码
phone：手机号
idCard：身份证号码
name：真实姓名
sex：性别 男|女|保密 默认保密
date_birth:出生日期
 */

import java.util.Date;


public class UserInfo {
	private int id;
	private String userName;
	private String email;
	private String pwd;
	private String phone;
	private String idCard;
	private String name;
	private String sex;
	private Date date_birth;
	public UserInfo() {
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
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}
	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the idCard
	 */
	public String getIdCard() {
		return idCard;
	}
	/**
	 * @param idCard the idCard to set
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
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
	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * @return the date_birth
	 */
	public Date getDate_birth() {
		return date_birth;
	}
	/**
	 * @param date_birth the date_birth to set
	 */
	public void setDate_birth(Date date_birth) {
		this.date_birth = date_birth;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "userinfo [id=" + id + ", userName=" + userName + ", email=" + email + ", pwd=" + pwd + ", phone="
				+ phone + ", idCard=" + idCard + ", name=" + name + ", sex=" + sex + ", date_birth=" + date_birth + "]";
	}
	
	
}
