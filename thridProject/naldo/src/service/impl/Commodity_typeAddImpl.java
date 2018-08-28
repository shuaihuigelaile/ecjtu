package service.impl;

import dao.Commodity_typeDao;
import dao.impl.Commodity_typeDaoImpl;
import service.Commodity_typeService;
import util.C3P0Util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @auther:houkexin
 * @date: 2018/7/29
 * @description:
 * @version: 1.0
 */
public class Commodity_typeAddImpl implements Commodity_typeService {
    @Override
    public boolean dispose(HttpServletRequest request, HttpServletResponse response) {
        boolean isSuccess = false;
        String typeName = request.getParameter("typeName");
        Commodity_typeDao commodity_typeDao = new Commodity_typeDaoImpl();
        if (commodity_typeDao.saveCommodity_type(typeName) != 0){
            isSuccess = true;
        }
        return isSuccess;
    }
}
