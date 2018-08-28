package controller;

import dao.AddressDao;
import dao.CommodityDao;
import dao.Shopping_trolleyDao;
import dao.impl.AddressDaoImpl;
import dao.impl.CommodityDaoImpl;
import dao.impl.TrolleyDaoImpl;
import domain.Address;
import domain.CommodityAllInfo;
import domain.UserInfo;
import net.sf.json.JSONObject;
import org.jcp.xml.dsig.internal.dom.DOMUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @auther:houkexin
 * @date: 2018/8/1
 * @description:
 * @version: 1.0
 */
@WebServlet("/orderConfimServlet")
public class orderConfimServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //int id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        Shopping_trolleyDao trolleyDao = new TrolleyDaoImpl();
        List list = (List) trolleyDao.showAll(userInfo.getId());
        List<CommodityAllInfo> infoList = new ArrayList<>();
        CommodityDao commodityDao = new CommodityDaoImpl();
        double allPrice = 0;
        for (int i = 0; i < list.size(); i++){
            CommodityAllInfo commodityAllInfo = commodityDao.queryAllInfoById((int) list.get(i));
            allPrice += commodityAllInfo.getPrice();
            infoList.add(commodityAllInfo);
        }
        AddressDao addressDao = new AddressDaoImpl();
        Address address = addressDao.queryById(userInfo.getId());
        JSONObject json = new JSONObject();
        json.put("commodityinfo",infoList);
        json.put("address",address);
        json.put("userInfo",userInfo);
        json.put("allPrice",allPrice);
        PrintWriter pw = response.getWriter();
        pw.print(json.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
