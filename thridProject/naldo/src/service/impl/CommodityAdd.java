package service.impl;

import dao.*;
import dao.impl.*;
import domain.*;
import service.CommodityService;
import util.FileUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

/**
 * @auther:houkexin
 * @date: 2018/7/29
 * @description:
 * @version: 1.0
 */
public class CommodityAdd implements CommodityService {
    @Override
    public boolean dispose(HttpServletRequest request, HttpServletResponse response) {
        boolean isSuccess = false;
        String name = request.getParameter("commodityName");
        String typeName = request.getParameter("typeName");
        String style_no = request.getParameter("style_no");
        String commodity_price = request.getParameter("commodity_price");
        String quantity_commodity = request.getParameter("quantity_commodity");
        String commodity_color = request.getParameter("commodity_color");
        String clarity = request.getParameter("clarity");
        String cut = request.getParameter("cut");
        String polishing = request.getParameter("polishing");
        String symmetry = request.getParameter("symmetry");
        String texture = request.getParameter("texture");
        String weight = request.getParameter("weight");
        String size = request.getParameter("size");
        String commodity_introduction = request.getParameter("commodity_introduction");
        Commodity commodity = new Commodity();
        commodity.setCommodity_name(name);
        Commodity_typeDao commodity_typeDao = new Commodity_typeDaoImpl();
        Commodity_type commodity_type = commodity_typeDao.queryByName(typeName);
        System.out.println(typeName);
        System.out.println(commodity_type);
        System.out.println(commodity_type.getId());
        commodity.setType_id(commodity_type.getId());
        commodity.setCommodity_introduction(commodity_introduction);
        CommodityDao commodityDao = new CommodityDaoImpl();
        Commodity_ifo commodity_ifo = new Commodity_ifo();
        commodity_ifo.setStyle_no(style_no);
        double temp = Double.parseDouble(commodity_price);
        commodity_ifo.setCommodity_price(temp);
        int quantity = Integer.parseInt(quantity_commodity);
        commodity_ifo.setQuantity_commodity(quantity);
        commodity_ifo.setCommodity_color(commodity_color);
        commodity_ifo.setClarity(clarity);
        commodity_ifo.setSymmetry(symmetry);
        commodity_ifo.setCut(cut);
        commodity_ifo.setPolishing(polishing);
        Commodity_attribute_value commodity_attribute_value = new Commodity_attribute_value();
        commodity_attribute_value.setWeight(weight);
        commodity_attribute_value.setTexture(texture);
        commodity_attribute_value.setSize(size);
        Commodity commodity1 = commodityDao.queryByName(name);
        if (commodity1 == null) {
            if (commodityDao.add(commodity)) {
                commodity = commodityDao.queryByName(name);
                commodity_ifo.setCommodity_id(commodity.getId());
                Commodity_ifoDao commodity_ifoDao = new Commodity_ifoDaoImpl();
                boolean istrue = commodity_ifoDao.add(commodity_ifo);
                if (istrue){
                    commodity_ifo = commodity_ifoDao.queryByNoandId(commodity.getId(),style_no);
                    commodity_attribute_value.setCommodity_info_id(commodity_ifo.getId());
                    Commodity_attribute_valueDao commodity_attribute_valueDao = new Commodity_attribute_valueDaoImpl();
                    if (commodity_attribute_valueDao.add(commodity_attribute_value)){
                        isSuccess = true;
                    }
                }
            }
        }
        return isSuccess;
    }
}
