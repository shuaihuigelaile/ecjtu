package dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import dao.commentsDao;
import domain.Comments;
import util.DBUtil;

public class commentsDaoImpl implements commentsDao{
	static QueryRunner qr;
	static{
		qr=new QueryRunner(DBUtil.getDs());
	}
	@Override//增加评论
	public boolean addcomment(Comments comment) {
		int i=0;
		String sql="INSERT into  comments (user_id,commodity_id,comments_time,comment_content) VALUES(?,?,?,?)";
		try {
			i=qr.update(sql, new Object[]{comment.getUser_id(),comment.getCommodity_id(),comment.getComments_time(),comment.getComment_content()});
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i>0?true:false;
	}

	@Override//通过用户ID查询评论
	public List<Comments> query_by_user_id(int user_id,int start,int pagesize) {
		List<Comments> comments=null;
		String sql="select * from comments where user_id=? LIMIT ?,?";
		try {
			comments=qr.query(sql, new BeanListHandler<Comments>(Comments.class),user_id,start,pagesize);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return comments;
	}

	@Override//通过商品ID查询评论
	public List<Comments> query_by_commodity_id(int commodity_id,int start,int pagesize) {
		List<Comments> comments=null;
		String sql="select * from comments where commodity_id=? LIMIT ?,?";
		try {
			comments=qr.query(sql, new BeanListHandler<Comments>(Comments.class),commodity_id,start,pagesize);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comments;
	}

	@Override
	public int numOfcomments() {
		List<Comments> comments=null;
		String sql="select * from comments";
		try {
			comments=qr.query(sql, new BeanListHandler<Comments>(Comments.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comments.size();
	}

}
