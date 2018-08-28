package dao;

import java.util.List;

import domain.Comments;

public interface commentsDao  {
	//添加评论
	boolean addcomment(Comments comment);
	
	//通过用户ID分页查询评论
	List<Comments> query_by_user_id(int user_id, int start, int pagesize);
	
	//通过商品ID分页查询评论
	List<Comments> query_by_commodity_id(int commodity_id, int start, int pagesize);
	//查询订单表数据总数
		int numOfcomments();
}
