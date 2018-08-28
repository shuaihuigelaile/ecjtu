package controller;

import dao.Commodity_typeDao;
import dao.impl.Commodity_typeDaoImpl;
import domain.Commodity_type;
import net.sf.json.JSONObject;
import service.Commodity_typeService;
import service.impl.Commodity_TypeUpdate;
import service.impl.Commodity_typeAddImpl;
import service.impl.Commodity_typeDel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @auther:houkexin
 * @date: 2018/7/29
 * @description:
 * @version: 1.0
 */
@WebServlet("/commodityTypeServlet")
public class CommodityTypeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        boolean isSuccess = false;
        JSONObject json  = new JSONObject();
        PrintWriter pw = response.getWriter();
        if (type.equals("add")){
            Commodity_typeService commodityTypeService = new Commodity_typeAddImpl();
            isSuccess = commodityTypeService.dispose(request,response);
            json.put("result",isSuccess);
        }else if (type.equals("list")){
            Commodity_typeDao commodity_typeDao = new Commodity_typeDaoImpl();
            List<Commodity_type> list = commodity_typeDao.queryAllCommodity_type();
            json.put("result",list);
        }else if (type.equals("del")){
            Commodity_typeService commodityTypeService = new Commodity_typeDel();
            isSuccess = commodityTypeService.dispose(request,response);
            json.put("result",isSuccess);
        }else if (type.equals("query")){
            int id = Integer.parseInt(request.getParameter("typeId"));
            Commodity_typeDao commodity_typeDao = new Commodity_typeDaoImpl();
            json.put("result",commodity_typeDao.queryCommodity_type(id));
        }else if(type.equals("update")){
            Commodity_typeService commodityTypeService = new Commodity_TypeUpdate();
            isSuccess = commodityTypeService.dispose(request,response);
            json.put("result",isSuccess);
        }
        pw.print(json.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
