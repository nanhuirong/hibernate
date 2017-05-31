package com.huirong.servlet;

import com.huirong.model.SendMail;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by huirong on 17-5-16.
 */
public class MyHttpServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
//        super.init();
//        Thread thread = new SendMail();
        Thread sendMail = new Thread(new SendMail());
        sendMail.start();
    }
    //对post和get提交分别进行处理


//    @Override
//    public ServletConfig getServletConfig() {
//        return super.getServletConfig();
//    }

    /**
     * 对post和get提交分别进行处理，HTTP默认Get提交
     *  post:post的安全性更高
     *      大小无限制(通常在64K以内)
     *      post会形成一个队列（不一定会立即响应）
     *  get:get提交的数据不大于2KB
     *      get请求要求服务器立即相应
     */


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
//        super.doGet(req, resp);
        //获取http请求信息
        String host = req.getHeader("Host");
        //获取用户来自哪里
        String referer = req.getHeader("Referer");
        if (referer == null){
            //跳转到错误页面
            resp.sendRedirect("");
        }
        String encoding = getServletConfig().getInitParameter("encoding");
        resp.setCharacterEncoding(encoding);
        resp.getWriter().println("get");
        //资源重定位,两种方法内部一致
        resp.sendRedirect("");

        resp.setStatus(302);
        resp.setHeader("Location", "");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
//        super.doPost(req, resp);
//        resp.getWriter().println("post" + req.getParameter("username"));
        doGet(req, resp);
    }
}
