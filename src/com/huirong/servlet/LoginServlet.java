package com.huirong.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by huirong on 17-5-17.
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
//        super.doGet(req, resp);
        String encoding = getServletConfig().getInitParameter("encoding");
        resp.setCharacterEncoding(encoding);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<h1>用户登录<h1>");
        writer.println("<form action='/web/LoginClServlet' method='post'>");
        writer.println("用户名：<input type='text' name='username'/><br/>");
        writer.println("密  码：<input type='password' name='passwd'/><br/>");
        writer.println("<input type='submit' value='登录'/>");
        writer.println("</form>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
