package service;

import java.util.List;

import domain.Comments;

public interface commentsService {
	
	//增加评论
	boolean addcomments(Comments comment);
	//通过用户名分页查询评论
	List<Comments> showcomments_Byuser_id(int user_id, int start, int pagesize);
	//通过商品ID分页查询评论
	List<Comments> showcomments_Bycommodity_id(int commodity_id, int start, int pagesize);
	//查询表数据总数
	int numOfcomments();
}
