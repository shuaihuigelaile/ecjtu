package service.impl;

import dao.Commodity_ifoDao;
import dao.impl.Commodity_ifoDaoImpl;
import service.CommodityService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @auther:houkexin
 * @date: 2018/7/31
 * @description:
 * @version: 1.0
 */
public class CommodityDel implements CommodityService {
    @Override
    public boolean dispose(HttpServletRequest request, HttpServletResponse response) {
        //boolean isSccess = false;
        int id = Integer.parseInt(request.getParameter("id"));
        Commodity_ifoDao commodity_ifoDao = new Commodity_ifoDaoImpl();
        return commodity_ifoDao.delete(id);
    }
}
