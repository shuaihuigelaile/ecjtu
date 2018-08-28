package controller;

import dao.AddressDao;
import dao.impl.AddressDaoImpl;
import domain.Address;
import domain.UserInfo;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @auther:houkexin
 * @date: 2018/8/2
 * @description:
 * @version: 1.0
 */
@WebServlet("/addressServlet")
public class AddressServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        PrintWriter pw = response.getWriter();
        AddressDao addressDao = new AddressDaoImpl();
        HttpSession session = request.getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        JSONObject json = new JSONObject();
        if (type.equals("list")){
            json.put("address",addressDao.queryById(userInfo.getId()));
            System.out.println(json.toString());
            pw.print(json.toString());
        }else if(type.equals("update")){
            Address address = new Address();
            address.setUser_id(userInfo.getId());
            address.setConsignee_name(request.getParameter("consignee"));
            address.setAddress(request.getParameter("address"));
            address.setZip_code(request.getParameter("zipcode"));
            address.setConsignee_phone(request.getParameter("mobile"));
            if (addressDao.update(address)){
                response.sendRedirect("address_list.html");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
