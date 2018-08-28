package controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/** 
* @author : yyh
* @date 创建时间：2018年7月10日 下午4:12:15 
* @version 1.0 
*/
public class MyRequest extends HttpServletRequestWrapper {

	public MyRequest(HttpServletRequest request) {
		super(request);
		
	}

	//改装了getParameter();
	@Override
	public String getParameter(String name) {
		String val=super.getParameter(name);
		System.out.println("替换前的内容"+val);
		
		String str=SensitiveWord.getfilteredStr(val);
		System.out.println("替换后的内容"+str);
		return str;
	}
	
}
