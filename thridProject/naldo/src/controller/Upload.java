package controller;

import dao.Commodity_imagesDao;
import dao.impl.Commodity_imagesDaoImpl;
import domain.Commodity_images;
import net.sf.json.JSONObject;
import util.FileUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

@WebServlet("/uploadImages")
@MultipartConfig(maxFileSize=5765004,fileSizeThreshold=1000)
public class Upload extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        boolean isSuccess = false;
        String dir = req.getServletContext().getRealPath("upload");
        int id = Integer.parseInt(req.getParameter("id"));
        System.out.println(id);
        Part part = null;
        try {
            part = req.getPart("upimage");
            String header = part.getHeader("Content-Disposition");
            String filename = FileUtil.getFileName(header);
            //st.insert(comId,filename);
            part.write(dir+ File.separator+filename);
            Commodity_images commodity_images = new Commodity_images();
            commodity_images.setPath(filename);
            commodity_images.setCommodity_id(id);
            Commodity_imagesDao imagesDao = new Commodity_imagesDaoImpl();
            if (imagesDao.add(commodity_images)){
                isSuccess = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }

        //System.out.println("fileSize:"+parts.size());
        //商品ID
       // int comId = 1;
       // Shopping_trolleyDao st = new TrolleyDaoImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        doGet(req, resp);
    }
}
