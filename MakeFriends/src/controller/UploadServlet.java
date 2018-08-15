package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import util.FileUtil;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/upload")
@MultipartConfig(maxFileSize=5765004,fileSizeThreshold=1000)
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*String name=request.getParameter("file");
		System.out.println("获取到文件名："+name);*/
		//设置mime类型
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//上传目录
		String dir=request.getServletContext().getRealPath("/upload");
		
		//准备上传的文件
		Collection<Part>parts=request.getParts();
		//遍历获取每一个文件
		//单个文件上传
		if(parts.size()==1) {
			//获取文件域的文件名
		Part part= request.getPart("file");
		String header=part.getHeader("Content-Disposition");
		String fileName=FileUtil.getFileName(header);
		System.out.println(dir+File.separator+fileName);
		part.write(dir+File.separator+fileName);
		System.out.println("上传的单个文件");	
		}else {
			for (Part part : parts) {
				// 获取文件名:form-data; name="file2"; filename="jd-gui.exe"
				String header=part.getHeader("Content-Disposition");
				String fileName=FileUtil.getFileName(header);
				//获取文件名
				//xxxx/upload/文件名
				part.write(dir+File.separator+fileName);
				System.out.println("上传多个文件");
			}
		}
		 //提示用户上传成功或者失败
		PrintWriter out=response.getWriter();
		out.println("上传成功");
		out.flush();//字符串刷新
		out.close();//关闭流
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
