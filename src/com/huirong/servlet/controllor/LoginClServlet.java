package com.huirong.servlet.controllor;

import com.huirong.servlet.view.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by huirong on 17-5-17.
 */
public class LoginClServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
//        super.doGet(req, resp);
        String encoding = getServletConfig().getInitParameter("encoding");
        resp.setCharacterEncoding(encoding);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        String username = req.getParameter("username");
        String passwd = req.getParameter("passwd");
        if ("nanhuirong".equals(username) && passwd.equals("201194")){
            //页面跳转 sendredirect转向 forward转发
            HttpSession session = req.getSession();
            User user = new User(username, passwd);
            session.setAttribute("user", user);
            resp.sendRedirect("/web/MainFrame");

        }else {
            resp.sendRedirect("/web/login");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
//        super.doPost(req, resp);
        doGet(req, resp);
    }
}
