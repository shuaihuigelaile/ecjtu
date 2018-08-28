package service.impl;

import dao.Commodity_typeDao;
import dao.impl.Commodity_typeDaoImpl;
import domain.Commodity_type;
import service.Commodity_typeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @auther:houkexin
 * @date: 2018/7/29
 * @description:
 * @version: 1.0
 */
public class Commodity_TypeUpdate implements Commodity_typeService {
    @Override
    public boolean dispose(HttpServletRequest request, HttpServletResponse response) {
        boolean isSuccess = false;
        int id = Integer.parseInt(request.getParameter("typeId"));
        String name = request.getParameter("typeName");
        Commodity_typeDao commodity_typeDao = new Commodity_typeDaoImpl();
        Commodity_type commodity_type = new Commodity_type();
        commodity_type.setId(id);
        commodity_type.setType_name(name);
        if (commodity_typeDao.updateCommodity_type(commodity_type) != 0){
            isSuccess = true;
        }
        return isSuccess;
    }
}
