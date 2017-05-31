package com.huirong.servlet.view;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by huirong on 17-5-17.
 */
public class DownServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
//        super.doGet(req, resp);
        String filename = req.getParameter("filename");
        String encoding = getServletConfig().getInitParameter("encoding");
        resp.setCharacterEncoding(encoding);
        resp.setHeader("Content-Disposition", "attachment;filename=" + filename);
        String path = getServletContext().getRealPath("/images/" + filename);
        FileInputStream is = new FileInputStream(path);
        byte[] buf = new byte[1024];
        int len = 0;
        OutputStream os = resp.getOutputStream();
        while ((len = is.read(buf)) > 0){
            os.write(buf, 0, len);
        }
        os.close();
        is.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
//        super.doPost(req, resp);
        doGet(req, resp);
    }
}
