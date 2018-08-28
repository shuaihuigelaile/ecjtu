package service.impl;

import dao.Commodity_typeDao;
import dao.impl.Commodity_typeDaoImpl;
import service.Commodity_typeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @auther:houkexin
 * @date: 2018/7/29
 * @description:
 * @version: 1.0
 */
public class Commodity_typeDel implements Commodity_typeService {
    @Override
    public boolean dispose(HttpServletRequest request, HttpServletResponse response) {
        boolean isSuccess = false;
        int type_id = Integer.parseInt(request.getParameter("typeId"));
        System.out.println(type_id);
        Commodity_typeDao commodity_typeDao = new Commodity_typeDaoImpl();
        if (commodity_typeDao.deleteCommodity_type(type_id) != 0){
            isSuccess = true;
        }
        return isSuccess;
    }
}
