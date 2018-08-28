package controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @auther:houkexin
 * @date: 2018/7/18
 * @description:
 * @version: 1.0
 */
public class EncodFilter implements Filter {
    private String charset;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse res=(HttpServletResponse)resp;
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding(charset);
        resp.setCharacterEncoding(charset);
        res.setDateHeader("Expires", -1);
        res.setHeader("Cache-Control","no-cache");
        res.setHeader("Pragma","no-cache");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
            charset = config.getInitParameter("charset");
    }

}
