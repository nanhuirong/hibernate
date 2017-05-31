package com.huirong.servlet.view;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

/**
 * Created by huirong on 17-5-17.
 */
public class MainFrame extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
//        super.doGet(req, resp);
        String encoding = getServletConfig().getInitParameter("encoding");
        resp.setCharacterEncoding(encoding);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        writer.println("<h1>主界面</h1>");
        writer.println(user.getUsername() + "\t" + user.getPasswd());
        writer.println("<a href='/web/login'>返回重新登录</a>");

        //下载文件
//        resp.setHeader("Content-Disposition", "attachment;filename=Hibernate产品介绍.png");
//        String path = getServletContext().getRealPath("/images/Hibernate产品介绍.png");
//        FileInputStream stream = new FileInputStream(path);
//        byte[] buf = new byte[1024];
//        int len = 0;
//        OutputStream outputStream = resp.getOutputStream();
//        while ((len = stream.read(buf)) > 0){
//            outputStream.write(buf, 0, len);
//        }
//        outputStream.close();
//        stream.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
//        super.doPost(req, resp);
        doGet(req, resp);
    }
}
