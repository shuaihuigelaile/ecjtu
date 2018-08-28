package controller;

import dao.Shopping_trolleyDao;
import dao.impl.TrolleyDaoImpl;
import domain.Shopping_trolley;
import domain.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 页面点击加入购物车跳到本Servlet
 */
@WebServlet("/trolley")
public class TrolleyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //首先获取Session判断登录还是未登录
        HttpSession session = req.getSession();
        /*UserInfo userInfo1 = new UserInfo(1,"大小姐","XX@qq.com","XXX","XXX","3306","xi","女",null);
        session.setAttribute("userInfo",userInfo1);*/
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");

        //comId为传过来的商品信息表的ID,count为数量
        int comId = Integer.parseInt(req.getParameter("id"));
        int count = 1;

        //未登录状态，未登录状态用的是Cookie保存商品信息 ID
        if(userInfo == null){
            //拿到商品信息ID转成用“=ID”的形式保存，获取cookies,定义val之后用来得到cookie的value
            String str = "="+comId;
            Cookie[] cookies = req.getCookies();
            String val = null;

            //遍历cookies，如果存在键为comId的cookie,用val保存它的value
            //如果不存在，则val依然为空
            for(Cookie cookie:cookies){
                if(cookie.getName().equals("comId")){
                    val = cookie.getValue();
                    break;
                }
            }

            //如果val依然为空，说明cookie里面并没有保存购物车
            //此时就创建一个Cookie放进去，说明这是第一次加入购物车，val的值为“=ID”的形式
            if(val == null){
                Cookie cookie = new Cookie("comId",str);
                resp.addCookie(cookie);

            //如果不为空，说明之前有过添加购物车的记录，将本次商品的ID加载原来的末尾
            //形式为“=ID=ID”，再添加进去以覆盖原来的cookie
            }else {
                str = val + str;
                Cookie cookie = new Cookie("comId",str);
                resp.addCookie(cookie);
            }

        //已登录状态
        }else{
            //已登录状态下拿到用户信息的 ID,拿到商品信息的 ID,还有数量，创建一个购物车表对象接受这些信息
            int userId = userInfo.getId();
            Shopping_trolley stObject = new Shopping_trolley(userId,comId,count);

            // 拿购物车表对象对购物车表进行插入数据
            Shopping_trolleyDao st = new TrolleyDaoImpl();
            int f = st.selectTrolley(stObject.getUser_id(),stObject.getCommodity_id());
            if(f == 0){
                st.addTrolley(stObject);
            }else {
                System.out.println(f);
                stObject.setShopping_quantity(f+1);
                System.out.println(stObject.toString());
                boolean d = st.update(stObject);
                System.out.println(d);
            }
            //刷新本页面，改成提示框提示添加成功
        }
        resp.sendRedirect("/shopping_trolley.html");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
