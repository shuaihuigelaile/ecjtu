package service.impl;

import java.util.List;

import dao.commentsDao;
import dao.impl.commentsDaoImpl;
import domain.Comments;
import factory.BeanFactory;
import service.commentsService;

public class commentsServiceImpl implements commentsService {

	commentsDao commentsdaoimpl=new commentsDaoImpl();
	
	@Override
	public boolean addcomments(Comments comment) {
		// TODO Auto-generated method stub
		return commentsdaoimpl.addcomment(comment);
	}

	@Override
	public List<Comments> showcomments_Byuser_id(int user_id, int start, int pagesize) {
		// TODO Auto-generated method stub
		return commentsdaoimpl.query_by_user_id(user_id, start, pagesize);
	}

	@Override
	public List<Comments> showcomments_Bycommodity_id(int commodity_id, int start, int pagesize) {
		// TODO Auto-generated method stub
		return commentsdaoimpl.query_by_commodity_id(commodity_id, start, pagesize);
	}

	@Override
	public int numOfcomments() {
		
		return commentsdaoimpl.numOfcomments();
	}

}
