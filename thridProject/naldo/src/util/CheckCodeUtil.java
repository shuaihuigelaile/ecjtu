package util;

import net.sf.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/checkcode")
public class CheckCodeUtil extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			/*  request.setCharacterEncoding("utf-8");
			  response.setContentType("text/html;charset=utf-8"); */
			  PrintWriter out = response.getWriter(); 
			  //从session获取验证码 
			  HttpSession session=request.getSession(); 
			  String code=session.getAttribute("code").toString(); 
			  System.out.println(code); 
			  //获取用户输入验证码 
			  String input=request.getParameter("captcha");
			  System.out.println(input);
			  boolean isSuccess = false;
			  if(code.equalsIgnoreCase(input)){ 
			   //转发数据 
			    isSuccess = true;
			  }
                JSONObject json = new JSONObject();
			  json.put("result",isSuccess);
			  out.print(json.toString());
	}

}
