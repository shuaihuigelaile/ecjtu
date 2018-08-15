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
		System.out.println("��ȡ���ļ�����"+name);*/
		//����mime����
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//�ϴ�Ŀ¼
		String dir=request.getServletContext().getRealPath("/upload");
		
		//׼���ϴ����ļ�
		Collection<Part>parts=request.getParts();
		//������ȡÿһ���ļ�
		//�����ļ��ϴ�
		if(parts.size()==1) {
			//��ȡ�ļ�����ļ���
		Part part= request.getPart("file");
		String header=part.getHeader("Content-Disposition");
		String fileName=FileUtil.getFileName(header);
		System.out.println(dir+File.separator+fileName);
		part.write(dir+File.separator+fileName);
		System.out.println("�ϴ��ĵ����ļ�");	
		}else {
			for (Part part : parts) {
				// ��ȡ�ļ���:form-data; name="file2"; filename="jd-gui.exe"
				String header=part.getHeader("Content-Disposition");
				String fileName=FileUtil.getFileName(header);
				//��ȡ�ļ���
				//xxxx/upload/�ļ���
				part.write(dir+File.separator+fileName);
				System.out.println("�ϴ�����ļ�");
			}
		}
		 //��ʾ�û��ϴ��ɹ�����ʧ��
		PrintWriter out=response.getWriter();
		out.println("�ϴ��ɹ�");
		out.flush();//�ַ���ˢ��
		out.close();//�ر���
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
