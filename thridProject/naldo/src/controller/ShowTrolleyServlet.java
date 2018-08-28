package controller;

import dao.CommodityDao;
import dao.Shopping_trolleyDao;
import dao.impl.CommodityDaoImpl;
import dao.impl.TrolleyDaoImpl;
import domain.CommodityAllInfo;
import domain.Shopping_trolley;
import domain.UserInfo;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 点击我的购物车，或者显示购物车数据的Servlet
 */
@WebServlet("/showTrolley")
public class ShowTrolleyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CommodityAllInfo> listInfo = new ArrayList();
        //判断是否登录
        HttpSession session = req.getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        CommodityDao commodityDao = new CommodityDaoImpl();
        //未登录
        if(userInfo == null){

            //未登录状态下取cookies，根据键comId来取cookie的value，val为空，用来存value
            Cookie[] cookies = req.getCookies();
            String val = null;

            //如果有键comId，val的值就为商品信息ID的组合体，形式为“=ID=ID=ID”
            for (Cookie cookie:cookies){
                if(cookie.getName().equals("comId")){
                    val = cookie.getValue();
                    break;
                }
            }
            //listInfo是用来存放商品信息对象的，std对象用来调用方法
            Shopping_trolleyDao std = new TrolleyDaoImpl();
            //对val进行拆分，取出里面的商品信息ID,一个用户ID可以有很多个商品信息ID
            String[] comIds = val.split("=");

            //将String类型转成int类型，在调用getInfo()返回商品信息对象添加到listInfo里面
            for(int i = 1;i<comIds.length;i++){
                int comId = Integer.parseInt(comIds[i]);
                listInfo.add(commodityDao.queryAllInfoById(comId));
            }
            //打印测试
            System.out.println(listInfo.toString());

        //已登录
        }else {
            Shopping_trolleyDao std = new TrolleyDaoImpl();
            Cookie[] cookies = req.getCookies();
            String val = null;
            for(Cookie cookie:cookies){
                if(cookie.getName().equals("comId")){
                    val = cookie.getValue();
                    cookie.setMaxAge(0);
                }
            }
            if(val != null){
                String[] comIds = val.split("=");
                for(int i = 1;i<comIds.length;i++){
                    int comId = Integer.parseInt(comIds[i]);
                    Shopping_trolley st = new Shopping_trolley(userInfo.getId(),comId,1);
                    int f = std.selectTrolley(userInfo.getId(),comId);
                    if(f == 0){
                        std.addTrolley(st);
                    }else {
                        st.setShopping_quantity(1);
                        std.update(st);
                    }
                }
            }

            //已登录状态下直接调用用户信息的ID来获取商品信息的ID
            //showAll(int user_id)返回的是该用户保存的所有商品id,是一个list
            List list = (List) std.showAll(userInfo.getId());

            //listInfo存放所有商品信息对象

            for(int i = 0;i<list.size();i++){
                listInfo.add(commodityDao.queryAllInfoById((int)list.get(i)));
            }
            //转成Json
        }
        JSONObject json = new JSONObject();
        json.put("commInfoList",listInfo);
        PrintWriter out = resp.getWriter();
        System.out.println(json.toString());
        out.print(json.toString());
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
