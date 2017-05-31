package com.huirong.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

public class MyFirstServlet implements Servlet{
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     *
     * @param servletRequest 请求
     * @param servletResponse 相应
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse)
            throws ServletException, IOException {
        System.out.println("hello, world" + new Date());
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.getWriter()
                .println("hello world!!! <font color=\"red\">北京</font><br/>"
                        + new Date());
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}