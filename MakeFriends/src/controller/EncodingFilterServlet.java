package controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class EncodingFilterServlet implements Filter {
     private String charset;
    //实例化
    public EncodingFilterServlet() {
        
    }

	//销毁
	public void destroy() {
		// TODO Auto-generated method stub
	}

	//处理请求
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//request.getParameter(name);
		HttpServletResponse res=(HttpServletResponse)response;
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding(charset);
		response.setCharacterEncoding(charset);
		res.setDateHeader("Expires", -1);
		res.setHeader("Cache-Control","no-cache");
		res.setHeader("Pragma","no-cache");
		System.out.println("************过滤之前");
		//继续往下执行
	   chain.doFilter(request, response);
	   System.out.println("************过滤之后");
	}

	//初始化
	public void init(FilterConfig fConfig) throws ServletException {
		charset=fConfig.getInitParameter("charset");
	}

}
