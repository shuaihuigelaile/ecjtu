package domain;
/*
comments_id： 评论id
user_id：用户ID
commodity_id:商品ID
comments_time:评论时间
comment_content :评论内容

 */

import java.security.KeyStore.PrivateKeyEntry;
import java.util.Date;

public class Comments {
	private int comments_id;
	private int user_id;
	private int commodity_id;
	private Date comments_time;
	private String comment_content;
	public Comments() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comments(int comments_id, int user_id, int commodity_id, Date comments_time, String comment_content) {
		super();
		this.comments_id = comments_id;
		this.user_id = user_id;
		this.commodity_id = commodity_id;
		this.comments_time = comments_time;
		this.comment_content = comment_content;
	}
	/**
	 * @return the comments_id
	 */
	public int getComments_id() {
		return comments_id;
	}
	/**
	 * @param comments_id the comments_id to set
	 */
	public void setComments_id(int comments_id) {
		this.comments_id = comments_id;
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
	 * @return the comments_time
	 */
	public Date getComments_time() {
		return comments_time;
	}
	/**
	 * @param comments_time the comments_time to set
	 */
	public void setComments_time(Date comments_time) {
		this.comments_time = comments_time;
	}
	/**
	 * @return the comment_content
	 */
	public String getComment_content() {
		return comment_content;
	}
	/**
	 * @param comment_content the comment_content to set
	 */
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "comments [comments_id=" + comments_id + ", user_id=" + user_id + ", commodity_id=" + commodity_id
				+ ", comments_time=" + comments_time + ", comment_content=" + comment_content + "]";
	}
	
}
